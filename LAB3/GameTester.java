import java.util.Scanner;

/**
 * This class tests Game play
 */
public class GameTester {
    public static void main(String[] args){
        System.out.println("Welcome the Lab3 Game");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the difficulty you want to play \n 1 for Easy \n 2 for Medium " +
                "\n 3 for Hard \n Choice:  ");
        int dif = input.nextInt();
        Game game = new Game(dif);
        GamePlotter gp = new GamePlotter(game);
        gp.plot();
        game.play();


    }
}
