import java.io.Serializable;

public class PhysicalDrive extends Storage implements Serializable {
    public PhysicalDrive(String name , int size){
        super(name,size);
    }

}
