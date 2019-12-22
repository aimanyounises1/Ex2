package dataStructure;

public class EdgeData implements edge_data {
	int dest;
	int source;
	double weight;
	int tag;

	// Point3D c = new Point3D(dest.p.x()-1, dest.p.y()-1);
	EdgeData(int sor, int d) {
		this.dest = d;
		this.source = sor;
	
	}
	EdgeData(EdgeData other) {
		this.dest = other.dest;
		this.source = other.source;
		this.weight = other.weight;
	}

	public EdgeData() {
		// TODO Auto-generated constructor stub
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
		return "(" + "weight is =" + this.weight + "source is =" + this.source + "destination is =" + this.dest;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub

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

}
