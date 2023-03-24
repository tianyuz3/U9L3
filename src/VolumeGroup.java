import java.util.*;
public class VolumeGroup extends Storage{

    private int size;
    private int spaceLeft;

    ArrayList<PhysicalVolume> pvGroup = new ArrayList<PhysicalVolume>();

    public VolumeGroup(String name, PhysicalVolume Pvolumes , ArrayList<LogicalVolume> lVolumes){
      super(name,0);
      pvGroup.add(Pvolumes);
      setSize(getTotalSize(pvGroup));
      spaceLeft = getTotalSizeOfLv(lVolumes)- getTotalSize(pvGroup);
    }
    public int getTotalSize(ArrayList<PhysicalVolume> pV){
        for(int i = 0 ; i<pV.size() ; i++){
            size += pV.get(i).getSize();
        }
        return size;
    }
    public int getTotalSizeOfLv(ArrayList<LogicalVolume> lv){
        int s = 0;
        for(int i = 0 ; i<lv.size() ; i++){
            s+= lv.get(i).getSize();
        }
        return s;
    }
    public void getSpaceLeft(){
        System.out.println("There are " + spaceLeft + "G left");
    }
}
