package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class Graph_GUI extends JFrame implements ActionListener,MouseListener{
		DGraph g;
		boolean button = true;
		Graph_Algo graph ;
		node_data src;
		node_data des;
		 private boolean ShortestPath;
		List<node_data> path;
		double x;
		double y;
		private boolean connected;
		private boolean ShortestPathList;
		private boolean TSP,TSPDONE;
		private boolean removeNode;
		private boolean AddNode;
		private boolean removeEdge;
		private boolean addEdge;
		private boolean t=false;
		ArrayList<Integer>arr;
		double click = 0;
		double clickPath =0;
		//double xD;
		//double yD;
	 public Graph_GUI() {
		 initGUI();
			
		}
//constructor to init a graph
		public Graph_GUI(DGraph g) {
			this.graph = new Graph_Algo();
			this.g = new DGraph(g);
			graph.init(g);
			initGUI();
					
	}
		//initianting the window menue bar
	private void initGUI() {
		this.setSize(750, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu2 = new JMenu("Menue");

		JMenu menu = new JMenu("Edit");
		JMenu menubar = new JMenu("Algorithms");
		menuBar.add(menu2);

		menuBar.add(menu);
		menuBar.add(menubar);
		this.setJMenuBar(menuBar);

		JMenuItem item2 = new JMenuItem("TSP");
		item2.addActionListener(this);
		JMenuItem item12 = new JMenuItem("TSP Done");
		item12.addActionListener(this);
		JMenuItem item3 = new JMenuItem("isConnected");
		item3.addActionListener(this);

		JMenuItem item4 = new JMenuItem("save");
		item2.addActionListener(this);
		JMenuItem item5 = new JMenuItem("Shortest Path");
		item5.addActionListener(this);

		JMenuItem item6 = new JMenuItem("Shortest Path List");
		item6.addActionListener(this);
		JMenuItem item7 = new JMenuItem("Delete Node");
		item7.addActionListener(this);
		JMenuItem item8 = new JMenuItem("Add Node");
		item8.addActionListener(this);
		JMenuItem item9 = new JMenuItem("Remove Edge");
		item9.addActionListener(this);
		JMenuItem item10 = new JMenuItem("Load");
		item10.addActionListener(this);
		JMenuItem item11 = new JMenuItem("Add Edge");
		item11.addActionListener(this);

		JMenuItem item21 = new JMenuItem("save");
		item21.addActionListener(this);
		JMenuItem item22 = new JMenuItem("load");
		item22.addActionListener(this);
		JMenuItem item23 = new JMenuItem("save Image");
		item23.addActionListener(this);
		menu2.add(item21);
		menu2.add(item22);

		menu2.add(item23);

		menu.add(item7);
		menu.add(item8);
		menu.add(item9);
		menu.add(item11);
		menubar.add(item2);
		menubar.add(item6);
		menubar.add(item3);
		menubar.add(item4);
		menubar.add(item5);
		menubar.add(item10);
		menubar.add(item12);

		this.addMouseListener(this);

	}

	public void paint(Graphics g1) {
		Graphics2D g2 = (Graphics2D) g1;
		super.paint(g2);
		for (node_data n : this.g.getV()) {////// chek in the end about getV
			g2.setColor(Color.BLUE);
			int x = n.getLocation().ix();
			int y = n.getLocation().iy();
			g2.fillOval(x, y, 14, 14);

			g2.setColor(Color.black);
			g2.setFont(new Font("Arial", Font.BOLD, 13));
			g2.drawString(n.getKey() + "", x + 16, y + 16);

			if (g.getE(n.getKey()) != null) {
				for (edge_data edge : g.getE(n.getKey())) {
					if (this.g.getNode(edge.getDest()) != null) {
						Point3D p = this.g.getNode(edge.getDest()).getLocation();
						int x1 = p.ix();
						int y1 = p.iy();
						g2.setColor(Color.RED);
						g2.setStroke(new BasicStroke(2));
						g2.drawLine(x + 2, y + 2, x1 + 7, y1 + 7);
						g2.setFont(new Font("Arial", Font.BOLD, 15));
						g2.setColor(Color.RED);
						g2.drawString("" + edge.getWeight(), (int) (x + x1) / 2 - 5, (int) ((y + y1) / 2 - 5));
						g2.setColor(Color.yellow);
						x1 = (int) ((((x + x1) / 2 + x1) / 2 + x1) / 2 + x1) / 2;
						y1 = (int) ((((y + y1) / 2 + y1) / 2 + y1) / 2 + y1) / 2;
						g2.fillOval(x1, y1, 10, 10);
					}
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.x = e.getX();
		this.y = e.getY();
		double path1;
		Point3D p = new Point3D(this.x, this.y);
		if (this.ShortestPath) {
			System.out.println(this.ShortestPath);
			if (this.click == 0) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.src = data;
					}
				}
			}
			if ((this.click == 1)) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.des = data;
					}
				}
			}
			this.click++;
			if (this.click == 2) {
				// this.click = 0
				if (src != null || des != null) {
					path1 = graph.shortestPathDist(this.src.getKey(), this.des.getKey());
					// System.out.println(path1);
					JLabel label = new JLabel("The Path Weight = " + Double.toString(path1));
					label.setFont(new Font("Arial", Font.BOLD, 20));
					JOptionPane.showMessageDialog(this, label);
					repaint();
					this.src = null;
					this.des = null;
					this.ShortestPath = false;
					this.click = 0;
				} else {
					throw new RuntimeException("You did't clicked one of nodes");
				}
			}
		}
		if (this.AddNode) {
			// NodeData d = new NodeData(p);
			ArrayList<Integer> arr2 = new ArrayList<Integer>();
			NodeData nn = new NodeData();
			for (node_data n : g.getV())
				arr2.add(n.getKey());
			for (int i : arr2) {
				if (!arr2.contains(i + 1)) {
					nn = new NodeData(i + 1, p);
				}
			}
			g.addNode(nn);
			repaint();
			this.AddNode = false;

		}

		if (this.removeNode) {
			for (node_data data : g.getV()) {
				if (p.distance2D(data.getLocation()) < 25) {
					this.src = data;
					// System.out.println(src.getKey());
					g.removeNode(src.getKey());

				}
			}
			this.src = null;
			repaint();
		}
		if (this.ShortestPathList) {
			// this.click = 0;
			// System.out.println("click is = "+click);
			if (this.click == 0) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.src = data;
					}
				}
			}
			if ((this.click == 1)) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.des = data;
					}
				}
			}
			this.click++;
			if (this.click == 2) {
				// this.clickPath = 0;
				String result = "";
				path = new ArrayList<>();
				System.out.println("src id is = " + this.src.getKey() + "des id is = " + this.des.getKey());
				path = graph.shortestPath(this.src.getKey(), this.des.getKey());
				for (node_data data : path) {
					result += data.getKey() + "->";
				}
				result = result.substring(0, result.length() - 2);
				JLabel label = new JLabel("The Path is = " + result);
				label.setFont(new Font("Arial", Font.BOLD, 20));
				JOptionPane.showMessageDialog(this, label);
				this.src = null;
				this.des = null;
				this.click = 0;
				this.ShortestPathList = false;
			}
		}

		if (this.addEdge) {
			if (this.click == 0) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.src = data;
					}
				}
			}
			if ((this.click == 1)) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.des = data;
					}
				}

			}
			this.click++;
			if (this.click == 2) {
				g.connect(this.src.getKey(), this.des.getKey(), Math.random() * 10);

				if (this.src != null && this.des != null) {
					Collection<edge_data> l = g.getE(src.getKey());
					for (edge_data ee : l) {
						if (ee.getDest() == this.src.getKey() && ee.getSrc() == this.des.getKey())
							t = true;

						if (t == true)
							JOptionPane.showMessageDialog(this, "edge already exists");

						else
							g.connect(src.getKey(), des.getKey(), Math.random() * 10);

					}

				}
				t = false;
				this.src = null;
				this.des = null;
				this.click = 0;
				this.addEdge = false;
				repaint();
			}
		}
		if (this.removeEdge) {
			if (this.click == 0) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.src = data;
					}
				}
			}
			if ((this.click == 1)) {
				for (node_data data : g.getV()) {
					if (p.distance2D(data.getLocation()) < 25) {
						this.des = data;
					}
				}
			}
			this.click++;
			if (this.click == 2) {
				// System.out.println("im");
				if (this.src != null && this.des != null) {
					if (g.getEdge(src.getKey(), des.getKey()) == null)
						JOptionPane.showMessageDialog(this, "edge doesnt exists");
					else
						g.removeEdge(src.getKey(), des.getKey());
					// System.out.println("sucess");
				}

				this.src = null;
				this.des = null;
				this.click = 0;
				this.removeEdge = false;

			}
		}

		if (this.TSP) {
			for (node_data data : g.getV())
				if (p.distance2D(data.getLocation()) < 25) {
					node_data d = data;
					arr.add(d.getKey());
				}

		}
		graph.init(g);

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("MouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("MouseExited");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("mousePressed");
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		String result = "";
		this.TSP = false;
		this.ShortestPathList = false;
		this.connected = false;
		this.removeNode = false;
		this.AddNode = false;
		this.removeEdge = false;
		this.addEdge = false;
		this.TSPDONE = false;

		System.out.println(str);
		if (str.equals("isConnected")) {
			this.connected = true;
			if (graph.isConnected()) {
				result = "Connected";
			} else {
				result = "Not Connected";
			}
			JLabel label = new JLabel("Connection = " + result);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			JOptionPane.showMessageDialog(this, label);
		}
		if (str.equals("TSP Done")) {

			this.graph.init(g);
			List<node_data> l = graph.TSP(arr);
			System.out.print(arr.toString() + "\n" + l.toString());
			if (l != null)
				JOptionPane.showMessageDialog(this, l.toString());
			else
				JOptionPane.showMessageDialog(this, "no path between nodes");
			this.TSP = false;
			this.TSPDONE = false;
			this.arr.remove(arr);
		}

		if (str.equals("save")) {
			graph.init(g);
			String filename;
			final JFileChooser fc = new JFileChooser();
			int response = fc.showSaveDialog(this);
			try {

				if (response == JFileChooser.APPROVE_OPTION) {
					filename = fc.getSelectedFile().toString();
					graph.save(filename);
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (str.equals("load")) {
			graph.init(g);
			String filename;
			final JFileChooser fc = new JFileChooser();
			int response = fc.showOpenDialog(this);
			try {

				if (response == JFileChooser.APPROVE_OPTION) {
					filename = fc.getSelectedFile().toString();
					graph.init(filename);
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			repaint();
		}
		/// save drawing to an image

		if (str.equals("save Image")) {
			graph.init(g);
			String filename;

			final JFileChooser fc = new JFileChooser();
			int response = fc.showSaveDialog(this);
			try {

				if (response == JFileChooser.APPROVE_OPTION) {
					filename = fc.getSelectedFile().toString();
					BufferedImage img = getScreenShot(this);
					// write the captured image as a PNG
					ImageIO.write(img, "png", new File(filename));
				}
			}

			catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		if (str.equals("Shortest Path")) {
			this.ShortestPath = true;
		}
		if (str.equals("Shortest Path List")) {
			this.ShortestPathList = true;

		}
		if (str.equals("TSP")) {
			this.TSP = true;
			arr = new ArrayList<Integer>();

		}
		if (str.equals("Delete Node")) {
			this.removeNode = true;
		}
		if (str.equals("Add Node")) {
			this.AddNode = true;

		}
		if (str.equals("Remove Edge")) {
			this.removeEdge = true;

		}
		if (str.equals("Add Edge")) {
			this.addEdge = true;
		}

	}

	public static BufferedImage getScreenShot(Component component) {

		BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		// paints into image's Graphics
		component.paint(image.getGraphics());
		return image;
	}

}