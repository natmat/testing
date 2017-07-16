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
		List<Airport> expect = ls.cloneAirports();
		int from, to;
		from = to = 0;
		ls.move(from, to);
		assertTrue(expect.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove0to1() {
		List<Airport> expect = ls.cloneAirports();
		int from = 0;
		int to = 1;
		this.setupExpect(expect, from, to);
		ls.move(from, to);
		assertTrue(expect.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1to0() {		
		List<Airport> expect = ls.cloneAirports();
		int from = 1;
		int to = 0;
		setupExpect(expect, from, to);
		
		ls.move(from, to);
		assertTrue(expect.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1toEnd() {		
		List<Airport> expect = ls.cloneAirports();
		int from = 1;
		int to = expect.size()-1; // end
		Airport fromAirport = expect.remove(from);
		expect.add(to, fromAirport);
		ls.move(from, to);
		assertTrue(expect.equals(ls.cloneAirports()));
	}

	private void setupExpect(final List<Airport> expect, int from, int to) {
		Airport toAirport = expect.get(to);
		expect.set(to, expect.get(from));
		expect.set(from, toAirport);
	}

	@Test
	public void testMove1to4() {		
		List<Airport> expect = ls.cloneAirports();
		final int from = 1;
		final int to = 4;
		Airport fromAirport = expect.remove(from);
		expect.add(to, fromAirport);
		ls.move(from, to);
		Airport.printAirports("expect", expect);
		assertTrue(expect.equals(ls.cloneAirports()));
	}

	@Test
	public void testMove1toBeyondEnd() {
		List<Airport> expect = ls.cloneAirports();
		int from = 1;
		int to = expect.size() + 10;
		// Special handling, can't use setupExpect() method
		Airport fromAirport = expect.get(from);
		expect.remove(from);
		expect.add(fromAirport);
		ls.move(from, to);
		assertTrue(expect.equals(ls.cloneAirports()));
	}
}
