import java.util.*;
public class Tester{

        public static void main(String[] args) {
            //Test for physical drives
            PhysicalDrive pd = new PhysicalDrive("pdtest1", 100);
            System.out.println(pd.getInfo());
            PhysicalDrive pd2 = new PhysicalDrive("pdtest2",500);
            System.out.println(pd2.getInfo());

            //Test for physical volumes
            PhysicalVolume pv = new PhysicalVolume("pvtest1",200,pd);
            System.out.println(pv.getPVInfo());
            System.out.println("This volume belongs to " + pv.getDrive());
            PhysicalVolume pv2 = new PhysicalVolume("pvtest2", 700, pd2);
            System.out.println("This volume belongs to " + pv2.getInfo());
            System.out.println("This volume has a size of: " + pv2.getSizeInG());

            //Test for Volume Groups
            VolumeGroup vg = new VolumeGroup("vgTest1",pv);
            VolumeGroup vg2 = new VolumeGroup("vgTest2",pv2);
            System.out.println("There are " + vg.getSize());
            System.out.println(vg2.getSize());
            System.out.println(vg2.getName());
            ArrayList<VolumeGroup> listOfVg = new ArrayList<VolumeGroup>();
            listOfVg.add(vg);
            listOfVg.add(vg2);

            //Test for Logical Volume
            LogicalVolume lv = new LogicalVolume("lvTest1",30,listOfVg);
            System.out.println(lv.getInfo());
            for(VolumeGroup i : listOfVg){
                System.out.println(i.getName());
            }



        }

    }


