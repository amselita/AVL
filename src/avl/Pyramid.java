package avl;

/**
 * the body pyramid
 */
public final class Pyramid extends Body {

    /**
     * variable representing the baselength of a pyramid
     */
    public final double baselengthPyramid;
    
    /**
     * variable representing the basewidth of a pyramid
     */
    public final double basewidthPyramid;
    
    /**
     * variable representing the height of a pyramid
     */
    public final double heightPyramid;

    /**
     * constructor of the body pyramid
     * @param baselengthPyramid 
     * @param basewidthPyramid
     * @param heightPyramid
     */
    private Pyramid(double baselengthPyramid, double basewidthPyramid, double heightPyramid) {
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
     * @String thr string representation of a pyramid
     */
    @Override
	public String toString() {
		System.out.println("Pyramid with base ("+baselengthPyramid+", "+basewidthPyramid+") and height "+heightPyramid+"at ("TODO;
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
