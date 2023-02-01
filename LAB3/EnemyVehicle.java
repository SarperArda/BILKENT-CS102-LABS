import java.awt.*;

/**
 * This class is abstract class for Enemy Vehicle
 */
public abstract class EnemyVehicle implements Movable,Destructible{
    private Point enemy;
    final int BASE_SPEED = 3;
    protected double health;
    int speed;

    public EnemyVehicle(int minX, int maxX, int y){

        enemy = new Point(minX + (int) (Math.random() * (maxX - minX)),y);
        health = 50.0;
        speed = BASE_SPEED;
    }

     public int getDistanceToBorder(){
        return enemy.y;
    }

    abstract String getType();

    @Override
    public boolean isDestroyed() {
        return (this.health <= 0);
    }

    @Override
    public void takeDamage(double damage) {
        this.health = this.health - damage;

    }

    @Override
    public void move() {
        enemy.y = enemy.y - speed;
    }

    @Override
    public Point getLocation() {
        int x = enemy.x;
        int y = enemy.y;
        return enemy;
    }
}
