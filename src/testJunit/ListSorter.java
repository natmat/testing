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
		Airport fromAirport = null;
		if (from < to) {
			fromAirport = this.airports.remove(from);
			if (to > airports.size()) {
				this.airports.add(fromAirport);
			}
			else {
				this.airports.add(to, fromAirport);
			}
		}
		else if (to < from) {
			fromAirport = this.airports.remove(from);
			this.airports.add(to, fromAirport);
		}
		else {
			// do nothing if from==to
		}
	}
	
	public List<Airport> cloneAirports() {
		List<Airport> clone = new ArrayList<Airport>(airports.size());
		for (Airport item : airports) {
			clone.add(item);
		}
		return(clone);
	}

	public void printAirports(String s) {	
		Airport.printAirports(s, this.airports);
	}

	public void close() {
		for (Airport a : airports) {
			a.close();
		}
		airports.removeAll(airports);
	}
}
