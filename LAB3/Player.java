import java.util.ArrayList;

/**
 * This class is player class.
 */
public class Player {

    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;

    public Player(){

    }

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){

        for (EnemyVehicle enemy : enemies) {
            if (Math.sqrt(Math.pow(enemy.getLocation().x - x, 2) + Math.pow(enemy.getLocation().y - y, 2)) <= BOMB_RADIUS) {
                enemy.takeDamage(DAMAGE);

            }


        }
    }
}

