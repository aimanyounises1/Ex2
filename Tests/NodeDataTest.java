package Tests;


import static org.junit.Assert.*;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.EdgeData;



import org.junit.Test;

import utils.Point3D;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.EdgeData;
import algorithms.Graph_Algo;

public class NodeDataTest {
	NodeData data,data2,data3;
	@Test
	public void testNodeDataInt() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		data.setInfo("Info");
		data.setLocation(new Point3D(1, 2, 3));
		data.setTag(1);
		data.setWeight(10);
		NodeData copy = new NodeData(data);
		assertEquals(data.getKey(), copy.getKey());
		assertEquals(data.getInfo(), copy.getInfo());
		assertEquals(data.getLocation(), copy.getLocation());
		assertEquals(data.getTag(), copy.getTag());
		//assertEquals(data.getWeight(), copy.getWeight());
		data.setInfo("Other Info");
		data.setLocation(new Point3D(3, 2, 1));
		data.setTag(0);
		data.setWeight(20);
		assertEquals(data.getKey(), copy.getKey());
	     if(!data.getInfo().equals( copy.getInfo()))
			    fail("Should be euqls");

		if(!data.getLocation().equals(copy.getLocation()))
	    fail("Should be euqlas");

		assertEquals(data.getTag(), copy.getTag());
		assertEquals(data.getWeight(), copy.getWeight(),0.000001);
		
	}

	@Test
	public void testNodeData() {
		NodeData n = new NodeData(5);
		for(int i = n.getKey()+1; i<=50;i++) {
			NodeData node = new NodeData(i);
			assertEquals(i, node.getKey());
		}
	}
	@Test
	public void testGetLocation() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		Point3D node1_l = new Point3D(1, 2, 3);
		Point3D node2_l = new Point3D(4, 5, 6);
		data.setLocation(node1_l);
		System.out.println(data.getLocation().toString());
		data2.setLocation(node2_l);
		data3.setLocation(node1_l);

		assertEquals(node1_l, data.getLocation());
		assertEquals(node2_l, data2.getLocation());
		assertEquals(data.getLocation(), data3.getLocation());

	}

	@Test
	public void testSetLocation() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		Point3D node1_l = new Point3D(1, 2, 3);
		Point3D node2_l = new Point3D(4, 5, 6);
		data.setLocation(node1_l);
		System.out.println(data.getLocation().toString());
		data2.setLocation(node2_l);
		data3.setLocation(node1_l);

		assertEquals(node1_l, data.getLocation());
		assertEquals(node2_l, data2.getLocation());
		assertEquals(data.getLocation(), data3.getLocation());

	}
	@Test
	public void testGetInfo() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		String node1_i = "node1 Info";
		String node2_i = "node2 Info";
		
		data.setInfo(node1_i);
		data2.setInfo(node2_i);
		data3.setInfo(node1_i);
		
		assertEquals(node1_i, data.getInfo());
		assertEquals(node2_i, data2.getInfo());
		assertTrue(data.getInfo().equals(data3.getInfo()));
	}

	@Test
	public void testSetInfo() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		String node1_i = "node1 Info";
		String node2_i = "node2 Info";
		
		data.setInfo(node1_i);
		data2.setInfo(node2_i);
		data3.setInfo(node1_i);
		
		assertEquals(node1_i, data.getInfo());
		assertEquals(node2_i, data2.getInfo());
		assertTrue(data.getInfo().equals(data3.getInfo()));
	}

	@Test
	public void testGetTag() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		int node1_t = 0;
		int node2_t = 1;
		
		data.setTag(node1_t);
		data2.setTag(node2_t);
		data3.setTag(node1_t);
		
		assertEquals(node1_t, data.getTag());
		assertEquals(node2_t,data2.getTag());
		assertEquals(data.getTag(), data3.getTag());
	}

	@Test

	public void testSetTag() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		int node1_t = 0;
		int node2_t = 1;
		
		data.setTag(node1_t);
		data2.setTag(node2_t);
		data3.setTag(node1_t);
		
		assertEquals(node1_t, data.getTag());
		assertEquals(node2_t,data2.getTag());
		assertEquals(data.getTag(), data3.getTag());
	}
	@Test
	public void testEqual() {
		data = new NodeData();
		data2= new NodeData();
		data3 = new NodeData();
		data = new NodeData(5);
		NodeData n = data;
		NodeData copy = new NodeData(n);
		NodeData node20 = new NodeData(4);
		assertTrue(!n.equals(copy));
		assertFalse(n.equals(node20));
		assertFalse(copy.equals(node20));
	}


}
