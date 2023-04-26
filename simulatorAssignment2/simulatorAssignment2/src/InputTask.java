import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class InputTask {
    private static InputTask instance =null;
    private ArrayList<Task> tasks;
    private InputTask() {
        tasks=new ArrayList<Task>();
    };

    public static InputTask getInstance() {
        if (instance == null) {
            instance = new InputTask();
        }
        return instance;
    }
    public void InputEntry(String path){
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            String header = sc.nextLine();
            Scanner lineScanner = new Scanner(header);
            int h=lineScanner.nextInt();
            int id=1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //System.out.println(line);
                lineScanner = new Scanner(line);
                int a = lineScanner.nextInt();
                int b = lineScanner.nextInt();
                int c = lineScanner.nextInt();
                Task data = new Task(id, a, b, c);
                tasks.add(data);
                id++;
                lineScanner.close();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public void Sort(){
        tasks.sort(Comparator.comparingInt(o -> o.getCreation()));
    }
    public int Size(){
        return tasks.size();
    }
    public Task Get(int index){
        return tasks.get(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
