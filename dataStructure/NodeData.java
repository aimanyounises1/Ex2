package dataStructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import utils.Point3D;

public class NodeData implements node_data,Serializable,Comparator<NodeData> {
	private static int k=0;
	private int id;
	Point3D p;
	int tag;
	String s;
	double weight;
	int tag2;
	// a constructor
	public NodeData(Point3D p) {
		this.id = k;
		this.p = p;
		this.weight= Integer.MAX_VALUE;
		this.tag=0;
		k++;
		
	}
	
	public NodeData(int id,Point3D p) {
		this.id = id;
		this.p = p;
		this.weight= Integer.MAX_VALUE;
		this.tag=0;
		
	}
	// copy construcor
	public NodeData(NodeData other) {
		this.id=other.id;
		this.p=other.p;
		this.weight=other.weight;
		this.s=other.s;
		this.tag=other.tag;
		
	}
	
	public NodeData () {
		this.id=k;
		this.tag=0;
		double x=Math.random()*(700-200)+200;

		double y=Math.random()*(700-200)+200;
		this.p=new Point3D(x,y);
		this.weight=Integer.MAX_VALUE;
		this.s="";
		k++;
		
	}
	public NodeData (int id) {
		this.id=id;
		this.tag=0;
		double x=Math.random()*(700-400)+400;

		double y=Math.random()*(700-400)+400;
		this.p=new Point3D(x,y);
		this.weight=Integer.MAX_VALUE;
		this.s="";
		
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
	
		return this.s;
	}

	

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.s=s;

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
	
	public int getTag2() {
		// TODO Auto-generated method stub
		return this.tag2;
	}

	
	public void setTag2(int t) {
		this.tag2 = t;
		
	}
	public int getId() {
		return id;
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
	
	public String toString()
	{
		
		return ""+this.id;
	}
	
	

}
