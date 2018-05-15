package avl;

import java.lang.Math;

/**
 *the body sphere
 */
public final class Sphere extends Body {
    
    /**
     * constant representing phi
     */
    final static double PI = Math.PI;
    
    /**
     * variable representing the radius of a sphere
     */
    public final double radiusSphere;

    /**
     * constructor of a sphere
     * @param radiusSphere
     */
    private Sphere(double radiusSphere) {
        this.radiusSphere = radiusSphere;
    }
    
    /**
     * calculates the surface of a sphere by its radius
     * @return double the surface of a sphere
     */
    @Override
    public double getSurface() {
        double surfaceSphere = 4 * PI * (Math.sqrt(radiusSphere));
        return surfaceSphere;
    }
    
    /**
     * calculates the volume of a sphere by its radius
     * @return double the volume of a sphere
     */
    @Override
    public double getVolume() {
        double volumeSphere = (4 / 3) * PI * (Math.pow(radiusSphere, 3.0));
        return volumeSphere;
    }
    
    /**
     * prints the radius of a sphere as a string representation 
     * @return Sting the string represntation of a sphere
     */
    @Override
    public String toString() {
        System.out.println("Sphere with radius " + radiusSphere + " at (" + TODO);
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
