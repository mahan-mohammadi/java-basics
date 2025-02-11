public class MyRunnable implements Runnable {

    int seconds;
    int thread;

    MyRunnable(int thread, int seconds){
        this.seconds = seconds;
        this.thread = thread;
    }

    @Override
    public void run() {

        for(int i=0 ; i< this.seconds ; i++){
            System.out.println("Thread "+ this.thread + " : " + (this.seconds-i) + " seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was intruppted");
            }
           
        }
        
    }
    
}
