import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
public class VolumeGroup extends Storage implements Serializable {

    private int size;
    private LogicalVolume lv;


    ArrayList<PhysicalVolume> pvGroup = new ArrayList<PhysicalVolume>();


    public VolumeGroup(String name, PhysicalVolume Pvolumes){
      super(name,0);
      pvGroup.add(Pvolumes);
      setSize(getTotalSize(pvGroup));

    }
    public void addPhysicalVolume(PhysicalVolume pV){
        pvGroup.add(pV);
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
    public int freeSpace(LogicalVolume lv){
        this.lv = lv;
        return getTotalSize(pvGroup)-lv.getSize();
    }

    public String getpVName(){
        String name = "";
        for(int i = 0 ; i<pvGroup.size() ; i++){
            name += (pvGroup.get(i).getName() + " ");
        }
        return name;
    }
    public String toString(){
        return (getName() + " : total: " + getTotalSize(pvGroup) + " available : " + freeSpace(lv) + " " + getpVName() + getUUID());
    }

}
