package dataStructure;

public class EdgeData implements edge_data {
	int dest;
	int source;
	double weight;
	int tag;

	// Point3D c = new Point3D(dest.p.x()-1, dest.p.y()-1);
	public EdgeData(int sor, int d,double weight) {
		this.dest = d;
		this.source = sor;
		this.weight=weight;
	
	}
	EdgeData(EdgeData other) {
		this.dest = other.dest;
		this.source = other.source;
		this.weight = other.weight;
	}

	public EdgeData() {
		this.dest=0;
		this.source=0;
		this.weight=0;
		this.tag=0;
	}
	public void setInfo(String s)
	{
		String t="";
		s=s.replace("" , " ");
		int i=s.indexOf("weight:");
		i=i+7;
		while(s.charAt(i)!=','||s.charAt(i)!=s.length())
		{
			t=t+s.charAt(i);
			i++;
		}
		 i=s.indexOf("source:");
		i=i+7;
		
		this.weight=Double.parseDouble(t);
		t="";
		while(s.charAt(i)!=','||s.charAt(i)!=s.length())
		{
			t=t+s.charAt(i);
			i++;
		}
		 i=s.indexOf("destination:");
		i=i+12;
		
		this.source=(int)Double.parseDouble(t);
		t="";
		
		while(i!=s.length()||s.charAt(i)!=s.length())
		{
			t=t+s.charAt(i);
			i++;
		}
		i++;
		
		this.dest=(int)Double.parseDouble(t);
		t="";
		
		
		
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
		return  "weight: " + this.weight + "source: " + this.source + "destination: " + this.dest;
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
