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
    private final double radiusSphere;

    /**
     * constructor of a sphere
     * @param radiusSphere
     */
    public Sphere(Vector3D location, double radiusSphere) {
        super(location);
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
     * @return Sting the string representation of a sphere
     */
    @Override
    public String toString() {
        Vector3D location=getLocation();
        String string="Sphere with radius (" + radiusSphere + 
        ") at ("+location.xCoordinate+", "+location.yCoordinate+", "+location.zCoordinate+")";
        return string;
    }
    
 @Override
    public boolean equals(Object o) {
        if (this==o){
            return true;
        } else if(o == null) {
            return false;
        } else if (getClass() != o.getClass()){
            return false;     
        } else {
            Sphere other = (Sphere)o;
            return radiusSphere == other.radiusSphere &&
                   getLocation().equals(other.getLocation());
        }
    }

}
