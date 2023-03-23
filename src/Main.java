import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        String choice = "";
        while(!choice.equals("exit")) {
            System.out.println("Install hard drives: (Install drive + name + size(in G))");
            System.out.println("Get list of hard drives: " + "(List of drives)");
            System.out.println("Create physical:" + "(pvcreate + name of the physical drive + name)");
            System.out.println("Get list of physical volumes: " + "(list of pv)");
            System.out.println("Create volume groups: " + "(vgcreate + name of the physical volume + name)");
            System.out.println("Get list of volume groups: " + "(vgList)");
            System.out.println("Create logical volumes: " + "(lvcreate + name + size + name of the volume group )");
            System.out.println("Get list of logical volumes: " + "(lvlist)");
            System.out.println("Exit: (exit)");
            choice = c.nextLine();
            if(choice.indexOf("Install drive")!=0){
                UUID u = UUID.randomUUID();
                String name = choice.substring(choice.indexOf("drive")+1);
                int size = Integer.parseInt(name.substring(name.indexOf(" ")+1));
                name = name.substring(0,name.indexOf(" "));
                PhysicalDrive pv = new PhysicalDrive(name,size,u.toString());
                System.out.println(pv.getName() + pv.getSize());
            }
        }
    }
}
