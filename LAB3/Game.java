import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates gameplay.
 */
public class Game implements Difficulty{
    int difficulty;
    Player player;
    ArrayList<EnemyVehicle> enemies;
    final int STARTING_DISTANCE = 20;
    int score;
    int borderPassing;
    final int MAX_NO_OF_PASSING_ENEMIES = 1;
    int numberTurn;
    GamePlotter gp;

    public Game(int difficulty){

        this.difficulty = difficulty;
        player = new Player();
        score = 0;
        numberTurn = 0;
        enemies = new ArrayList<EnemyVehicle>();

        for(int i = 0; i < difficulty; i++){
            EnemyVehicle h = new Helicopter(0,5 * difficulty,STARTING_DISTANCE);
            EnemyVehicle k = new Tank(0,5 * difficulty,STARTING_DISTANCE);
            enemies.add(h);
            enemies.add(k);
        }
        borderPassing = 0;
        gp = new GamePlotter(this);
    }
    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int getDifficulty() {
        return difficulty;
    }

    public void play() {

        while (borderPassing < MAX_NO_OF_PASSING_ENEMIES){

            Scanner input = new Scanner(System.in);
            System.out.print("Enter the coordinates X and Y in order to bomb: ");
            int x = input.nextInt();
            int y = input.nextInt();
            player.attack(x, y, enemies);
            enemiesTurn();
            for (EnemyVehicle enemy : enemies) {
                enemy.move();
            }
            gp.plot();
            printGameState();
        }

        System.out.println("Game Over");
        if(numberTurn <= score){
            System.out.println("You win");
        }

    }

    public ArrayList<EnemyVehicle> getEnemies(){
        return enemies;
    }

    private EnemyVehicle getNewRandomVehicle(int difficulty){
        EnemyVehicle ev = null;
        double x = Math.random();

        if( x <= 0.5){
            ev = new Tank(0,5 * difficulty,STARTING_DISTANCE);


        }

        if(x > 0.5){
            ev = new Helicopter(0,5 * difficulty,STARTING_DISTANCE);
        }

        return ev;
    }

    private void enemiesTurn(){

        for (int i = 0; i < enemies.size(); i++) {

                if(enemies.get(i).isDestroyed()){
                    enemies.remove(i);
                    enemies.add(getNewRandomVehicle(difficulty));
                    score++;
                    continue;

                }

                if(enemies.get(i).getDistanceToBorder() < 0){
                    borderPassing++;
                    enemies.remove(i);

                }

        }

    }

    private void printGameState(){
        numberTurn++;
        for(EnemyVehicle enemy : enemies){
            System.out.println(enemy.getType() + " health : " +enemy.health + " Point: " + enemy.getLocation().x +" "+ enemy.getLocation().y );
        }
        System.out.println("Turn Number: " + numberTurn);
        System.out.println("Score: " + score);
    }
}
