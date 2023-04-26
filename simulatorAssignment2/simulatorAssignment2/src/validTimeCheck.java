public class validTimeCheck extends validator{
    @Override
    public boolean check(Task task) {
        if(task.getCreation() < 0 || task.getExecution() > Schedual.getInstance().getClocks().size() )
            return false;
        return super.check(task);
    }

    public validTimeCheck() {}
}
