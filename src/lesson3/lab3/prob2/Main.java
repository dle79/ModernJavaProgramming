package lesson3.lab3.prob2;

public class Main {

	public static void main(String[] args) {
		Building b1 = new Building(300);
		b1.addApartment(new Apartment(700));
		b1.addApartment(new Apartment(850));
		b1.addApartment(new Apartment(750));

		Building b2 = new Building(200);
		b2.addApartment(new Apartment(550));
		b2.addApartment(new Apartment(650));
		b2.addApartment(new Apartment(700));
		b2.addApartment(new Apartment(490));

		Landlord ll = new Landlord("Bob");
		ll.addBuilding(b1);
		ll.addBuilding(b2);

		System.out.println("Monthly total profit of landlord " + ll.getName()
				+ " is: " + ll.calculateMonthlyTotalProfit());

	}

}
