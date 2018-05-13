package avl;
import java.lang.Math;


public final class Cylinder extends Body{
	
	public static double PI = Math.PI;
	
	public final double radiusCylinder;
	public final double heightCylinder;
	
	private Cylinder (double radiusCylinder, double heightCylinder, double PI){
		this.radiusCylinder=radiusCylinder;
		this.heightCylinder=heightCylinder;
		
	}

	
	/**
	 * @return the surface of this Cylinder
	 */
	@Override
	public double getSurface() {
		double surfaceCylinder=2*PI*radiusCylinder*(radiusCylinder+heightCylinder);
		return surfaceCylinder;
	}

	@Override
	public double getVolume() {
		double volumeCylinder=(2*PI*radiusCylinder)*heightCylinder;
		return volumeCylinder;
	}

	@Override
	public String toString() {
		System.out.println("Cylinder with radius "+radiusCylinder+" and height "+heightCylinder+" at ("+TODO);
		return null;
	}
	//TODO

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


}
