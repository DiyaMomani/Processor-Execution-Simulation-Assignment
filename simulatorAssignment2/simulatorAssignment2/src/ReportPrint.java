import java.util.Map;
import java.util.TreeMap;

public class ReportPrint implements State{
    @Override
    public void handle() {
        Schedual schedual=Schedual.getInstance();
        ListOfProcessors processors=ListOfProcessors.getInstance();
        System.out.println("/////The report//////");
        for(int i=0;i<schedual.getClocks().size();i++){
            System.out.println(schedual.getClocks().get(i).getId()+" : ");
            //created//////////
            TreeMap<Integer,Task> created=schedual.getClocks().get(i).getCreating();
            for (Map.Entry<Integer, Task> entry : created.entrySet()) {
                System.out.println(entry.getValue().getId()+" is created in P" + entry.getKey());
            }
            //running////////
            TreeMap<Integer,Task> running=schedual.getClocks().get(i).getRunning();
            for (Map.Entry<Integer, Task> entry : running.entrySet()) {
                System.out.println(entry.getValue().getId()+" is running in P" + entry.getKey());
            }
            //finished//////
            TreeMap<Integer,Task> finished=schedual.getClocks().get(i).getFinished();
            for (Map.Entry<Integer, Task> entry : finished.entrySet()) {
                System.out.println(entry.getValue().getId()+" is finished in P" + entry.getKey());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
