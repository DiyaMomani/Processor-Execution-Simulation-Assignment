import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Clock {
    private String id;
    private TreeMap<Integer,Task> creating;
    private TreeMap<Integer,Task> running;
    private TreeMap<Integer,Task> finished;

    Clock(int id){
        this.id="C"+id;
        creating=new TreeMap<Integer,Task>();
        running=new TreeMap<Integer,Task>();
        finished=new TreeMap<Integer,Task>();
    }
    public TreeMap<Integer,Task> getCreating() {
        return creating;
    }

    public void addCreating(int processor,Task task) {
        creating.put(processor,task);
    }

    public TreeMap<Integer,Task> getRunning() {
        return running;
    }

    public void addRunning(int processor,Task task) {
        running.put(processor,task);
    }

    public TreeMap<Integer,Task> getFinished() {
        return finished;
    }

    public void addFinished(int processor,Task task) {
        finished.put(processor,task);
    }
    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "C"+id;
    }


}
