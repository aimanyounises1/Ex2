package dataStructure;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import utils.Point3D;
public class DGraph implements graph {
	// search by id and des 
	HashMap<Integer, EdgeData> inner = new HashMap<>();
	private HashMap<Integer, HashMap<Integer, EdgeData>> edges;
	private HashMap<Integer, NodeData> verticals;
	int changes;

	public DGraph(DGraph g) {
		this.verticals = g.verticals;
		this.edges =  g.edges;
		
	}
	public DGraph() {
		// TODO Auto-generated constructor stub
		verticals = new HashMap<>();
		edges = new HashMap<>();
	}
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		if(verticals.get(key)==null) {
			System.out.print("Sorry buddy  there is no Node with that key");
			
		}
		node_data node = getVerticals().get(key);
		return node;
	}
	@Override
	
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		edge_data e = null;
		if(getEdges().get(src)!=null) {
		 e =getEdges().get(src).get(dest);
		}
		return e;
	}
	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		NodeData d = (NodeData) n;
		getVerticals().put(d.getId(),d);
		changes++;
	}
	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated met hod stub
		if(verticals.get(src)==null||verticals.get(dest)==null) {
		throw new RuntimeException("Cant connect this two nodes one or both of them is not exit");
		}else {
		EdgeData edge = new EdgeData(src,dest,w);
		inner = new HashMap<>();
		inner.put(dest,edge);
		edges.put(src, inner);
		changes++;
		}
	}
	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		Collection<node_data> l = new ArrayList<>();
		for (node_data data : verticals.values()) {
			l.add(data);
		}
		return l;
	}
	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		node_data d = getVerticals().get(key);
		getEdges().remove(key);
		Iterator<Entry<Integer, HashMap<Integer, EdgeData>>> itr = getEdges().entrySet().iterator();

		while(itr.hasNext())
		{Entry<Integer, HashMap<Integer, EdgeData>>entry=itr.next();
		if(entry.getValue().get(key)!=null)
		{entry.getValue().remove(key);
		
			changes++;
		}
		}
		return d;
	}
	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data e = null;
		if(getEdges().get(src)!=null) {
			inner=getEdges().get(src);
			getEdges().remove(src);
			 e = inner.remove(dest);
			getEdges().put(src, inner);
			changes++;
		}
		return e;
	}
	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return getVerticals().size();
	}
	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return getEdges().size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return changes;
	}
	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		if(verticals.get(node_id) == null) {
			throw new RuntimeException("Nice One Tricky Asshole ;)");
		}
		Collection<edge_data> l = new ArrayList<edge_data>();
		if(getEdges().get(node_id)!=null)
		{
		inner = edges.get(node_id);
		for (EdgeData edge : inner.values()) {
			l.add(edge);
		}
			
		}
		return l;
	}
	public HashMap<Integer, NodeData> getVerticals() {
		return verticals;
	}
	public void setVerticals(HashMap<Integer, NodeData> verticals) {
		this.verticals = verticals;
	}
	public HashMap<Integer, HashMap<Integer,EdgeData>> getEdges() {
		return edges;
	}
	public void setEdges(HashMap<Integer, HashMap<Integer, EdgeData>> edges) {
		this.edges = edges;
	}

}