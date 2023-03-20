public class PhysicalVolume extends Storage{
    PhysicalDrive drive;
    public PhysicalVolume(String name , String ID , int size, PhysicalDrive drive){
        super(name,ID,size);
        this.drive = drive;
    }

    public PhysicalDrive getDrive() {
        return drive;
    }
    public String getPVInfo(){
        return  super.getName() + " " + super.getSize() + " " + super.getUUID();
    }
}
