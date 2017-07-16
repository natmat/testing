package testJunit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListSorterTest {
	
	private static ListSorter ls;

	@Before
	public void setUpBefore() throws Exception {
		ls = new ListSorter();
	}
	
	@After
	public void closeAfter() {
		ls.close();
	}
	
	@Test
	public void testSetup() {
		assertEquals(8, ls.size());
	}
	
	@Test
	public void testMove0to0() {		
		List<Airport> clone = ls.cloneAirports();

		// No change
		ls.move(0, 0);
		assertTrue(clone.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove0to1() {
		List<Airport> clone = ls.cloneAirports();

		// Move 0 to index 1 
		Airport tmp = clone.get(1);
		clone.set(1,  clone.get(0));
		clone.set(0, tmp);
		Airport.printAirports("cl",  clone);

		ls.printAirports(">testMove0to1");
		ls.move(0, 1);
		ls.printAirports("<testMove0to1");
		assertTrue(clone.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1to0() {		
		List<Airport> clone = ls.cloneAirports();

		// Move 1 to index 0 
		Airport tmp = clone.get(0);
		clone.set(0,  clone.get(1));
		clone.set(1, tmp);
		Airport.printAirports("cl", clone);

		ls.printAirports(">testMove1to0");
		ls.move(0, 1);
		ls.printAirports("<testMove1to0");
		assertTrue(clone.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1toEnd() {		
		ls.printAirports(">testMove1toEnd");
		List<Airport> clone = ls.cloneAirports();

		// Move 1 to index size-1
		int from = 1;
		Airport fromAirport = clone.get(from);
		final int to = clone.size() - 1;
		clone.add(to, fromAirport);
		clone.remove(from);
		Airport.printAirports("cl", clone);

		ls.move(1, ls.size() - 1);
		ls.printAirports("<testMove1toEnd");
		Airport.printAirports("clone", clone);
		assertTrue(clone.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1toBeyondEnd() {		
		ls.printAirports(">testMove1toBeyondEnd");
		List<Airport> clone = ls.cloneAirports();

		// Move 1 to index beyond size-1 
		int from = 1;
		int to = clone.size() + 10;
		
		Airport moveAirport = clone.get(from);
		clone.remove(from);
		clone.add(moveAirport);
		Airport.printAirports("cl", clone);

		ls.move(from, to);
		ls.printAirports("<testMove1toBeyondEnd");
		assertTrue(clone.equals(ls.cloneAirports()));
	}
}
