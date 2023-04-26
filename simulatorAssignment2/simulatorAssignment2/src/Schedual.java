import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class Schedual {

    private static Schedual instance =null;
    private TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<Integer, LinkedList<Integer>>();

    private ArrayList<Clock> clocks;
    private ListOfProcessors processorSingleton=ListOfProcessors.getInstance();
    private Schedual(){
    }
    public static Schedual getInstance(){
        if(instance==null) instance=new Schedual();
        return instance;
    }

    public void createCollections(int processorNum,int clockNum){
        clocks=new ArrayList<Clock>();
        for(int i=1;i<=clockNum;i++){
            clocks.add(new Clock(i));
        }
        LinkedList<Integer> linked=new LinkedList<Integer>();
        for(int i=1;i<=processorNum;i++){
            linked.add(i);
        }
        map.put(1,linked);
    }
    public void organize(Task task){
        //remove from the map
        int currentClock = map.firstKey();

        LinkedList<Integer> list = map.get(currentClock);
        int processor = list.removeFirst();

        if(list.isEmpty()){

            map.remove(currentClock);
        }
        else map.put(currentClock, list);

        int newClock,createdVar;
        // addCreating to the clocks
        if(currentClock<=task.getCreation()){
            clocks.get(task.getCreation()-1).addCreating(processor,task);
            createdVar= task.getCreation();
            newClock=task.getCreation()+task.getExecution();
        }
        else{
            clocks.get(currentClock-1).addCreating(processor,task);
            createdVar=currentClock;
            newClock=currentClock+task.getExecution();
        }
        // add running to the clocks
        for(int i=createdVar;i<=newClock-3;i++){
            if(i<clocks.size()) clocks.get(i).addRunning(processor,task);
        }
        // add finished to thr clocks
        if(newClock-2<clocks.size())clocks.get(newClock-2).addFinished(processor,task);


        // add task to the processors
        for(int i=createdVar;i<newClock;i++) {
            processorSingleton.get(processor - 1).add(i,task);
        }
        // add to the map
        LinkedList<Integer> list2;
        if(map.containsKey(newClock)){
            list2 = map.get(newClock);
            list2.addFirst(processor);
        }
        else{
            list2 = new LinkedList<>();
            list2.add(processor);
        }

        map.put(newClock, list2);

    }
    public ArrayList<Clock> getClocks() {
        return clocks;
    }

    public void setClocks(ArrayList<Clock> clocks) {
        this.clocks = clocks;
    }

    public TreeMap<Integer, LinkedList<Integer>> getMap() {
        return map;
    }

    public void setMap(TreeMap<Integer, LinkedList<Integer>> map) {
        this.map = map;
    }
}
