import java.util.PriorityQueue;
import java.util.Queue;

public class Simulator {
    private int cycle=1;
    private int cnt=0;
    private InputTask tasks=InputTask.getInstance();
    private Queue<Task> pq= new PriorityQueue<Task>();
    private ListOfProcessors processors;

    Schedual schedual;
    public Simulator(int processorsNum, int clocksNum){
        processors=ListOfProcessors.getInstance();
        for(int i=1;i<=processorsNum;i++){
            processors.add(new Processor(i));
        }
        schedual=Schedual.getInstance();
        schedual.createCollections(processorsNum,clocksNum);
        tasks.Sort();

        while(cycle<=clocksNum){
            while(cnt< tasks.Size()&&cycle==tasks.Get(cnt).getCreation()){
                pq.offer(tasks.Get(cnt));
                cnt++;
            }
            while (!pq.isEmpty()&&schedual.getMap().firstKey()<=cycle){
                Task task=pq.poll();
                validator v1 = new priorityCheck();
                validator v2 = new validTimeCheck();
                v1.setNextCheck(v2);
                if(v2.check(task))
                    schedual.organize(task);
            }
            cycle++;
        }
    }
}
