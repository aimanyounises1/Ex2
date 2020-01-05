package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataStructure.EdgeData;

public class EdgeDataTest {
	EdgeData orgin = new EdgeData(1,2, 15);
	int source = 1;
	int dest = 2;
	double weight = 15;
	@Test
	public void testSetInfo() {
		orgin.setInfo("Hello");
		assertTrue(orgin.getInfo().equals("Hello"));
	}

	@Test
	public void testGetSrc() {
	assertEquals(orgin.getSrc(),source);
	}

	@Test
	public void testGetDest() {
		assertEquals(orgin.getDest(),dest);

	}

	@Test
	public void testGetWeight() {
		assertTrue(orgin.getWeight()==weight);
	}

	@Test
	public void testGetInfo() {
		String s = "hello";
		orgin.setInfo(s);
		System.out.println(orgin.getInfo());
		assertTrue(orgin.getInfo().equals(s));
	}

	@Test
	public void testGetTag() {
		orgin.setTag(1);
		assertTrue(orgin.getTag()==1);
	}

	@Test
	public void testSetTag() {
		orgin.setTag(0);
		assertTrue(orgin.getTag()==0);
	}

}
