import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] game = new char[3][3];
        for(int i=0 ; i<game.length; i++){
            for(int j=0 ; j<game[i].length; j++){
                game[i][j] ='-';
            }
        }


        Scanner sc = new Scanner(System.in);
        boolean validPlay;
        boolean validLocation;
        boolean win =false;
        char play;
        int location;
        
        do{
        do{
            validPlay = false;
            System.out.print("Enter the letter: ");
            play = Character.toLowerCase(sc.next().charAt(0));
            if(play == 'x' || play == 'X'){
                validPlay =true;
            }
        }while(!validPlay);

        do{
            validLocation = false;
            System.out.print("Enter the location from 1 to 9: ");
            location = sc.nextInt();
            location = location-1;
            if(location >=0 && location<9 && game[location/3][location%3] == '-'){
                validLocation = true;
            }
        }while(!validLocation);
        game[location/3][location%3] = play;
        System.out.println(Arrays.deepToString(game));
        for(int i=0 ; i<game.length; i++){
            if(game[i][0] == 'x' && game[i][1] == game[i][0] && game[i][2] == game[i][1]){
                win = true;
                break;
            }
        }

        for(int i=0 ; i<game.length; i++){
            if(game[0][i] == 'x' && game[0][i] == game[1][i] && game[2][i] == game[1][i]){
                win = true;
                break;
            }
            
        }
        int k=0;
        if(game[k][k] == 'x' && game[k+1][k+1] == game[k][k] && game[k+2][k+2] == game[k+1][k+1]){
            win = true;
        }
        if(win == true){
            break;
        }

        do{
            validPlay = false;
            System.out.print("Enter the letter: ");
            play = Character.toLowerCase(sc.next().charAt(0));
            if(play == 'o' || play == 'O'){
                validPlay =true;
            }
        }while(!validPlay);

        do{
            validLocation = false;
            System.out.print("Enter the location from 1 to 9: ");
            location = sc.nextInt();
            location--;
            if(location >=0 && location<9 && game[location/3][location%3] == '-'){
                validLocation = true;
            }
        }while(!validLocation);

        game[location/3][location%3] = play;

        System.out.println(Arrays.deepToString(game));

        for(int i=0 ; i<game.length; i++){
            if(game[i][0] == 'o' && game[i][1] == game[i][0] && game[i][2] == game[i][1]){
                win = true;
                break;
            }
            
        }

        for(int i=0 ; i<game.length; i++){
            if(game[0][i] == 'o' && game[0][i] == game[1][i] && game[2][i] == game[1][i]){
                win = true;
                break;
            }
            
        }
        if(game[k][k] == 'o' && game[k+1][k+1] == game[k][k] && game[k+2][k+2] == game[k+1][k+1]){
            win = true;
        }
        
        if(win == true){
            break;
        }
    
    }while(!win);
        sc.close();
    }
}
