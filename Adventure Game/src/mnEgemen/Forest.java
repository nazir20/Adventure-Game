package mnEgemen;
public class Forest extends BattleLocation{
    /*
     * 'Forest' is a type of battle location
     * @constructor
     *
     */
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood");
    }
}
