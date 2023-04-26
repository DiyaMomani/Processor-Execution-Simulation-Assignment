public abstract class validator {
    validator nextCheck;

    public void setNextCheck(validator nextCheck) {
        this.nextCheck = nextCheck;
    }
    public boolean check(Task task){
        if(nextCheck == null)
            return true;
        return nextCheck.check(task);
    }
}
