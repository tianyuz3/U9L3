public class Storage {
    private String name;
    private String UUID;

    private int size;
    public Storage(String n , String ID,int size){
        name = n;
        UUID = ID;
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return UUID;
    }
    public int getSize(){
        return size;
    }
}
