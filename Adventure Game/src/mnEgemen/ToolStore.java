package mnEgemen;
import java.util.Scanner;
public class ToolStore extends NormalLocation{
    Scanner scn = new Scanner(System.in);

    /*
     *
     * @constructor
     *
     */

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    /*
     *
     * @methods
     *
     */

    public boolean getLocation(){
        System.out.println("Money : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Select: ");
        int selectTool = scn.nextInt();
        int selectItemId;
        switch (selectTool) {
            case 1 -> {
                selectItemId = weaponMenu();
                buyWeapon(selectItemId);
            }
            case 2 -> {
                selectItemId = armorMenu();
                buyArmor(selectItemId);
            }
            case 3 ->{
                System.out.println("Checking Out...");
            }
            default -> {
                System.out.println("Invalid Transaction!");
            }
        }
        return true;
    }
    public int armorMenu(){
        System.out.println("1. Soft \t <Money: 15, Prevention: 1>");
        System.out.println("2. Medium \t <Money: 25, Prevention: 3>");
        System.out.println("3. Heavy \t <Money: 40, Prevention: 5>");
        System.out.println("4. Exit");
        System.out.print("Select Armor: ");
        return scn.nextInt();
    }
    public void buyArmor(int itemId){
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemId) {
            case 1 -> {
                avoid = 1;
                aName = "Soft Armor";
                price = 15;
            }
            case 2 -> {
                avoid = 3;
                aName = "Medium Armor";
                price = 25;
            }
            case 3 -> {
                avoid = 5;
                aName = "Heavy Armor";
                price = 40;
            }
            case 4 -> {
                System.out.println("Checking out...");
            }
            default -> System.out.println("Invalid Transaction!");
        }
        if(price > 0){
            if(player.getMoney() >= price){
                player.getInventory().setArmor(avoid);
                player.getInventory().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought" + aName);
                System.out.println("Blocked Damage: " + player.getInventory().getArmor());
                System.out.println("Remaining Money: " + player.getMoney());
            }else{
                System.out.println("Not enough money!");
            }
        }

    }
    public int weaponMenu(){
        System.out.println("1. Gun\t <Money: 25, Damage: 2>");
        System.out.println("2. Sword\t <Money: 35, Damage: 3>");
        System.out.println("1. Rifle\t <Money: 45, Damage: 7>");
        System.out.println("4. Exit");
        System.out.print("Select Weapon: ");
        return scn.nextInt();
    }
    public void buyWeapon(int itemId){
        int damage = 0, price = 0;
        String wName = null;
        switch (itemId) {
            case 1 -> {
                damage = 2;
                wName = "Gun";
                price = 25;
            }
            case 2 -> {
                damage = 3;
                wName = "Sword";
                price = 35;
            }
            case 3 -> {
                damage = 7;
                wName = "Rifle";
                price = 45;
            }
            case 4 -> {
                System.out.println("Checking out...");
            }
            default -> System.out.println("Invalid Transaction!");
        }
        if(price > 0){
            if(player.getMoney() >= price){
                player.getInventory().setDamage(damage);
                player.getInventory().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought "+ wName);
                System.out.println("Previous Damage: " + player.getDamage());
                System.out.println("New Damage: " + player.getTotalDamage());
                System.out.println("Remaining Money: " + player.getMoney());
            }else{
                System.out.println("Not enough money!");
            }
        }
    }
}
