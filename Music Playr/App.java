import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;   

public class App {
    public static void main(String[] args) throws Exception {

        String filePath = "file path"; // enter your file path here instead
        int response =0;

        File file = new File(filePath);
        Scanner sc = new Scanner(System.in);

        try(AudioInputStream stream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip();
            clip.open(stream);

            boolean running = true;
            while (running) {
                System.out.println("Enter a command:");
                System.out.println("1: Start");
                System.out.println("2: Stop");
                System.out.println("3: Reset");
                System.out.println("4: Close");
                response = sc.nextInt();

                switch (response) {
                    case 1 -> {
                        if (!clip.isRunning()) {
                            //clip.setMicrosecondPosition(0);  //Optional: reset before starting
                            clip.start();
                            Thread thread = new Thread(new MyRunnable(clip));
                            thread.setDaemon(true);
                            thread.start();
                            System.out.println("Playback started.");
                        } else {
                            System.out.println("Audio is already playing.");
                        }
                    }
                    case 2 -> {
                        if (clip.isRunning()) {
                            clip.stop();
                            System.out.println("Playback stopped.");
                        } else {
                            System.out.println("Audio is not playing.");
                        }
                    }
                    case 3 -> {
                        clip.setMicrosecondPosition(0);
                        System.out.println("Playback reset to the beginning.");
                    }
                    case 4 -> {
                        clip.close();
                        System.out.println("Clip closed.");
                        running =false;
                    }
                    
                    default -> System.out.println("Not a valid command.");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("could not locate file");
        }
        catch(LineUnavailableException e){
            System.out.println("unable to access audio resource");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("file not supported");
        }
        catch(IOException e){
            System.out.println("something went wrong");
        }
        sc.close();
    }
}
