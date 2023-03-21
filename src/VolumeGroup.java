import java.util.*;
public class VolumeGroup extends Storage{

    private int size;
    private int spaceLeft;

    public VolumeGroup(String name, String ID, PhysicalVolume[] Pvolumes , LogicalVolume lVolumes){
      super(name,ID,0);
      super.setSize(getSize(Pvolumes));
      spaceLeft = lVolumes.getSize()- getTotalSize(Pvolumes);
    }
    public int getTotalSize(PhysicalVolume[] pV){
        for(int i = 0 ; i<pV.length ; i++){
            size += pV[i].getSize();
        }
        return size;
    }
}
