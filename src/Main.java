import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Object obj = new Object();
        Scanner c = new Scanner(System.in);
        String choice = "";
        ArrayList<PhysicalDrive> pDList = new ArrayList<PhysicalDrive>();
        ArrayList<PhysicalVolume> pVList = new ArrayList<PhysicalVolume>();
        ArrayList<VolumeGroup> vGList = new ArrayList<VolumeGroup>();
        ArrayList<LogicalVolume> lGList = new ArrayList<LogicalVolume>();
        pDList.add(new PhysicalDrive("PD1",10));
        pDList.add(new PhysicalDrive("PD2",100));
        pVList.add(new PhysicalVolume("PV1",50,pDList.get(0)));
        pVList.add(new PhysicalVolume("PV2",600,pDList.get(1)));
        vGList.add(new VolumeGroup("VG1",pVList.get(0)));

            while (!choice.equals("exit")) {
            System.out.print("cmd# ");
            choice = c.nextLine();
            String[] arr = choice.split(" ");
            if (arr[0].equals("install-drive")) {
                pDList.add(new PhysicalDrive(arr[1], Integer.parseInt(arr[2])));
                System.out.println("Installation Completed!");
            } else if (arr[0].equals("list-drives")) {
                for (int i = 0; i < pDList.size(); i++) {
                    System.out.println(pDList.get(i).getInfo());
                }
            } else if (arr[0].equals("pvcreate")) {
                for (int i = 0; i < pDList.size(); i++) {
                    if (pDList.get(i).getName().equals(arr[2])) {
                        pVList.add(new PhysicalVolume(arr[2], pDList.get(i).getSize(), pDList.get(i)));
                        i = pDList.size();
                        System.out.println("Installation completed!");
                    }
                }
            }  else if(arr[0].equals("pvlist")){
                for(int i = 0 ; i<pVList.size() ; i++){
                    System.out.println(pVList.get(i).getPVInfo());
                }
            } else if(arr[0].equals("vgcreate")){
             for(int i = 0 ; i<pVList.size() ; i++){
                 if(pVList.get(i).getName().equals(arr[1])){
                     vGList.add(new VolumeGroup(arr[2],pVList.get(i)));
                 }
             }
            } else if(arr[0].equals("vglist")){
                for(int i = 0 ; i<vGList.size() ; i++){
                    System.out.println(vGList.get(i).getInfo());
                }
            } else if(arr[0].equals("vgextend")){

                for(int i = 0 ; i<vGList.size() ; i++){
                    if(arr[1].equals(vGList.get(i).getName())){
                        for(int k = 0 ; k<pVList.size() ; k++){
                            if(pVList.get(k).getName().equals(arr[2])){
                                vGList.get(i).addPhysicalVolume(pVList.get(k));
                                k=pVList.size();
                                i = vGList.size();
                            }
                        }
                    }
                }
            }
        }
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("storage.dat"));
            for (int i = 0; i < pDList.size(); i++) {
                output.writeObject(pDList.get(i));
            }
            for (int i = 0; i < pVList.size(); i++) {
                output.writeObject(pVList.get(i));
            }
            for (int i = 0; i < vGList.size(); i++) {
                output.writeObject(vGList.get(i));
            }
            for(int i = 0 ; i<lGList.size() ; i++){
                output.writeObject(lGList.get(i));
            }
            output.close();
        }

        catch(IOException ioe){
            System.err.println("Error saving to file");
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("storage.dat"));
            obj = input.readObject();
            input.close();

        }
        catch(IOException ioe){
            System.err.println("Couldn't open the file");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("Class not found");
        }
        System.out.println(obj);
    }
}
