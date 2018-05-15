package avl;

import java.lang.Math;

/**
 * the body cylinder
 */
public final class Cylinder extends Body {
    
    /**
     * a constant representing phi
     */
    final static double PI = Math.PI;
    
    /**
     * variablethe radius of a cylinder
     */
    public final double radiusCylinder;
    
    public final double heightCylinder;
    

    private Cylinder(double radiusCylinder, double heightCylinder, double PI) {
        this.radiusCylinder = radiusCylinder;
        this.heightCylinder = heightCylinder;

    }

    /**
     * calculates the surface of a cylinder by its radius and height
     * @return double the surface of this Cylinder
     */
    @Override
    public double getSurface() {
        double surfaceCylinder = 2 * PI * radiusCylinder * (radiusCylinder + heightCylinder);
        return surfaceCylinder;
    }
    
    /**
     * calculates the volume of a cylinder by its radius and height
     * @double the volume of a cylinder
     */
    @Override
    public double getVolume() {
        double volumeCylinder = (2 * PI * radiusCylinder) * heightCylinder;
        return volumeCylinder;
    }

     /**
      * prints the radius and height of a cylinder string representation 
      * @return String representation of a cylinder
      */
    @Override
    public String toString() {
        System.out.println("Cylinder with radius " + radiusCylinder + " and height " + heightCylinder + " at (" + TODO);
        return null;
    }
    // TODO

    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getLocation(Body body) {
        // TODO Auto-generated method stub
        return 0;
    }

}
