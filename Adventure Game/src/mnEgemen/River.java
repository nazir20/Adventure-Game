package mnEgemen;
public class River extends BattleLocation{

    /*
     * 'River' is a type of battle location
     * @constructor
     *
     */

    public River(Player player) {
        super(player, "River", new Bear(),"Water");
    }
}
