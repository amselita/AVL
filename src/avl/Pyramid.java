package avl;

/**
 * the body pyramid
 */
public final class Pyramid extends Body {

    /**
     * variable representing the baselength of a pyramid
     */
    private final double baselengthPyramid;
    
    /**
     * variable representing the basewidth of a pyramid
     */
    private final double basewidthPyramid;
    
    /**
     * variable representing the height of a pyramid
     */
    private final double heightPyramid;

    /**
     * constructor of the body pyramid
     * @param baselengthPyramid 
     * @param basewidthPyramid
     * @param heightPyramid
     */
    public Pyramid(Vector3D location, double baselengthPyramid, double basewidthPyramid, double heightPyramid) {
        super(location);
        this.baselengthPyramid = baselengthPyramid;
        this.basewidthPyramid = basewidthPyramid;
        this.heightPyramid = heightPyramid;
    }

    /**
     * calculates the surface of a pyramid by its basewidth, baselength and height
     * @return double the surface of a pyramid
     */
    @Override
    public double getSurface() {
        double surfacePyramid = baselengthPyramid * basewidthPyramid
                + (2 * ((1 / 2) * baselengthPyramid * heightPyramid)
                        + 2 * ((1 / 2) * basewidthPyramid * heightPyramid));
        return surfacePyramid;
    }
    
    /**
     * calculates the volume of a pyramid by its baselength. basewidth and height
     * @return double the volume of a pyramid
     */
    @Override
    public double getVolume() {
        double volumePyramid = (1 / 3) * (baselengthPyramid * basewidthPyramid) * heightPyramid;
        return volumePyramid;
    }

    /**
     * prints the baselength, basewidth and height of pyramid as a string representation 
     * @String the string representation of a pyramid
     */
    @Override
	public String toString() {
        Vector3D location=getLocation();
		String string="Pyramid with base ("+baselengthPyramid+", "+basewidthPyramid+") and height "+heightPyramid+
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
            Pyramid other = (Pyramid)o;
            return basewidthPyramid == other.basewidthPyramid &&
                   baselengthPyramid == other.baselengthPyramid &&
                   heightPyramid == other.heightPyramid &&
                   getLocation().equals(other.getLocation());
        }
    }

}
