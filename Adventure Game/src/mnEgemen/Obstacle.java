package mnEgemen;
import java.util.Random;
public class Obstacle {

    /*
     *
     * @variables
     *
     */

    private String name;
    private int damage, award, health, maxNumber;

    /*
     *
     * @constructor
     *
     */

    public Obstacle(String name, int damage, int health, int award,  int maxNumber) {
        setName(name);
        setDamage(damage);
        setAward(award);
        setHealth(health);
        setMaxNumber(maxNumber);
    }

    /*
     *
     * @methods
     *
     */

    public int count(){
        Random random = new Random();
        return random.nextInt(this.maxNumber) + 1;
    }

    /*
     *
     * @getter and setters
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
