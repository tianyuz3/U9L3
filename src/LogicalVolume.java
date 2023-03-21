public class LogicalVolume extends Storage{
 private VolumeGroup[] vG;

 public LogicalVolume(String name , String ID, int size , VolumeGroup[] voLumeGroups){
     super(name,ID,size);
     vG = voLumeGroups;
 }

}
