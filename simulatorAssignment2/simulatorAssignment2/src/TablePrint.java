public class TablePrint implements State{
    @Override
    public void handle() {
        Schedual schedual=Schedual.getInstance();
        ListOfProcessors processors=ListOfProcessors.getInstance();
        int cyclesNum = schedual.getClocks().size();
        System.out.println("/////The table//////");
        for(Processor p : processors.processors){
            for(int i=1;i<=cyclesNum;i++){
                Task task = p.getTaskAt(i);
                if(task != null )
                    System.out.print( task.getId() + '\t' );
                else
                    System.out.print( "NA\t");
            }
            System.out.println();
        }
    }
}
