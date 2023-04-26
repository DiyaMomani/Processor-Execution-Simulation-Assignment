import java.util.ArrayList;

public class ListOfProcessors {
    private static ListOfProcessors instance =null;
    ArrayList<Processor> processors;
    private ListOfProcessors() {
        processors=new ArrayList<Processor>();
    };

    public static ListOfProcessors getInstance() {
        if (instance == null) {
            instance = new ListOfProcessors();
        }
        return instance;
    }
    public void add(Processor processor){
        processors.add(processor);
    }
    public Processor get(int index){
        return processors.get(index);
    }
    public int size(){return processors.size();}
}
