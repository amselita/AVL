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
    private final double radiusCylinder;
    
    private final double heightCylinder;
    

    public Cylinder(Vector3D location, double radiusCylinder, double heightCylinder) {
        super(location);
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
        Vector3D location=getLocation();
        int radiusCylinderInt=(int)radiusCylinder;
        int heightCylinderInt=(int)heightCylinder;
        int xCoordinate=(int) location.xCoordinate;
        int yCoordinate= (int)location.yCoordinate;
        int zCoordinate= (int)location.zCoordinate;
        String string="Cylinder with radius " + radiusCylinderInt + " and height " + heightCylinderInt + 
                " at ("+xCoordinate+", "+yCoordinate+", "+zCoordinate+")";
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
            Cylinder other = (Cylinder)o;
            return radiusCylinder == other.radiusCylinder &&
                   heightCylinder == other.heightCylinder &&
                   getLocation().equals(other.getLocation());
        }
    }
    
}
