package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Point3D;

public class NodeData implements node_data {
	private int id;
	Point3D p;
	int tag;
	double weight;
	HashMap<Integer, NodeData> verticals = new HashMap<>();
	// a constructor
	public NodeData(int id,Point3D p) {
		this.setId(id);
		this.weight=weight;
		this.p=p;
	}

	// copy construcor
	NodeData(NodeData other) {
		this.id=other.id;
		this.weight=other.weight;
		this.p=other.p;
		this.tag=other.tag;
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
		String s = "(" + this.getId() + "," + this.weight + "," + this.p.toString() + ")";
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

}