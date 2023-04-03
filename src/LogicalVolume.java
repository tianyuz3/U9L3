import java.io.Serializable;
import java.util.*;
public class LogicalVolume extends Storage implements Serializable {
 private ArrayList<VolumeGroup> vG;

 public LogicalVolume(String name ,  int size , ArrayList<VolumeGroup> volumeGroups){
     super(name,size);
     vG = volumeGroups;
 }

}
