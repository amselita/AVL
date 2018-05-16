package avl;

public class Vector3D {

    public double xCoordinate;
    
    public double yCoordinate;
    
    public double zCoordinate;
    
    public Vector3D(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
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
            Vector3D other = (Vector3D)o;
            return xCoordinate==other.xCoordinate &&
                    yCoordinate==other.yCoordinate &&
                    zCoordinate==other.zCoordinate;            
        }
    }
}
