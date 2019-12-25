package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_GUI extends JFrame implements ActionListener,MouseListener{
		graph g;
	 public Graph_GUI() {
		// TODO Auto-generated constructor stub
		 initGUI();
			
		}

		public Graph_GUI(DGraph g) {
		// TODO Auto-generated constructor stub
			this.g = g;
			initGUI();
	}

		private void initGUI() {
		// TODO Auto-generated method stub
			 this.setSize(1000, 450);
			 this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setTitle("The Maze of Waze");
				MenuBar menuBar = new MenuBar();
				Menu menu = new Menu("Menu");
				menuBar.add(menu);
				this.setMenuBar(menuBar);
				
				MenuItem item1 = new MenuItem("ShortestPath");
				item1.addActionListener(this);
				
				MenuItem item2 = new MenuItem("isConnected");
				item2.addActionListener(this);

				menu.add(item1);
				menu.add(item2);
				
				this.addMouseListener(this);
		
	}

		public void paint(Graphics g1)
		{
			super.paint(g1);
			Collection<node_data> d = g.getV();Collection <edge_data> edges;
			Point3D p;
			Point3D dis;
			String s;
			super.paint(g1);
			for (node_data data : d) 
			{
				p = data.getLocation();
				//drawing the nodes
					g1.setColor(Color.BLUE);
				    g1.fillOval((int)p.x(), (int)p.y(), 20, 20);
				
				if(g.getE(data.getKey())!=null)
				{
					edges = g.getE(data.getKey());
					// draws edges and directions
					for (edge_data edge : edges) {
						dis = g.getNode(edge.getDest()).getLocation();
						g1.setColor(Color.RED);
						g1.drawLine((int)p.x(), (int)p.y(), 
								(int)dis.x(), (int)dis.y());
						//writting the directions of the edges
						g1.setColor(Color.YELLOW);
						g1.drawOval(dis.ix(), dis.iy(), 20, 20);
						s = Double.toString(edge.getWeight());
						g1.drawString(s, (p.ix()+dis.ix())/2, (dis.iy()+p.iy())/2);
						
					}
					
				}
				
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		switch (str) {
		case "algorithms":
			
			break;
		case "isConnected" :
			break;
		case "ShortestPath":
		break;
		case "StartGraph":
			break;
		case "Tsp":
			break;
		case "Copy":
			break;
		case "Save":
			break;
		case "Load":
			break;
		default:
			break;
		}

		
	}

}
