import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "words.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Character> wordState = new ArrayList<>();
        String line;
        char guess;
        int state=0;

        while ((line  = reader.readLine()) != null ){
            lines.add(line);
        }

        int randNum = random.nextInt(0,lines.size()+1);
        String theWord = lines.get(randNum);

        int lenght  = theWord.length();
        for(int i=0 ; i<lenght ; i++){
            wordState.add('_');
        }
        while(state < 6){
            for(char ch : wordState){
                
                System.out.print(ch+ " ");
            }
            System.out.println("\n"+hangMan( state));
            guess = scanner.next().toLowerCase().charAt(0);
            if(theWord.indexOf(guess) >= 0){
                
                System.out.println("correct");
                for(int i=0; i<theWord.length(); i++){
                    if(theWord.charAt(i) == guess){
                        wordState.set(i, guess);
                    }
                }
            } else {
                state++;
                System.out.println("not correct");
            }
            if(!wordState.contains('_')){
                break;
            }
        }

        if (state >=6) {
            System.out.println(hangMan(6));
            System.out.println("The word is: " + theWord);
        } else {
            System.out.println("you won");
        }
        scanner.close();
        
    }

    static String hangMan(int state){
            return switch (state){
                case 0 -> """
                        
                        
                        
                        """;

                case 1 -> """
                           o 
                        
                        
                          """;

                case 2 -> """
                           o 
                           |
                        
                          """;

                case 3 -> """
                           o 
                          /|
                        
                          """;

                case 4 -> """
                           o 
                          /|\\
                        
                          """;

                case 5 -> """
                           o 
                          /|\\
                          /
                          """;

                case 6 -> """
                           o 
                          /|\\
                          / \\
                          """;

                default -> "none";
            };
        }
}
