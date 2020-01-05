package dataStructure;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import algorithms.Graph_Algo;
import gui.Graph_GUI;
import utils.Point3D;

public class hosam {

	public static void main(String[] args) {
		DGraph gg=new DGraph();
		DGraph g1=new DGraph();

		NodeData d0 = new NodeData(0);
		NodeData d1 = new NodeData(1);
		NodeData d2 = new NodeData(2);
		NodeData d3 = new NodeData(3);
		NodeData d4 = new NodeData(4);
		NodeData d5 = new NodeData(5);
		gg.addNode(d1);
		gg.addNode(d2);
		gg.addNode(d3);
	gg.addNode(d4);
		gg.addNode(d5);

		
	gg.connect(1, 2, 3);
	gg.connect(2, 1, 4);
	gg.connect(3, 4, 5);
	gg.connect(4,3, 7);
	gg.connect(3,2, 4);
	gg.connect(3,1, 5);
	gg.connect(1,3, 2);
	gg.connect(5, 1, 1);
	gg.connect(1, 5, 5);
	
	Graph_Algo ggg=new Graph_Algo();
	ggg.init(gg);
	ggg.save("txt.txt");
	Graph_Algo gggg=new Graph_Algo();
	gggg.init("txt.txt");
	g1=(DGraph)gggg.copy();










			

System.out.print(g1.getV());

System.out.print(gg.getV());

}











	}



