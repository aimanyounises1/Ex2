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
public class DGraph implements graph {
	// search by id and des 
	HashMap<Integer, EdgeData> inner;
	HashMap<Integer, HashMap<Integer,EdgeData>> edges = new HashMap<>();
	HashMap<Integer, NodeData> verticals = new HashMap<>();
	int changes;

	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		NodeData node = verticals.get(key);
		return node;
	}
	@Override
	
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		EdgeData e = null;
		if(edges.get(src)!=null) {
		 e =edges.get(src).get(dest);
		}
		return e;
	}
	@Override
	public void addNode(node_data n) {
		// TODO Auto-generated method stub
		NodeData d = (NodeData) n;
		verticals.put(d.getId(),d);
	}
	@Override
	public void connect(int src, int dest, double w) {
		// TODO Auto-generated met hod stub
		EdgeData edge = new EdgeData(src,dest,w);
		inner=edges.get(src);
		inner.put(dest, edge);
		edges.put(src, inner);
	}
	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		Collection<node_data> l = new ArrayList<>();
		Iterator it = verticals.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			NodeData d = (NodeData) mapElement.getValue();
			l.add(d);
		}
		return l;
	}
	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		NodeData d = verticals.get(key);
		edges.remove(key);
		Iterator<Map.Entry<Integer, HashMap<Integer,EdgeData>>> itr = edges.entrySet().iterator();

		while(itr.hasNext())
		{Map.Entry<Integer, HashMap<Integer,EdgeData>>entry=itr.next();
		if(entry.getValue().get(key)!=null)
		{entry.getValue().remove(key);
		
			
		}
		}
		return d;
	}
	@Override
	public edge_data removeEdge(int src, int dest) {
		EdgeData e = null;
		if(edges.get(src)!=null) {
			inner=edges.get(src);
			edges.remove(src);
			 e = inner.remove(dest);
			edges.put(src, inner);
		}
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
		return changes;
	}
	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		Collection<edge_data> l = new ArrayList<edge_data>();
		if(edges.get(node_id)!=null)
		{
		inner = edges.get(node_id);
		Iterator<Map.Entry<Integer, EdgeData>> itr = inner.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, EdgeData> entry = itr.next();
			l.add(entry.getValue());
		    }
			
		}
		return l;
	}

}