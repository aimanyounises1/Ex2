package dataStructure;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import utils.Point3D;

class EdgeData implements edge_data {
	int dest;
	int source;
	double weight;
	int tag;

	// Point3D c = new Point3D(dest.p.x()-1, dest.p.y()-1);
	EdgeData(int sor, int d) {
		this.dest = d;
		this.source = sor;
	
	}
	EdgeData(EdgeData other) {
		this.dest = other.dest;
		this.source = other.source;
		this.weight = other.weight;
	}

	public EdgeData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.source;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "(" + "weight is =" + this.weight + "source is =" + this.source + "destination is =" + this.dest;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = t;
	}

}
class NodeData implements node_data {
	int id;
	Point3D p;
	int tag;
	double weight;

	// a constructor
	NodeData(int id) {
		this.id = id;
		//this.tag = 0;
	}
	// copy construcor
	NodeData(NodeData other) {
		this.id = other.id;
	}

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return this.p;
	}

	@Override
	public void setLocation(Point3D p) {
		// TODO Auto-generated method stub
		this.p = p;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		this.weight = w;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s = "(" + this.id + "," + this.weight + "," + this.p.toString() + ")";
		return s;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub

	}
	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = t;
	}

}

public class DGraph implements graph {
	// search by id
	HashMap<Integer, NodeData> verticals = new HashMap<>();
	HashMap<Integer, EdgeData> edges = new HashMap<>();
	private NodeData d;

	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		NodeData node = verticals.get(key);
		return node;
	}
	@Override
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		int key = src/dest;
		EdgeData e = new EdgeData();
		e = edges.get(key);
		return e;
	}
	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		NodeData d = (NodeData) n;
		verticals.put(d.id, d);
	}

	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated method stub
		int key = src / dest;
		EdgeData edge = new EdgeData(src,dest);
		edge.weight = w;
		edges.put(key, edge);
	}
	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return  null;
	}
	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		NodeData save = verticals.get(key);
		verticals.remove(key);
		return save;
	}
	@Override
	public edge_data removeEdge(int src, int dest) {
		int key = src / dest;
		EdgeData e = edges.get(key);
		edges.remove(key);
		return e;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return verticals.size();
	}
	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return edges.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}