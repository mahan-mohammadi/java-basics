import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Thread> threads = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int seconds;
        int count =0;

        do{
            System.out.println("Enter your seconds or -1 for the break");
            seconds = sc.nextInt();
            if(seconds == -1){
                break;
            }
            count++;
            Thread thread = new Thread(new MyRunnable(count, seconds));
            threads.add(thread);
        }while(true);

        for(Thread thread: threads ){
            thread.start();
        }
        for(Thread thread :  threads){
            thread.join();
        }
        System.out.println("All timers are finished");
        sc.close();
        

    }
}
