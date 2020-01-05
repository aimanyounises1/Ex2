package Tests;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.node_data;


public class DGraphTest {
	@BeforeClass
	public static void init() throws Exception {
		DGraph g;
		g= new DGraph();
		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		g.addNode(d0);
		g.addNode(d1);
		g.addNode(d2);
		g.addNode(d3);
		g.addNode(d4);
		g.connect(1, 2, 3);
		g.connect(2, 1, 4);
		g.connect(3, 4, 5);
		g.connect(4,3, 7);
		g.connect(3,2, 4);
		g.connect(3,1, 5);
		g.connect(1,3, 2);
	}

	
	@Test
	 public void testGetNode() {
		//fail("Not yet implemented");
		//node_data d = 
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		g.removeNode(1);
		g.removeNode(2);
		//g.removeNode(4);
		assertTrue(g.getNode(1)==null);
		assertTrue(g.getNode(2)==null);
		assertTrue(g.getNode(3)!=null);
	}
	

	@Test
	  public void testGetEdge() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		NodeData a = new NodeData(g.nodeSize()+1);
		NodeData b = new NodeData(g.nodeSize()+1);
		g.addNode(a);
		g.addNode(b);
		double w = 12;
		g.connect(a.getId(), b.getId(), w);
		assertTrue(g.getEdge(a.getId(), b.getId())!=null);
	}

	@Test
	public void testAddNode() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		NodeData a = new NodeData(g.nodeSize()+1);
		NodeData b = new NodeData(g.nodeSize()+1);
		g.addNode(a);
		g.addNode(b);
		assertTrue(g.getNode(a.getId())!=null);
		assertTrue(g.getNode(b.getId())!=null);
		
	}

	@Test
	public void testConnect() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		NodeData a = new NodeData(g.nodeSize()+1);
		NodeData b = new NodeData(g.nodeSize()+1);
		g.addNode(a);
		g.addNode(b);
		double weight =12;
		EdgeData orgin = new EdgeData(a.getId(), b.getId(), weight);
		g.connect(a.getId(), b.getId(), weight);
		edge_data e = g.getEdge(a.getId(), b.getId());
		assertEquals(e.getSrc(), orgin.getSrc());
		assertEquals(e.getDest(), orgin.getDest());
	}

	@Test
	public void testGetV() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		Collection<node_data> data = g.getV();
		assertEquals(g.nodeSize(), data.size());
		
	}
	@Test
	public void testRemoveNode() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		int size = g.nodeSize();
		int removed = 2 ;
		for(int i = 0; i < removed ; i++) {
			g.removeNode(i);
		}
		assertEquals(size, g.nodeSize()+removed);
	}
	private DGraph initFactory(DGraph g) {
		// TODO Auto-generated method stub
		g= new DGraph();
		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		g.addNode(d0);
		g.addNode(d1);
		g.addNode(d2);
		g.addNode(d3);
		g.addNode(d4);
		g.connect(1, 2, 3);
		g.connect(2, 1, 4);
		g.connect(3, 4, 5);
		g.connect(4,3, 7);
		g.connect(3,2, 4);
		g.connect(3,1, 5);
		g.connect(1,3, 2);
		return g;
	}
	@Test
	public void testRemoveEdge() {
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		node_data new_node0 = new NodeData(300);
		node_data new_node1 = new NodeData(400);
		g.addNode(new_node0);
		g.addNode(new_node1);
		
		g.connect(new_node0.getKey(), new_node1.getKey(), 100);
		int edges_before = g.edgeSize();
		
		g.removeEdge(new_node0.getKey(), new_node1.getKey());
		int edges_after = g.edgeSize();

		assertEquals(edges_before-1 , edges_after);
	}

	@Test
	public void testNodeSize() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		Collection<node_data> data = g.getV();
		assertEquals(g.nodeSize(),data.size());
	}

	@Test
	public void testEdgeSize() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		int edgeSizes =0;
		for (node_data data : g.getV()) {		
			edgeSizes += g.getE(data.getKey()).size();
		}
		assertEquals(g.edgeSize(),edgeSizes);
		
	}

	@Test
	public void testGetMC() {
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		int size = g.getMC();	
		NodeData d6 = new NodeData(g.nodeSize()+1);
		g.addNode(d6);
		size = size + 1;
		g.removeNode(d6.getId());
		size = size + 1;
		assertEquals(g.getMC(), size);
	}
	@Test
	public void testGetE() {
		//fail("Not yet implemented");
		DGraph g1 = null;
		DGraph g = initFactory(g1);
		int actual_edges = 0;
		for (node_data node : g.getV()) {
			Collection <edge_data> edges = g.getE(node.getKey());
			if (edges != null)
				actual_edges += edges.size();
		}
		System.out.println(actual_edges);
		System.out.println(g.edgeSize());
		assertEquals(g.edgeSize(), actual_edges);
	}
	
	
}
