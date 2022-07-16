package mnEgemen;
import java.util.Scanner;
public class Game {
    /*
    *
    * @variables
    *
     */
    Scanner scn = new Scanner(System.in);
    Player player;
    Location location;
    /*
    *
    * @methods
    *
     */
    public void login(){
        System.out.println("Welcome to Adventure Game");
        System.out.print("Please enter your name: ");
        String playerName = scn.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }
    public void start(){
        while (true){
            System.out.println("\n=====================================\n");
            System.out.println("To start the game, please select a place: ");
            System.out.println("1. Safe House --> A safe place which belongs to you <No enemy!>");
            System.out.println("2. Cave --> You may face  <Zombie>!");
            System.out.println("3. Forest --> You may face <Vampire>!");
            System.out.println("4. River --> You may face <Bear> !");
            System.out.println("5. Tool Store --> You can buy weapons and armor!");
            System.out.print("Select the place you want to go: ");
            int selectedLoc = scn.nextInt();
            while (selectedLoc < 1 || selectedLoc > 5){
                System.out.print("Please select a valid place: ");
                selectedLoc = scn.nextInt();
            }
            switch (selectedLoc) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new ToolStore(player);
                default -> location = new SafeHouse(player);
            }

            //checking if all the awards are being won by the player :)
            // if yes, the game is finished :(

            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()){
                    System.out.println("Congratulations! You won the game!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Game finished...");
                break;
            }
        }
    }
}
