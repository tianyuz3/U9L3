public class LogicalVolume extends Storage{
 private VolumeGroup[] vG;

 public LogicalVolume(String name ,  int size , VolumeGroup[] voLumeGroups){
     super(name,size);
     vG = voLumeGroups;
 }

}
