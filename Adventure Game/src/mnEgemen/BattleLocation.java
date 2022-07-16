package mnEgemen;
import java.util.Scanner;
public abstract class BattleLocation extends Location{

    /*
    *
    *@variables
    *
    */

    private Obstacle obstacle;
    protected String award;
    Scanner scn = new Scanner(System.in);

    /*
    *
    *@constructor
    *
    */
    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    /*
    *
    * @methods
    *
     */

    @Override
    public boolean getLocation() {

        int obstacleCount = getObstacle().count();
        System.out.println("Now You Are in : " + this.getName());
        /*
         * the number of monsters in each location is determined randomly between specified intervals
         */
        System.out.println("Be careful! There live " + obstacleCount + " "+ obstacle.getName());
        System.out.print("<F>ight or <E>scape: ");
        String selectedCase = scn.nextLine();
        selectedCase = selectedCase.toUpperCase();
        if(selectedCase.equals("F")){
            // checking if all the monsters in the selected location is killed
            if(combat(obstacleCount)){
                System.out.println("You killed all the enemies in " + this.getName());
                if(this.award.equals("Food") && !player.getInventory().isFood()){
                    System.out.println("You won a " + this.award);
                    player.getInventory().setFood(true);
                }else if(this.award.equals("Water") && !player.getInventory().isWater()){
                    System.out.println("You won a " + this.award);
                    player.getInventory().setWater(true);
                }else if(this.award.equals("Firewood") && !player.getInventory().isFirewood()){
                    System.out.println("You won a " + this.award);
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
            //checking if players healthy
            if(player.getHealth() <= 0){
                System.out.println("You're killed!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstacleCount){

        for(int i = 0; i<obstacleCount; i++){
            int defaultObstacleHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            // checking if both player and monster are healthy
            while (player.getHealth() > 0 && obstacle.getHealth() > 0){
                System.out.print("<H>it or <E>scape: ");
                String selectedCase = scn.nextLine();
                selectedCase = selectedCase.toUpperCase();
                if(selectedCase.equals("H")){
                    System.out.println("You hit...");
                    obstacle.setHealth(obstacle.getHealth()- player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth() > 0){
                        System.out.println("\nThe Monster hit you...");
                        player.setHealth(player.getHealth() - (obstacle.getHealth()-player.getInventory().getArmor()));
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(obstacle.getHealth() < player.getHealth()){
                System.out.println("You defeated the enemy...");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your current money: " + player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);
            }else{
                return false;
            }
            System.out.println("-------------------------------------");
        }
        return true;
    }
    // a method for showing the stat of player
    public void playerStats(){

        System.out.println("Player ratings\n--------------");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Damage: " + player.getTotalDamage());
        System.out.println("Money: " + player.getMoney());
        if(player.getInventory().getDamage() > 0){
            System.out.println("Weapon: " + player.getInventory().getwName());
        }if(player.getInventory().getArmor() > 0){
            System.out.println("Armor: " + player.getInventory().getaName());
        }
        System.out.println();
    }
    // a method for showing the monster's stat
    public void enemyStats(){
        System.out.println(obstacle.getName() + " ratings\n-------------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }
    // a method for showing both player's and monster's health after hitting each other
    public void afterHit(){
        System.out.println("Player's Health: " + player.getHealth());
        System.out.println(obstacle.getName() + "'s Health: " + obstacle.getHealth());
        System.out.println();
    }

    /*
    *
    * @getter and setters
    *
     */
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
