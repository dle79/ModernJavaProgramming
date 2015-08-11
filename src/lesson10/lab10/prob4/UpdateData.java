package lesson10.lab10.prob4;

/** Special immutable data structure that 
 *  stores update data for Customer table 
 */
public class UpdateData {
	private final String name;
	
	private final String zip;
	public UpdateData(String n, String z) {
		name = n;
		zip = z;
	}
	public String getName() {
		return name;
	}
	public String getZip() {
		return zip;
	}
}
