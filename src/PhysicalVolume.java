import java.io.Serializable;

public class PhysicalVolume extends Storage implements Serializable {
    PhysicalDrive drive;
    public PhysicalVolume(String name , int size, PhysicalDrive drive){
        super(name,size);
        this.drive = drive;
    }

    public String getDrive() {
        return drive.getName();
    }
    public String getPVInfo(){
        return  super.getInfo() +  " " +  getDrive();
    }
}
