package mnEgemen;
import java.util.Scanner;
public abstract class Location {

    /*
    *
    * @variables
    *
     */

    Scanner scn = new Scanner(System.in);
    protected Player player;
    protected String name;

    /*
    *
    * @constructor
    *
     */
    public Location(Player player){
        setPlayer(player);
    }

    /*
     *
     * @methods
     *
     */
    public abstract boolean getLocation();

    /*
    *
    * @getter and setters
    *
    */

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
