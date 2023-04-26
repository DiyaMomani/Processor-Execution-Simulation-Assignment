import java.util.ArrayList;
import java.util.HashMap;

public class Processor {
    private String id;
    private HashMap<Integer,Task> map = new HashMap<>();

    Processor(int id){
        this.id="P"+id;
    }
    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "P"+id;
    }
    public void add(Integer cycle,Task task){
        map.put(cycle,task);
    }


    public Task getTaskAt(Integer cycle){
        if(map.containsKey(cycle)){
            return map.get(cycle);
        }
        return null;
    }
}
