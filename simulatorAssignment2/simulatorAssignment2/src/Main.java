import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter the processor Number: ");
        int processor = cin.nextInt();
        System.out.println("Enter the clock Number: ");
        int clock=cin.nextInt();
        cin.nextLine();
        System.out.println("Enter the path: ");
        String path=cin.nextLine();

        InputTask input= InputTask.getInstance();
        input.InputEntry(path);
        Simulator s= new Simulator(processor,clock);
        reportGenerator r = new reportGenerator( new ReportPrint() );
        r.request();
        r.setState(new TablePrint());
        r.request();
    }
}