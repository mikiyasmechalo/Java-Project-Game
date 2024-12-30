package Project;

import java.util.Scanner;

public class GameManager {
    private final Character player;
    private final Character dragon;
    private final Inventory inventory;
    private final NarrativeManager narrator;
    private final GamesList gameList;

    public GameManager(String playerName) {
        this.player = new Character(playerName, 100);
        this.dragon = new Character("Zarathor", 100);
        this.inventory = new Inventory();
        this.gameList = new GamesList();
        this.narrator = new NarrativeManager(inventory, player);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + player.getName() + "!");
        System.out.println("Your quest begins!");

        while (gameList.notLastGame()){
            gameList.playNextGame();
            if (!gameList.playNextGame()) {
                player.takeDamage(10);
                if (player.getHealth() <= 0) {
                    narrator.gameLostMessage();
                    return;
                }
            } else
                System.out.println("You passed the door!\n");

        }

        // Final Boss Battle
        System.out.println("\nFinal Boss: Zarathor");
        System.out.println("Your final challenge awaits!");
        while (player.getHealth() > 0 && dragon.getHealth() > 0) {
            System.out.println("Your Health: " + player.getHealth());
            System.out.println("Dragon's Health: " + dragon.getHealth());

            System.out.println("Would you like to use an item? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Available items: Vial");
                String item = scanner.nextLine();
                if (item.equalsIgnoreCase("Vial") && inventory.hasItem("Vial")) {
                    player.takeHealing(20);
                    inventory.useItem("Vial");
                }
            }

            if (gameList.playNextGame()) {
                dragon.takeDamage(10);
                System.out.println("You dealt 10 damage to the dragon!");
            } else {
                player.takeDamage(10);
                System.out.println("The dragon dealt 10 damage to you!");
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println("You were defeated by the dragon.");
            narrator.gameLostMessage();
        } else {
            narrator.gameWonMessage();
        }
    }

}
