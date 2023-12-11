import java.util.ArrayList;

public class Container {





    public ArrayList<Vehicle> containerList;
    public Container(int maxCapacity){
        this.containerList = new ArrayList<>(maxCapacity);
    }

    public int size(){
        return this.containerList.size();
    }
    public boolean contains(){
        return this.containerList != null;
        }


    }

