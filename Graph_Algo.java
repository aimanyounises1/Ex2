package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 * @param <DGraph>
 *
 */
public class Graph_Algo implements graph_algorithms {
	DGraph g = new DGraph();
	double[] dis;
	HashMap<Integer, NodeData> nodes;
	Collection<node_data> list;
	Collection<edge_data> l = new LinkedList<>();
	private Set<Integer> settled;
	PriorityQueue<NodeData> q = new PriorityQueue<NodeData>();
	List<node_data> prev;
	public void init(graph g) {
		// TODO Auto-generated method stub
		this.g = (DGraph) g;
		NodeData d;
		list = g.getV(); 
		Iterator t=list.iterator();
		while(t.hasNext()) {
			d = (NodeData) t.next();
			nodes.put(d.getId(), d);
		}
		
	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}
	
	private  HashMap<Integer,NodeData> transfer()
	{ HashMap<Integer,NodeData>h=new HashMap<Integer,NodeData>();
	h=g.verticals;
   	 
    
    return h;
		
	}
	
	public void setzero(HashMap<Integer,NodeData> m)
	{
		Iterator<Map.Entry<Integer, NodeData>> itr = m.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, NodeData>d=itr.next();
			d.getValue().setTag(0);
		}

	}

	public void checkNode(NodeData d,HashMap<Integer,NodeData> n)
	{
		
			HashMap<Integer,EdgeData>m=g.edges.get(d.getId());
			Iterator<Map.Entry<Integer, EdgeData>> itr = m.entrySet().iterator();
			

			while(itr!=null)
			{
				Map.Entry<Integer, EdgeData>entry=itr.next();
				
				n.get(entry.getValue().getDest()).setTag(1);
				
				
			}
			


		
		
	}
	@Override
	public boolean isConnected() {
    HashMap<Integer,NodeData> l=transfer();
    int c=0;
	Iterator<Map.Entry<Integer, NodeData>> itr = l.entrySet().iterator();
	while(itr.hasNext())
	{
		  setzero(l);
		  c=0;

		Map.Entry<Integer, NodeData>entry=itr.next();
		entry.getValue().setTag(1);
        checkNode(entry.getValue(),l);

	Iterator<Map.Entry<Integer, NodeData>> itr2 = l.entrySet().iterator();
	
	while(itr2.hasNext())
	{
		Map.Entry<Integer, NodeData>entry2=itr2.next();
		if(entry2.getValue().getTag()==1)
		{
			checkNode(entry2.getValue(),l);
		}
	}
	
	Iterator<Map.Entry<Integer, NodeData>> itr3 = l.entrySet().iterator();
	while(itr3.hasNext())
	{
		Map.Entry<Integer, NodeData>etr=itr3.next();
		if(etr.getValue().getTag()==1)
			c++;
	}
	if(c<l.size())
		return false;


	}
	return true;
	

	}

    
     
	

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		int n = g.nodeSize();
		dis = new double[n];
		l = g.getE(src);
		for (int i = 0; i < dis.length; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[src] = 0;
		q.add((NodeData) g.getNode(src));
		while(settled.size() != g.nodeSize()) {
			int u = q.remove().getId();
			settled.add(u);
			neigh(u,l);
		}
		return dis[dest];
	}
	private void neigh(int u,Collection<edge_data> l) {
		// TODO Auto-generated method stub
		Iterator<edge_data> t = l.iterator();
		double edgeWeight = -1;
		double newWeight = -1;
		EdgeData e;
		NodeData d;
		while(t.hasNext()) {	
		e = (EdgeData) t.next();
		d = nodes.get(e.getDest());
		if(!settled.contains(d.getId())) {
			edgeWeight = e.getWeight();
			newWeight = dis[u]+edgeWeight;
			if(newWeight<dis[d.getId()]) {
				dis[d.getId()] = newWeight;
				prev.add(d);
			}
			q.add(new NodeData (d.getId(),dis[d.getId()]));
			
		}
		}		
	}
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		shortestPathDist(src,dest);
		return prev;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return this.g;
	}

}
