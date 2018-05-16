package avl;

abstract class Body {
    
    private Vector3D location;
    
    public Body(Vector3D location) {
        this.location=location;
    }
    
    public Vector3D getLocation() {
        return location;
    }
    
    public void setLocation(Double xCoordinate, Double yCoordinate, double zCoordinate){
        
    }

    /**
     * calculates the surface of an body
     * 
     * @return double value the surface
     */
    public abstract double getSurface();

    /**
     * calculates the volume of an body
     * 
     * @return double value volume
     */
    public abstract double getVolume();

    /**
     * Prints the string representation of a body to the console
     * 
     */
    public abstract String toString();

    /**
     * compares an object to ???
     * 
     * @param: Object which shall be compared
     */
    // TODO
    public abstract boolean equals(Object o);
    
   
}
