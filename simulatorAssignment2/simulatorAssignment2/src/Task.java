public class Task implements Comparable<Task> {
    private String id;
    private int creation;
    private int execution;
    private int priority;

    public Task() {
        creation=0;
        execution=0;
        priority=0;
    }

    public Task(int id,int creation, int execution, int priority) {
        this.id="T"+id;
        this.creation = creation;
        this.execution = execution;
        this.priority = priority;
    }

    public int getCreation() {
        return creation;
    }

    public void setCreation(int creation) {
        this.creation = creation;
    }

    public int getExecution() {
        return execution;
    }

    public void setExecution(int execution) {
        this.execution = execution;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Task o) {
        if(this.getPriority()>o.getPriority()) return -1;
        else if(this.getPriority()<o.getPriority()) return 1;
        else{
            if(this.getExecution()>= o.getExecution()) return -1;
            else return 1;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "creation=" + creation +
                ", execution=" + execution +
                ", priority=" + priority +
                '}';
    }
}
