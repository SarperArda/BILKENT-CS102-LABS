/**
 * This class is interface for Destructible.
 */
public interface Destructible {
    boolean isDestroyed();
    void takeDamage(double damage);
}
