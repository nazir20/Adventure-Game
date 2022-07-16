package mnEgemen;
public class SafeHouse extends NormalLocation{

    /*
     * 'Safe House' is a type of Normal Location without any monster!
     * @constructor
     *
     */

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getReHealth());
        System.out.println("You healed!");
        System.out.println("Now you are in the safe house!");
        return true;
    }
}
