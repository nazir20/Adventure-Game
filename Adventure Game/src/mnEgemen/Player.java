package mnEgemen;

import java.util.Scanner;

public class Player {
    /*
    *
    * @variables
    *
     */
    Scanner scn = new Scanner(System.in);
    private int damage, health, money, reHealth;
    private String name, cName;
    private Inventory inventory;

    /*
    *
    * @constructors
    *
     */

    public Player(String name){
        setName(name);
        this.inventory = new Inventory();
    }

    /*
    *
    * @methods
    *
     */
    // a method for selecting a character to play game with:)
    public void selectChar(){
        switch (charMenu()) {
            case 1 -> {
                initCharacter("Samurai",5, 21, 15);
            }
            case 2 -> {
                initCharacter("Archer",7, 18, 20);
            }
            case 3 -> {
                initCharacter("Knight", 8, 24, 5);
            }
            default -> {
                initCharacter("Samurai",5, 21, 15);
            }
        }
        System.out.println("Your character is created...");
        System.out.println("Character: " + getcName() + "\t Damage: " + getDamage() + "\t Health: " + getHealth() + "\t Money: " + getMoney());
    }
    public int charMenu(){
        System.out.println("Please select a character:");
        System.out.println("1- Samurai \t Damage : 5 \t Health: 21 \t Money: 15");
        System.out.println("2- Archer \t Damage : 7 \t Health: 18 \t Money: 20");
        System.out.println("3- Knight \t Damage : 8 \t Health: 24 \t Money: 5");
        System.out.print("Select character: ");
        int charId = scn.nextInt();
        while (charId < 1 || charId > 3){
            System.out.print("Please select a valid character: ");
            charId = scn.nextInt();
        }
        return charId;
    }
    // a method for initializing the character which is selected by player :)
    public void initCharacter(String cName, int damage, int health, int money){
        setcName(cName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setReHealth(health);
    }
    /*
    *
    * @getter and setters
    *
     */
    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equalsIgnoreCase("")){
            this.name = "X";
        }else{
            this.name = name;
        }
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getReHealth() {
        return reHealth;
    }

    public void setReHealth(int reHealth) {
        this.reHealth = reHealth;
    }
}
