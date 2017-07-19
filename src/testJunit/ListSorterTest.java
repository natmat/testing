package testJunit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListSorterTest {
	
	private static ListSorter uutListSorter;

	@Before
	public void setUpBefore() throws Exception {
		uutListSorter = new ListSorter();
	}
	
	@After
	public void closeAfter() {
		uutListSorter.close();
	}
	
	@Test
	public void testAirportsSize() {
		assertEquals(8, uutListSorter.size());
	}
	
	@Test
	public void testMove0to0() {		
		List<Airport> expect = uutListSorter.cloneAirports();
		int from, to;
		from = to = 0;
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	@Test
	public void testMove0to1() {
		List<Airport> expect = uutListSorter.cloneAirports();
		int from = 0;
		int to = 1;
		this.setupExpect(expect, from, to);
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	@Test
	public void testMove1to0() {		
		List<Airport> expect = uutListSorter.cloneAirports();
		int from = 1;
		int to = 0;
		setupExpect(expect, from, to);
		
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	@Test
	public void testMove1toEnd() {		
		List<Airport> expect = uutListSorter.cloneAirports();
		int from = 1;
		int to = expect.size()-1; // end
		Airport fromAirport = expect.remove(from);
		expect.add(to, fromAirport);
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	private void setupExpect(final List<Airport> expect, int from, int to) {
		Airport toAirport = expect.get(to);
		expect.set(to, expect.get(from));
		expect.set(from, toAirport);
	}

	@Test
	public void testMove1to4() {		
		List<Airport> expect = uutListSorter.cloneAirports();
		// before: 0,1,2,3,4,5,...
		// after:  0,2,3,4,1,5,...
		final int from = 1;
		final int to = 4;
		Airport fromAirport = expect.remove(from);
		expect.add(to, fromAirport);
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	@Test
	public void testMove4to1() {		
		List<Airport> expect = uutListSorter.cloneAirports();
		// before: 0,1,2,3,4,5,...
		// after:  0,4,1,2,3,5,...
		final int from = 4;
		final int to = 1;
		Airport fromAirport = expect.remove(from);
		expect.add(to, fromAirport);
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}

	@Test
	public void testMove1toBeyondEnd() {
		List<Airport> expect = uutListSorter.cloneAirports();
		int from = 1;
		int to = expect.size() + 10;
		// Special handling, can't use setupExpect() method
		Airport fromAirport = expect.get(from);
		expect.remove(from);
		expect.add(fromAirport);
		uutListSorter.move(from, to);
		assertTrue(expect.equals(uutListSorter.cloneAirports()));
	}
}
