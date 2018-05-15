package avl;

/**
 * the body cuboid 
 */
public final class Cuboid extends Body {

    public final double lengthCuboid;
    
    public final double widthCuboid;
    
    public final double heightCuboid;

    private Cuboid (double lengthCuboid, double heightCuboid, double widthCuboid, double xCoordinate, double yCoordinate, double zCoordinate){
		this.lengthCuboid=lengthCuboid;
		this.heightCuboid=heightCuboid;
		this.widthCuboid=widthCuboid;
		this xCoordinate=xCoordinate;
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
        System.out.println(
                "Couboid with dimensions(" + lengthCuboid + " ," + widthCuboid + ", " + heightCuboid + "at (TODO");
        return null;
    }

    @Override
    public boolean equals(Object o) {
        // Ist Objekt dieses Names vorhanden?
        return false;
    }

    // TODO
    @Override
    public double getLocation(Body body) {

        return body.xCoordinate;

    }
}
