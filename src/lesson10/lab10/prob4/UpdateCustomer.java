package lesson10.lab10.prob4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class UpdateCustomer {
	private String select = "SELECT name, street, city, RTRIM(zip) as zip FROM Customer WHERE LTRIM(zip) like '5%' and LENGTH(TRIM(ZIP)) = 5";
	private String selectCurCust = "SELECT * FROM Customer";
	private String update = "UPDATE CUSTOMER SET zip = ?  WHERE name = ?";
	private String insert = "INSERT INTO CUSTOMER (name, street, city, zip) "
			+ "VALUES (?, ?, ?, ?)";

	private static final Logger LOG = Logger.getLogger(UpdateCustomer.class
			.getName());
	private List<Customer> custs = new ArrayList<Customer>();

	public void updateZips() throws SQLException {
		// Step 1: Get Connection, manage using try-with-resournces
		try (Connection conn = ConnectManager.getConnection()) {

			try {
				// Step 2: Use Connection to create PreparedStatements
				PreparedStatement stat = conn.prepareStatement(select);
				ResultSet rs = stat.executeQuery();

				custs = populateCustomer(rs);
				List<UpdateData> updateDataList = prepareUpdateInfo(custs);
				List<PreparedStatement> statsList = new ArrayList<PreparedStatement>();
				for (UpdateData update : updateDataList) {
					PreparedStatement updateStatement = prepareUpdateQuery(
							update, conn);
					statsList.add(updateStatement);
				}
				// Step 3: begin transaction
				conn.setAutoCommit(false);

				// Step 4: execute queries
				for (PreparedStatement updateStatement : statsList) {
					performUpdate(updateStatement);
				}

				// Step 5: commit (if queries fail, this line won't execute)
				conn.commit();
			} catch (SQLException e) {
				// Step 5: if an operation fails, rollback
				conn.rollback();
				// log exception
				StringBuilder sb = new StringBuilder();

				// SQLException now implements Iterable, so
				// it is possible to iterate through chained
				// exceptions like this
				for (Throwable t : e) {
					sb.append("+ " + e.getMessage() + "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			} finally {
				// Step 6: restore default state of autoCommit (no cleanup
				// necessary)
				conn.setAutoCommit(true);
				conn.close();
			}
		}
	}

	public List<Customer> getCurCustomers() throws SQLException {
		List<Customer> curCusts = new ArrayList<Customer>();
		// Step 1: Get Connection, manage using try-with-resournces
		try (Connection conn = ConnectManager.getConnection()) {

			try {
				// Step 2: Use Connection to create PreparedStatements
				PreparedStatement stat = conn.prepareStatement(selectCurCust);
				ResultSet rs = stat.executeQuery();

				curCusts = populateCustomer(rs);
			} catch (SQLException e) {
				// log exception
				StringBuilder sb = new StringBuilder();

				// SQLException now implements Iterable, so
				// it is possible to iterate through chained
				// exceptions like this
				for (Throwable t : e) {
					sb.append("+ " + e.getMessage() + "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			} finally {
				// Step 6: restore default state of autoCommit (no cleanup
				// necessary)
				conn.close();
			}
		}
		return curCusts;
	}

	public List<Integer> insertCustomer(List<Customer> custs)
			throws SQLException {
		List<Integer> IDList = new ArrayList<Integer>();
		List<PreparedStatement> statList = new ArrayList<PreparedStatement>();
		int generatedKey = -1;
		// Step 1: Get Connection, manage using try-with-resournces
		try (Connection conn = ConnectManager.getConnection()) {

			try {
				// Step 2: Use Connection to create PreparedStatements
				List<Customer> curCusts = getCurCustomers();
				Map<String, Customer> map = new HashMap<String, Customer>();
				for (Customer cust : custs) {
					map.put(cust.getName().trim() + cust.getZip(), cust);
				}
				List<Customer> newList = new ArrayList<Customer>(map.values());

				for (Customer cust : newList) {
					int count = 0;
					for (Customer curCust : curCusts) {
						if (!(cust.getName().equals(curCust.getName()))
								&& !(cust.getZip().equals(curCust.getZip()))) {
							count++;
						}
						else{
							break;
						}

					}
					if (count == curCusts.size()) {
						PreparedStatement insertStatement = prepareCustInsertQuery(
								cust, conn);
						statList.add(insertStatement);
					}
				}

				// Step 3: begin transaction
				conn.setAutoCommit(false);

				// Step 4: execute queries
				for (PreparedStatement insertStatement : statList) {
					generatedKey = performInsert(insertStatement);
					IDList.add(generatedKey);
				}

				// Step 5: commit (if queries fail, this line won't execute)
				conn.commit();
			} catch (SQLException e) {
				// Step 5: if an operation fails, rollback
				conn.rollback();
				// log exception
				StringBuilder sb = new StringBuilder();

				// SQLException now implements Iterable, so
				// it is possible to iterate through chained
				// exceptions like this
				for (Throwable t : e) {
					sb.append("+ " + e.getMessage() + "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			} finally {
				// Step 6: restore default state of autoCommit (no cleanup
				// necessary)
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return IDList;
	}

	private List<UpdateData> prepareUpdateInfo(List<Customer> custs) {
		List<UpdateData> retval = new ArrayList<UpdateData>();
		for (Customer c : custs) {
			UpdateData upData = new UpdateData(c.getName(), c.getZip()
					.replaceAll("^\\s+", "") + "-1000");
			retval.add(upData);
		}

		return retval;
	}

	private PreparedStatement prepareCustInsertQuery(Customer cust,
			Connection conn) throws SQLException {
		// to get the autogenerated key, we must include the extra parameter
		// here
		PreparedStatement insertStatement = conn.prepareStatement(insert,
				Statement.RETURN_GENERATED_KEYS);
		insertStatement.setString(1, cust.getName());
		insertStatement.setString(2, cust.getStreet());
		insertStatement.setString(3, cust.getCity());
		insertStatement.setString(4, cust.getZip());
		return insertStatement;

	}

	private int performInsert(PreparedStatement stmt) throws SQLException {
		stmt.executeUpdate();

		int key = -1;
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			key = rs.getInt(1);
			LOG.info("Generated key for auto_increment id column after insert: "
					+ key);
		} else {
			LOG.info("No generated key for " + stmt.toString());
		}

		return key;
	}

	private void performUpdate(PreparedStatement stmt) throws SQLException {
		stmt.execute();
	}

	private PreparedStatement prepareUpdateQuery(UpdateData ud, Connection conn)
			throws SQLException {
		PreparedStatement updateStatement = conn.prepareStatement(update);
		updateStatement.setString(1, ud.getZip());
		updateStatement.setString(2, ud.getName());
		return updateStatement;
	}

	private List<Customer> populateCustomer(ResultSet rs) throws SQLException {
		List<Customer> custs = new ArrayList<Customer>();
		String name = null;
		String street = null;
		String city = null;
		String zip = null;
		while (rs.next()) {
			name = rs.getString("name").trim();
			street = rs.getString("street").trim();
			city = rs.getString("city").trim();
			zip = rs.getString("zip").trim();
			custs.add(new Customer(name, street, city, zip));
		}
		return custs;
	}
}
