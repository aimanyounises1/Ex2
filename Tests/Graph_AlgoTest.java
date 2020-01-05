package Tests;
import static org.junit.Assert.*;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import gui.Graph_GUI;
import dataStructure.EdgeData;
import algorithms.Graph_Algo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
	
	
	@Test
	public void saveinitfile() {
		DGraph gg=new DGraph();
		DGraph g1=new DGraph();

		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		NodeData d5 = new NodeData(5);
		gg.addNode(d1);
		gg.addNode(d2);
		gg.addNode(d3);
	gg.addNode(d4);
		gg.addNode(d5);

		
	gg.connect(1, 2, 3);
	gg.connect(2, 1, 4);
	gg.connect(3, 4, 5);
	gg.connect(4,3, 7);
	gg.connect(3,2, 4);
	gg.connect(3,1, 5);
	gg.connect(1,3, 2);
	gg.connect(5, 1, 1);
	gg.connect(1, 5, 5);
	
	Graph_Algo ggg=new Graph_Algo();
	ggg.init(gg);
	ggg.save("txt.txt");
	Graph_Algo gggg=new Graph_Algo();
	gggg.init("txt.txt");
	g1=(DGraph)gggg.copy();
	boolean t=false;
for(node_data n:gg.getV())
	if(g1.getNode(n.getKey())==null)
	    fail("nodes Should be equals");

	for(node_data n:g1.getV())
		for(edge_data e:g1.getE(n.getKey()))
		{
			for(edge_data e1:gg.getE(n.getKey()))
				if(e1.equals(e))
				{
					t=true;
					break;
				}
			if(t=false)
			    fail("edges Should be equals");

		}

	



}
	
	
	@Test
	public void TSPtest() {
		DGraph gg = new DGraph();
		Graph_Algo g1 = new Graph_Algo();
		Graph_Algo g2 = new Graph_Algo();


		Graph_GUI graph;
		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		NodeData d5 = new NodeData(5);
		gg.addNode(d1);
		gg.addNode(d2);
		gg.addNode(d3);
	gg.addNode(d4);
		gg.addNode(d5);

		
	gg.connect(1, 2, 3);
	gg.connect(2, 1, 4);
	gg.connect(3, 4, 5);
	gg.connect(4,3, 7);
	gg.connect(3,2, 4);
	gg.connect(3,1, 5);
	gg.connect(1,3, 2);
	gg.connect(5, 1, 1);
	gg.connect(1, 5, 5);
	g1.init(gg);

	






		
	ArrayList <Integer>arr=new ArrayList<Integer>();
	arr.add(1);
	arr.add(2);
	arr.add(3);
	
	ArrayList <node_data>arr2=new ArrayList<node_data>();
	ArrayList <node_data>arr3=(ArrayList<node_data>)g1.TSP(arr);
	arr3.add(d1);
	arr3.add(d3);
	arr3.add(d2);
	
	for(int i=0;i<arr2.size();i++)
		if(arr2.get(i)!=arr3.get(i))
		    fail("nodes Should be equals");

		

	

     	 		

	}
	
	
	
	
}