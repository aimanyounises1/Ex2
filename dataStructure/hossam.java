package dataStructure;

import algorithms.Graph_Algo;

public class hossam {

	public static void main(String[] args) {
		DGraph g=new DGraph();
		DGraph g1=new DGraph();

		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		NodeData d5 = new NodeData(5);
		g.addNode(d1);
		g.addNode(d2);
		g.addNode(d3);
	g.addNode(d4);
		g.addNode(d5);

		
	g.connect(1, 2, 3);
	g.connect(2, 1, 4);
	g.connect(3, 4, 5);
	g.connect(4,3, 7);
	g.connect(3,2, 4);
	g.connect(3,1, 5);
	g.connect(1,3, 2);
	g.connect(5, 1, 1);
	g.connect(1, 5, 5);
	
	Graph_Algo gg=new Graph_Algo();
	gg.init(g);
	gg.save("txt.txt");
	Graph_Algo ggg=new Graph_Algo();
	ggg.init("txt.txt");
	g1=(DGraph)ggg.copy();
	
	
	System.out.println(g1.getV());
	System.out.println(g.getV());

	}

}
