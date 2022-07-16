package mnEgemen;
public class Cave extends BattleLocation{

    /*
     * 'Cave' is one type of battle location
     * @constructor
     *
     */
    public Cave(Player player) {
        super(player, "Cave", new Zombie(),"Food");
    }
}
