import java.util.UUID;

public class Storage {
    private String name;
    private String UUID;

    private int size;
    public Storage(String n , int size){
        name = n;
        this.size = size;
        UUID u = java.util.UUID.randomUUID();
        this.UUID = u.toString();
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return UUID;
    }
    public int getSize(){
        return size ;
    }

    public void setSize(int n){
        size = n;
    }
    public String getInfo(){
        return (getName() + " " + getUUID() + " " + getSize() + "G");
    }
    public String getSizeInG(){
        return getSize() + "G";
    }
}
