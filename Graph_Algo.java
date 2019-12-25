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

DGraph
public class Graph_Algo implements graph_algorithms {
	
	DGraph g = new DGraph();
	
	public void init(graph g) {
		if(g instanceof DGraph)
		this.g = (DGraph) g;
		else
			throw new RuntimeException("not instance of DGraph");
		
		
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
	
	}
	private void neigh(int u,Collection<edge_data> l) {
		
	}
	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return new DGraph(this.g);
	}

}
