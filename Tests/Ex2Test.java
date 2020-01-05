package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.*;
import dataStructure.*;
import utils.*;
import gui.*;

/**
 * EX2 Structure test:
 * 1. make sure your code compile with this dummy test (DO NOT Change a thing in this test). 
 * 2. the only change require is to run your GUI window (see line 64).
 * 3. EX2 auto-test will be based on such file structure.
 * 4. Do include this test-case in you submitted repository, in folder Tests (under src).
 * 5. Do note that all the required packages are imported - do NOT use other 
 * 
 * @author boaz.benmoshe
 *
 */
class Ex2Test {
	private static graph _graph;
	private static graph_algorithms _alg;
	public static final double EPS = 0.001; 
	private static Point3D min = new Point3D(0,0,0);
	private static Point3D max = new Point3D(100,100,0);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		_graph = tinyGraph();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConnectivity() {
		_alg = new Graph_Algo(_graph);
		boolean con = _alg.isConnected();
		if(!con) {
			fail("shoulbe be connected");
		}
	}
	@Test
	void testgraph() {
		boolean ans = drawGraph(_graph);
		assertTrue(ans);
	}
	
	private static graph tinyGraph() {
		graph ans = new DGraph();
		return ans;
	}
	boolean drawGraph(graph g) { 
		
		DGraph gg = new DGraph();
		Graph_Algo g1 = new Graph_Algo();


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

	







	 		











			



				Graph_GUI ggg=new Graph_GUI(gg);
			ggg.setVisible(true);
			
		return true;
		
	}

}