package dataStructure;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import utils.Point3D;
;
public class DGraph implements graph {
	// search by id and des 
	HashMap<Integer, HashMap<Integer,EdgeData>> edges = new HashMap<>();
	HashMap<Integer, NodeData> verticals = new HashMap<>();
	int changes;
	int edgecount;
	
	public DGraph() {
		this.verticals = new HashMap<Integer, NodeData>();
		this.edges = new HashMap<Integer, HashMap<Integer,EdgeData>>();
		this.edgecount=0;
		this.changes=0;
	}
	
	public DGraph(DGraph g) {
		this.verticals=g.verticals;
		this.edges=g.edges;
		this.changes=g.changes;
		this.edgecount=g.edgecount;
		
	}
	
	public DGraph(HashMap<Integer, NodeData> v,HashMap<Integer, HashMap<Integer,EdgeData>> edges,int counter) {
		this.verticals=v;
		this.edges=edges;
		this.edgecount=counter;
		this.changes=0;
	}
	

	@Override
	public node_data getNode(int key) {
		if(this.verticals.get(key)==null)
			return null;
		NodeData node = verticals.get(key);
		return node;
	}
	@Override
	
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		EdgeData e = null;
		if(edges.get(src).get(dest)==null) {
		 return null;
		}
		e =edges.get(src).get(dest);
		return e;
	}
	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		NodeData d = (NodeData) n;
		verticals.put(d.getId(),d);
		this.changes++;
	}
	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated met hod stub
		EdgeData edge = new EdgeData(src,dest,w);
		if(this.verticals.get(src)==null||this.verticals.get(dest)==null)
		{
			System.out.print("cant connect src or dest are not found in the graph");
			return;
		}
		
		if(this.edges.get(src)==null)
		{
			HashMap<Integer,EdgeData> e=new HashMap<Integer,EdgeData>();
			e.put(dest, edge);
			this.edges.put(src, e);
			this.changes++;
			this.edgecount++;
		}
		else
		{
			this.edges.get(src).put(dest, edge);
			this.changes++;
			this.edgecount++;
		}
	}
	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		Collection<node_data> l = (Collection<node_data>)this.verticals;
		
		return l;
	}
	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		if(this.verticals.get(key)==null)
		{
			return null;
		}
		NodeData d = verticals.get(key);
		int k=edges.get(key).size();
		
		edges.remove(key);
		this.edgecount=this.edgecount-k;
		this.changes=this.changes+k;
		Iterator<Map.Entry<Integer, HashMap<Integer,EdgeData>>> itr = edges.entrySet().iterator();

		while(itr.hasNext())
		{Map.Entry<Integer, HashMap<Integer,EdgeData>>entry=itr.next();
		if(entry.getValue().get(key)!=null)
		{entry.getValue().remove(key);
		
			this.edgecount--;
			this.changes++;
		}
		}
		return d;
	}
	@Override
	public edge_data removeEdge(int src, int dest) {
		EdgeData e = null;
		if(edges.get(src).get(dest)==null) 
			return null;


			e=this.edges.get(src).get(dest);
			edges.get(src).remove(dest);
			 this.changes++;
			 this.edgecount--;
		
		return e;
	}
	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return verticals.size();
	}
	@Override
	public int edgeSize() {
		return this.edgecount;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return changes;
	}
	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		Collection<edge_data>l=(Collection<edge_data>)this.edges.get(node_id);
		return l;
	}

}