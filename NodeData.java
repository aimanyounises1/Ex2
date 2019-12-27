package dataStructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import utils.Point3D;

public class NodeData implements node_data, Serializable {
	private int id;
	private Point3D p;
	int tag;
	double weight;
	String s;
	
	
	// a constructor
	public NodeData() {
		this.id=0;
		this.weight=0;
		this.p=null;
		this.tag=0;
		this.s="";
		
		
	}
	public NodeData(int id) {
		this.id=id;
		this.weight=0;
		this.p=null;
		this.tag=0;
		this.s="";
		
		
	}
	public NodeData(int id,Point3D p)
	{
		this.id=id;
		this.p=p;
		
	}
	

	// copy construcor
	NodeData(NodeData other) {
		this.id=other.id;
		this.weight=other.weight;
		this.p=other.p;
		this.tag=other.tag;
		this.s=other.s;
	}
	
	NodeData(Point3D p,double weight)
	{
		this.id=0;
		this.weight=weight;
		this.p=p;
		this.tag=0;
		
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
		
		return s;
	}

	@Override
	public void setInfo(String s) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString()
	{
		return "id: "+this.id+"\n"+"weight: "+this.weight+"\n"+"pointlocation: "+this.p+"\n"+"info: "+this.s+"\n";
	}

}