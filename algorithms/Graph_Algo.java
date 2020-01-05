package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import dataStructure.DGraph;
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


public class Graph_Algo implements graph_algorithms, Serializable {
	public graph g;
	public graph g1;

	public void init(graph g) {
		if (g instanceof DGraph) {
			this.g = (DGraph) g;
			this.g1 = g;

		} else
			throw new RuntimeException("not instance of DGraph");

	}

	public Graph_Algo() {
		this.g = new DGraph();
	}

	@Override
	public void init(String file_name) {

		// Read objects
		try {
			FileInputStream fi = new FileInputStream(new File(file_name));
			ObjectInputStream oi = new ObjectInputStream(fi);
			this.init((graph) oi.readObject());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");

		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save(String file_name) {
		try {
			FileOutputStream f = new FileOutputStream(new File(file_name));
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Write objects to file
			o.writeObject(this.g);
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}

	}

	public void checkneigh(node_data i) {
		g.getNode(i.getKey()).setTag(2);
		if (g.getE(i.getKey()) != null) {

			for (edge_data k : g.getE(i.getKey())) {
				if (g.getEdge(i.getKey(), k.getDest()) != null && g.getNode(k.getDest()).getTag() == 0)
					g.getNode(k.getDest()).setTag(1);
			}
		}

	}

	private boolean alltag() {
		for (node_data n : g.getV())
			if (n.getTag() != 2)
				return false;
		return true;
	}

	public boolean cont() {
		for (node_data n : g.getV())
			if (n.getTag() == 1)
				return true;
		return false;
	}

	@Override
	public boolean isConnected() {
		for (node_data nn : g.getV()) {
			for (node_data n : g.getV())
				//mark all nodes as un visited
				n.setTag(0);
			g.getNode(nn.getKey()).setTag(2);
			checkneigh(nn);
			while (cont()) {
				for (node_data x : g.getV()) {

					if (x.getTag() == 1)
						checkneigh(x);
				}
			}

			if (alltag() != true)
				return false;

		}
		for (node_data n : g.getV())
			n.setTag(0);

		return true;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		// we start by setting src weight to zero
		if (g1.getNode(src) == null || g1.getNode(dest) == null) {
			throw new RuntimeException("One or two of nodes is not found in graph");
		}
		ResetWieght(g1);
		g1.getNode(src).setWeight(0);
		// set all tags to zero
		setTags(g1.getV());
		ArrayList<NodeData> l = Convert(g1.getV());
		l.add((NodeData) g1.getNode(src));
		while (!l.isEmpty()) {
			NodeData Smallest = FindMin(l);
			neigh(Smallest, l);
			l.remove(Smallest);
		}
		// reset the info
		ResetInfo(g1);
		// return the shortest path weight
		return g1.getNode(dest).getWeight();
	}
// a function to reset all weights for evert vertex in graph after using the algorithms(shortespath..etc)
	private void ResetWieght(graph g1) {
		// TODO Auto-generated method stub
		for (node_data data : g1.getV()) {

			data.setWeight(Integer.MAX_VALUE);
		}

	}
// reverse all the tags to zero to use the shortest path again,hence is zero represents not visited
	// vertex in graph
	private void setTags(Collection<node_data> v2) {
		// TODO Auto-generated method stub
		for (node_data data : v2) {
			data.setTag(0);
		}
	}

	private void neigh(NodeData Vert, ArrayList<NodeData> vertexes) {
		double Weight = 0;
		if (Vert != null)
			for (edge_data e : g1.getE(Vert.getId())) {
				if (g1.getNode(e.getSrc()).getTag() != 1) {
					// weight is now the vertex weight + edge weight
					// NodeData d = (NodeData) g1.getNode(e.getDest());
					Weight = g1.getNode(Vert.getId()).getWeight() + e.getWeight();
					// if weight is smaller than dest vertex weight then vertex weight is the new
					// weight g.getNode(e.getDest()()).setWeight(Weight);
					if (g1.getNode(e.getDest()).getWeight() >= Weight) {
						g1.getNode(e.getDest()).setWeight(Weight);
						// the previous vertex of this current vertex
						g1.getNode(e.getDest()).setInfo(String.valueOf(e.getSrc()));
					}
					// we add the vertex to the list because its not visited
					vertexes.add((NodeData) g1.getNode(e.getDest()));
				}
			}
		g1.getNode(Vert.getId()).setTag(1);
	}
// we convert the collection to arraylist because its easy to handle with,this function is used in
	//shortest path destination
	private ArrayList<NodeData> Convert(Collection<node_data> v2) {
		// TODO Auto-generated method stub
		ArrayList<NodeData> l = new ArrayList<>();
		for (node_data v : v2) {
			NodeData d = (NodeData) v;
			l.add(d);
		}
		return l;
	}
// a function to find node associated with minimum weight because java util priority queue don't support 
	//us in this case
	private NodeData FindMin(ArrayList<NodeData> v) {
		// TODO Auto-generated method stub
		NodeData d = v.get(0);
		for (NodeData vert : v) {
			if (d.getWeight() > vert.getWeight()) {
				d = vert;
			}
		}
		return d;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		// we used stack to reverse the path between src and des
		// graph g2 = this.g1;
		Stack<node_data> s = new Stack<>();
		// the returned array list
		ArrayList<node_data> path = new ArrayList<>();
		// we use shortest path function to know the path
		shortestPathDist(src, dest);
		// the prev vertex of src vertex is src :)
		g1.getNode(src).setInfo(String.valueOf(g1.getNode(src).getKey()));
		String source = g1.getNode(dest).getInfo();
		node_data a = g1.getNode(dest);
		path.add(g1.getNode(src));
		while (!a.getInfo().equals(g1.getNode(src).getInfo())) {
			a = g1.getNode(Integer.valueOf(source));
			s.push(a);
			source = g1.getNode(Integer.valueOf(source)).getInfo();
		}
		// we used stack to reverse the path to the node that we came from
		while (!s.isEmpty()) {
			a = s.pop();
			path.add(a);
		}
		path.add(g1.getNode(dest));
		// return the info of every node in graph
		return path;
	}
// a function to reset info of every vertex
	private void ResetInfo(graph g1) {
		// TODO Auto-generated method stub
		for (node_data data : g1.getV()) {
		data.setInfo(g.getNode(data.getKey()).getInfo());
		}
	}

	private DGraph trans2(List<Integer> targets) {
		DGraph d = new DGraph();
		for (int nn : targets) {
			if (g.getNode(nn) == null)
				throw new RuntimeException("a node in this list is not contained in the graph");
			NodeData n = new NodeData((NodeData) g.getNode(nn));
			d.addNode(n);

		}
		for (node_data nn : d.getV())
			if (g.getE(nn.getKey()) != null)
				for (edge_data e : g.getE(nn.getKey())) {
					if (targets.contains(e.getDest()))
						d.connect(nn.getKey(), e.getDest(), e.getWeight());

				}

		return d;
	}

	private boolean allnottag(DGraph d) {
		for (node_data n : d.getV()) {
			if (n.getTag() != 1)
				return true;
		}

		return false;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		DGraph d = trans2(targets);
		DGraph d2 = new DGraph(d);
		double min2 = 0;
		double min3 = Double.MAX_VALUE;
		double min;
		Graph_Algo x = new Graph_Algo();
		List<node_data> ar = new ArrayList<node_data>();
		ArrayList<node_data> arr = new ArrayList<node_data>();
		ArrayList<node_data> a = new ArrayList<node_data>();
		x.init(d);
		if (!x.isConnected()) {
			System.out.print("nodes are not connected");
			return null;
		}
		for (node_data n : d2.getV()) {
			for (node_data nn : d2.getV())
				nn.setTag(0);
			for (node_data nn : d.getV())
				nn.setTag(0);
			arr.removeAll(arr);
			min2 = 0;
			int i3 = 0;
			d2.getNode(n.getKey()).setTag(1);
			d2.getNode(n.getKey()).setTag(1);
			int i2 = n.getKey();
			arr.add(n);
			while (allnottag(d2)) {
				min = Double.MAX_VALUE;
				for (node_data f : d.getV()) {
					if (d2.getNode(f.getKey()).getTag() != 1) {
						if (x.shortestPathDist(i2, f.getKey()) < min) {
							min = x.shortestPathDist(i2, f.getKey());
							i3 = f.getKey();
							ar = shortestPath(i2, i3);
							ar.remove(0);

						}
					}
				}
				min2 = min2 + min;
				d2.getNode(i3).setTag(1);
				arr.addAll(ar);
				ar.removeAll(ar);
				i2 = i3;
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

		return new DGraph((DGraph) this.g);
	}

}
