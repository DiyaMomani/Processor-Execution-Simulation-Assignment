public class priorityCheck extends validator{
    @Override
    public boolean check(Task task) {
        if(task.getPriority() != 0 && task.getPriority() != 1)
            return false;
        return super.check(task);
    }

    public priorityCheck() {}
}
