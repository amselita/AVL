package avl;

/**
 * the body cuboid 
 */
public final class Cuboid extends Body {

    private final double lengthCuboid;
    
    private final double widthCuboid;
    
    private final double heightCuboid;

    public Cuboid (Vector3D location, double lengthCuboid, double heightCuboid, double widthCuboid) {
        // set location in Body class
        super(location);       
		this.lengthCuboid=lengthCuboid;
		this.heightCuboid=heightCuboid;
		this.widthCuboid=widthCuboid;
	}

    /**
     * calculates the surface of a cuboid by its length, width and height
     *@return double the surface 
     */
    @Override
    public double getSurface() {
        double surfaceCuboid = 2
                * (lengthCuboid * widthCuboid + widthCuboid * heightCuboid + lengthCuboid * heightCuboid);
        return surfaceCuboid;
    }

    /**
     * calculates the volume of a cuboid by its length, width and height
     * @return double the volume 
     */
    @Override
    public double getVolume() {
        double volumeCuboid = lengthCuboid * widthCuboid * heightCuboid;
        return volumeCuboid;
    }

    /**
     * prints the length, width and height of a cuboid as string representation
     * @return String representing of a cuboid
     */
    @Override
    public String toString() {
        Vector3D location=getLocation();
        String string="Couboid with dimensions(" + lengthCuboid + " ," + widthCuboid + ", " + heightCuboid + 
                " at ("+location.xCoordinate+", "+location.yCoordinate+", "+location.zCoordinate+")";
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
            Cuboid other = (Cuboid)o;
            Vector3D location=getLocation();
            Vector3D locationOther=other.getLocation();
            return lengthCuboid==other.lengthCuboid &&
                    heightCuboid==other.heightCuboid &&
                    widthCuboid==other.widthCuboid &&
                    location.equals(locationOther);
        }
    }
}
