/**
 * This class extends EnemyVehicle
 */
public class Helicopter extends EnemyVehicle{

    public Helicopter(int minX, int maxX, int y){
        super(minX,maxX,y);
    }

    @Override
    String getType() {
        return "Helicopter";
    }

    @Override
    public void move() {
        super.move();
        speed++;

    }

    public String toString(){
        return getType() + getLocation().toString();
    }


}
