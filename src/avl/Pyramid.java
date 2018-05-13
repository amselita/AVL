package avl;

public final class Pyramid extends Body{
	
	public final double baselengthPyramid;
	public final double basewidthPyramid;
	public final double heightPyramid;
	
	private Pyramid (double baselengthPyramid, double basewidthPyramid, double heightPyramid){
		this.baselengthPyramid=baselengthPyramid;
		this.basewidthPyramid=basewidthPyramid;
		this.heightPyramid=heightPyramid;
	}
	

	@Override
	public double getSurface() {  
		double surfacePyramid=baselengthPyramid*basewidthPyramid+(2*((1/2)*baselengthPyramid*heightPyramid)+2*((1/2)*basewidthPyramid*heightPyramid));
		return surfacePyramid;
	}

	@Override
	public double getVolume() {
		double volumePyramid=(1/3)*(baselengthPyramid*basewidthPyramid)*heightPyramid;
		return volumePyramid;
	}

	@Override
	public String toString() {
		System.out.println("Pyramid with base ("+baselengthPyramid+", "+basewidthPyramid+") and height "+heightPyramid+"at ("TODO;
		return null;
	}
	//TODO

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
