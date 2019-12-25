import dataStructure.DGraph;
import dataStructure.NodeData;
import gui.Graph_GUI;
import utils.Point3D;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DGraph g = new DGraph();
		 Graph_GUI graph;
		for(int i =0 ;i <= 10 ; i++) {
			NodeData d = new NodeData(i, i*i,new Point3D(i,i));
			g.addNode(d);
			System.out.println(d.getInfo());
		}
		for(int i = 0; i < 9;i++) {
			NodeData a = (NodeData) g.getNode(i);
			g.connect(i,i+1,a.getWeight());
			
		}
		 graph = new Graph_GUI(g);

	}

}
