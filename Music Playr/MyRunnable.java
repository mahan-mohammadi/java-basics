import javax.sound.sampled.Clip;

public class MyRunnable implements Runnable{

    Clip clip;

    MyRunnable(Clip clip){

        this.clip = clip;
    }

    @Override
    public void run() {

       long length = this.clip.getMicrosecondLength();
       long position;

       long minuteOfPosition;
       long secondsOfPosition;

       long minuteOfLength = length/60_000_000;
       long secondsOflength = length/1_000_000 % 60;
       

        while (clip.isRunning()) {

            position = this.clip.getMicrosecondPosition();

            minuteOfPosition = position/60_000_000;
            secondsOfPosition =  position/1_000_000 - (60*minuteOfPosition);

            System.out.println(minuteOfPosition+ ":" + secondsOfPosition+ " : " + minuteOfLength + ":" + secondsOflength);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("intrrupted");
            }
        }
    }
    
}
