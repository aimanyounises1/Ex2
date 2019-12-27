package dataStructure;

import java.io.Serializable;

public class EdgeData implements edge_data, Serializable {
	int dest;
	int source;
	double weight;
	int tag;
    String s;
	// Point3D c = new Point3D(dest.p.x()-1, dest.p.y()-1);
	public EdgeData(int sor, int d,double weight) {
		this.dest = d;
		this.source = sor;
		this.weight=weight;
		this.tag=0;
		this.s="";
	
	}
	public EdgeData(EdgeData other) {
		this.dest = other.dest;
		this.source = other.source;
		this.weight = other.weight;
		this.tag=other.tag;
		this.s=other.s;
	}
	public EdgeData()
	{
		this.dest=0;
		this.source=0;
		this.weight=0;
		this.tag=0;
		this.s="";
	}

	
	public void setInfo(String s)
	{
		this.s=s;
		
		
		
	}

	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.source;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return s;
	}
	

	
	

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag = t;
	}
	
	public String toString()
	{
		return "source: " +this.source+"\n"+"dest: "+this.dest+"\n"+"weight: "+this.weight+"\n"+"info: "+this.s+"\n";
	}

}
