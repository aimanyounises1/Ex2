package dataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import utils.Point3D;

public class NodeData implements node_data,Comparator<NodeData> {
	private int id;
	Point3D p;
	int pred;
	int tag;
	boolean visited;
	double dis;
	double weight;
	//HashMap<Integer, NodeData> verticals = new HashMap<>();
	// a constructor
	public NodeData(int id,double dis,Point3D p) {
		this.id = id;
		this.p = p;
		this.weight= Integer.MAX_VALUE;
		visited = false;
		pred = -1;
	}
	// copy construcor
	public NodeData(NodeData other) {
		this.id=other.id;
		this.dis=other.dis;
		this.p=other.p;
		visited = other.visited;
		this.pred = other.pred;
	}
	public NodeData(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		tag = 0;
		this.weight = Integer.MAX_VALUE;
		visited = false;
		pred = -1;
	}
	public NodeData () {
		
	}
	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return this.p;
	}

	@Override
	public void setLocation(Point3D p) {
		// TODO Auto-generated method stub
		this.p = p;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		this.weight = w;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		String s = "(" + this.id + "," + this.weight + ")";
		return s;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub

	}
	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = t;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDis(double dis) {
		this.dis = dis;
	}
	public double getDis() {
		return this.dis;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visit){
		visited = visit;
	}
	public int getPred() {
		return this.pred;
	}
	public void setPred(int pred) {
		this.pred = pred;
	}
	@Override
	public int compare(NodeData o1, NodeData o2) {
		// TODO Auto-generated method stub
		if(o1.weight<o2.weight) {
			return -1;
		}
		if(o1.weight > o2.weight)	
		return 1;
		
		return 0;
	}
	public boolean equal(NodeData a) {
		return this.id == a.id;
	}

}
