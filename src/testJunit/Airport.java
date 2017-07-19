package testJunit;

import java.util.List;

public class Airport {
	private static Integer classId; 

	private String name;
	private Integer id;
	
	public Airport() {
		if (null == Airport.classId) {
			classId = new Integer(0);
		}
		this.id = Airport.classId++;
		this.name = new String(name + id);
	}
	
	public void close() {
		this.name = null;
		Airport.classId--;
	}
	
	Integer getId() {
		return(this.id);
	}

	public static void printAirports(String info, List<Airport> clone) {
		System.out.print(info + ": airport=");
		for (Airport a : clone) {
			System.out.print(a.getId() + "_" + a.getName() + " ");
		}
		System.out.println();
	}

	private String getName() {
		return this.name;
	}
}
