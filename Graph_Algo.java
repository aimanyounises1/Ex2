package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
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
import utils.Point3D;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 * @param <DGraph>
 *
 */


public class Graph_Algo implements graph_algorithms {	
	DGraph g;
	graph g1;
	int V;
	public void init(graph g) {
		if(g instanceof DGraph)
		{
		this.g = (DGraph) g;
		this.g1 = g;
		
		 V = g.getV().size();
		}
		else
			throw new RuntimeException("not instance of DGraph");
		
		
	}
	
	public Graph_Algo() {
		this.g=new DGraph();
	}

	@Override
	public void init(String file_name) {
		try {
			File file = new File(file_name);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String []lines;
			line=br.readLine();
			line=line.substring(7);
			if(line!=""||line!=null||line!="\n")
			{
				lines=line.split(",");
				for(int i=0;i<lines.length;i++)
				{
					if(lines[i]!="\n"|lines[i]!=" ")
					{
						double x=Math.random()*501+1;
						double y=Math.random()*501+1;
						Point3D p=new Point3D(x,y);
						int id=Integer.parseInt(lines[i]);

						NodeData n=new NodeData(id,y, p);
						this.g.addNode(n);
					}
					
					
				}
			}
			
			line=br.readLine();
			line=line.substring(7);
			int i=0;
			 
				while(line.length()>1)
				{
					 i=line.indexOf("(");
					String s="";
					i++;
					while(line.charAt(i)!=',')
					{
						s=s+line.charAt(i);
						i++;
					}
					int x=Integer.parseInt(s);
					i++;
					s="";
					while(line.charAt(i)!=',')
					{
						s=s+line.charAt(i);
						i++;
					}
					int y=Integer.parseInt(s);
					i++;
					s="";
					while(line.charAt(i)!=')')
					{
						s=s+line.charAt(i);
						i++;
					}
					i++;
					double z = Double.parseDouble(s);
					
					this.g.connect(x, y, z);
					line=line.substring(i);
					
					
					
				}
			

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void save(String file_name) {
		try {
			PrintWriter printwriter = new PrintWriter(new File(file_name));
			StringBuilder s = new StringBuilder();
			s.append("Nodes: ");
			for(int i:g.verticals.keySet())	{
				NodeData n = g.verticals.get(i);		
				s.append(n.getKey()+",");
			}
			s=s.deleteCharAt(s.length()-1);
			s.append("\n");
			s.append("Edges: ");
			for(int i:this.g.edges.keySet()) {
				for(int j:this.g.edges.get(i).keySet()) {
					
					s.append("("+i+","+j+","+g.edges.get(i).get(j).getWeight()+")"+",");
				}
			}
			s=s.deleteCharAt(s.length()-1);
			s.append("\n");
				
			
		
			printwriter.write(s.toString());
			printwriter.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		

	}
	
	
	private void checkneigh(HashMap<Integer,NodeData>h,int i)
	{
		if(this.g.edges.get(i)!=null)
		{
		for(int k:this.g.edges.get(i).keySet())
		{
			h.get(k).setTag(1);
		}
		}
			
	}
    
	
	private void setzero(HashMap<Integer,NodeData>h)
	{
		for(int k:h.keySet())
			h.get(k).setTag(0);
	}
	
	private boolean alltag(HashMap<Integer,NodeData>h)
	{
		for(int i:h.keySet())
		{
			if(h.get(i).getTag()!=1)
				return false;
		}
		return true;
	}

	@Override
	public boolean isConnected() {
		HashMap<Integer,NodeData>h=new HashMap<Integer,NodeData>();
		for(int i:this.g.verticals.keySet())
			h.put(i, this.g.verticals.get(i));
			

		for(int i:h.keySet())
		{
			setzero(h);
			h.get(i).setTag(1);
			checkneigh(h, i);
			for(int k:h.keySet())
			{
				if(h.get(k).getTag()==1)
					checkneigh(h, k);

			}
			if(alltag(h)!=true)
				return false;
		}
		return true;
	}
	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		g1.getNode(src).setWeight(0);
		setTags(g.getV());
		System.out.println(g1.getNode(src).getWeight());
		ArrayList <NodeData> l = Convert(g1.getV());
		l.add((NodeData) g1.getNode(src));
		while(!l.isEmpty()) {
			NodeData Smallest = FindMin(l);
			neigh(Smallest,l);
			l.remove(Smallest);
		}
			return g1.getNode(dest).getWeight();
	}
	private void setTags(Collection<node_data> v2) {
		// TODO Auto-generated method stub
		for (node_data data : v2) {
			data.setTag(0);
		}
		
	}
	private void neigh (NodeData Vert,ArrayList<NodeData> vertexes) {
		double Weight = 0 ;
		for (edge_data e : g1.getE(Vert.getId())) {
			//NodeData d = (NodeData) g.getNode(e.getSrc());
			if(g1.getNode(e.getSrc()).getTag()!= 1) {
				//weight is now the vertex weight + edge weight
					Weight = g1.getNode(Vert.getId()).getWeight() + e.getWeight();
					// if weight is smaller than dest vertex weight then vertex weight is weight					g.getNode(e.getDest()()).setWeight(Weight);
					if(g1.getNode(e.getDest()).getWeight() >= Weight) {
						g1.getNode(e.getDest()).setWeight(Weight);
					}		
					// we add the vertex to the list because its not visited
					vertexes.add((NodeData) g1.getNode(e.getDest()));
			}
			
			}
			g1.getNode(Vert.getId()).setTag(1);
	}
	private ArrayList<NodeData> Convert(Collection<node_data> v2) {
		// TODO Auto-generated method stub
		ArrayList<NodeData> l = new ArrayList<>();
		for(node_data  v:v2) {
			NodeData d = (NodeData) v;
			l.add(d);
		}
		return l;
	}

	private NodeData FindMin(ArrayList<NodeData>v) {
		// TODO Auto-generated method stub
		NodeData d = v.get(0);
		for (NodeData vert : v ) {
			if(d.getWeight() > vert.getWeight()) {
				d =  vert;
			}
		}
		return d;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}
    private DGraph trans2(List<Integer> targets)
    {		DGraph d= new DGraph();

    	for(int i : targets)
		{if(g.verticals.get(i)==null)
			
		throw new RuntimeException("a node in this list is not contained in the graph");
		
		d.verticals.put(i,this.g.verticals.get(i));
		
		for(int k:targets)
		{
			if(this.g.edges.get(i)!=null)
			{
				if(this.g.edges.get(i).get(k)!=null)
				{
					d.connect(i, k,this.g.edges.get(i).get(k).getWeight() );
					
				}
			}
		}
		}
    	return d;
    }
    
    private boolean allnottag(DGraph d)
    {
    	for(int i:d.verticals.keySet())
    	{
    		if(d.verticals.get(i).getTag()!=1)
    			return true;
    	}
    	
    		return false;
    }
	@Override
	public List<node_data> TSP(List<Integer> targets) {
		DGraph d = trans2(targets);
		double min2 = 0;
		double min3 = Double.MAX_VALUE;
		Graph_Algo x = new Graph_Algo();
		ArrayList<node_data> a = new ArrayList<node_data>();
		x.init(d);

		if (x.isConnected() == false) {
			throw new RuntimeException("nodes are not connected");

		}
		for (int i : d.verticals.keySet()) {
			DGraph d2 = new DGraph(d);
			d2.verticals.get(i).setTag(1);
			int i2 = i;
			int i3 = 0;
			double min = Double.MAX_VALUE;

			ArrayList<node_data> arr = new ArrayList<node_data>();

			arr.add(d.verticals.get(i));
			while (allnottag(d2)) {
				for (int k : d.verticals.keySet()) {
					if (k != i2 && d2.verticals.get(k).getTag() != 1) {
						if (x.shortestPathDist(i2, k) < min) {
							min = x.shortestPathDist(i2, k);
							i3 = k;
						}
					}

				}
				i2 = i3;
				d2.verticals.get(i2).setTag(1);
				arr.add(d.verticals.get(i2));
				min2 = min2 + min;

			}
			if (min2 < min3) {
				min3 = min2;
				a = new ArrayList<node_data>(arr);

			}
		}
		return a;
	}
	@Override
	public graph copy() {
		
		return new DGraph(this.g);
	}

}
