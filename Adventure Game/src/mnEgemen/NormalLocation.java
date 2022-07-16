package mnEgemen;
public abstract class NormalLocation extends Location{
    /*
     *
     * @constructor
     *
     */
    public NormalLocation(Player player, String name) {
        super(player);
        this.name = name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
