import java.lang.Math;

public final class Sphere extends Body{
	
	public static double PI=Math.PI;
	
	public final double radiusSphere;
	
	private Sphere (double radiusSphere){
		this.radiusSphere=radiusSphere;
	}

	@Override
	public double getSurface() {
		double surfaceSphere=4*PI*(Math.sqrt(radiusSphere));
		return surfaceSphere;
	}

	@Override
	public double getVolume() {
		double volumeSphere=(4/3)*PI*(Math.pow(radiusSphere, 3.0));
		return volumeSphere;
	}

	@Override
	public String toString() {
		System.out.println("Sphere with radius "+radiusSphere+" at ("+TODO);
		return null;
	}
	//TODO

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
