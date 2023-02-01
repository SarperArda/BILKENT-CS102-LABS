/**
 * This class extends EnemyVehicle
 */
public class Tank extends EnemyVehicle {

    public Tank(int minX, int maxX, int y){
        super(minX,maxX,y);
    }

    @Override
    public void takeDamage(double damage) {
        damage = damage / 2;
        super.takeDamage(damage);
    }

    @Override
    String getType() {
        return "Tank" ;
    }


    public String toString(){
        return getType() + getLocation().toString();
    }

}
