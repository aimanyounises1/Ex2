package Tests;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;
public class Graph_AlgoTest {
	Graph_Algo g;
	graph d;
	@Before
	public void testInitGraph() {
		g = new Graph_Algo();
		DGraph g1 = new DGraph();
		//Graph_Algo g1 = new Graph_Algo();
		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		g1.addNode(d0);
		g1.addNode(d1);
		g1.addNode(d2);
		g1.addNode(d3);
		g1.addNode(d4);
		g1.connect(1, 2, 3);
		g1.connect(2, 1, 4);
		g1.connect(3, 4, 5);
		g1.connect(4,3, 7);
		g1.connect(3,2, 4);
		g1.connect(3,1, 5);
		g1.connect(1,3, 2);
		
		g.init(g1);
	}

	@Test
	public void testSave() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsConnected() {
		//DGraph d = null;
		init();
		assertFalse(g.isConnected());		
	}

	private void init() {
		// TODO Auto-generated method stub
		g = new Graph_Algo();
		DGraph g1 = new DGraph();
		//Graph_Algo g1 = new Graph_Algo();
		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		g1.addNode(d0);
		g1.addNode(d1);
		g1.addNode(d2);
		g1.addNode(d3);
		g1.addNode(d4);
		g1.connect(1, 2, 3);
		g1.connect(2, 1, 4);
		g1.connect(3, 4, 5);
		g1.connect(4,3, 7);
		g1.connect(3,2, 4);
		g1.connect(3,1, 5);
		g1.connect(1,3, 2);
		d = g.copy();
		g.init(g1);
	}
	@Test
	public void testShortestPathDist() {
		//DGraph d = null;
		 init();
		double a = g.shortestPathDist(1, 3);
		 double b = g.shortestPathDist(3, 2);
		 double c =g.shortestPathDist(2, 4);
		 double z = g.shortestPathDist(1, 3);
		 assertFalse(a==b);
		 assertFalse(a==c);
		 assertFalse(c==b);
		 assertTrue(a==z);	 
	}
	@Test
	public void testShortestPath() {
		//DGraph d = null;
		 init();
		List <node_data> list = g.shortestPath(1, 3);
		List <node_data> list2 = g.shortestPath(3, 2);
		List <node_data> list3= g.shortestPath(2, 4);
		List <node_data> list4 = g.shortestPath(1, 3);
		assertFalse(list.equals(list2));
		assertFalse(list2.equals(list3));
		assertFalse(list.equals(list3));
		assertTrue(list4.equals(list));
	}
	@Test
	public void testTSP() {
		//fail("Not yet implemented");
	}
	@Test
	public void testCopy() {
		graph g1;
		init();
		g1 =  g.copy();
		for (node_data data : d.getV()) {
			assertTrue(data.getKey()==g1.getNode(data.getKey()).getKey());
		}
	}
}