package testJunit;

import java.util.ArrayList;
import java.util.List;

public class ListSorter {
	
	private List<Airport> airports = new ArrayList<Airport>(10);
	
	public ListSorter() {
		for (int i = 0 ; i < 8 ; i++) {
			airports.add(new Airport());
		}
	}
	
	public static void main(String[] args) {
	}

	public int size() {
		return(this.airports.size());
	}
	
	public void move(int from, int to) {
		// No move if params the same.
		if (from == to) {
			return;
		}
		
		printAirports(">ls");

		// to is beyond airports.size
		if (to > this.airports.size()) {
			Airport fromAirport = this.airports.get(from);
			this.airports.remove(from);
			this.airports.add(fromAirport);
			return;
		}

		Airport fromAirport = airports.get(from);
		if (to > from) {
			this.airports.add(to + 1, fromAirport);
			airports.remove(from);
		}
		else {
			this.airports.add(to + 1, fromAirport);
			airports.remove(from+1);
		}
		printAirports("<ls");
	}
	
	public List<Airport> cloneAirports() {
		List<Airport> clone = new ArrayList<Airport>(airports.size());
		for (Airport item : airports) {
			clone.add(item);
		}
		return(clone);
	}

	public void printAirports(String s) {	
		Airport.printAirports(s + ": ls", this.airports);
	}

	public void close() {
		for (Airport a : airports) {
			a.close();
		}
		airports.removeAll(airports);
	}
}
