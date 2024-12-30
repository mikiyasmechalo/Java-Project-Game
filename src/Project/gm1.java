package Project;

import java.util.Scanner;

public class gm1 {
    private Character player;
    private Character dragon;
    private Inventory inventory;

    public gm1(String playerName) {
        this.player = new Character(playerName, 100); // Player starts with 100 health
        this.dragon = new Character("Dragon", 100);  // Dragon starts with 100 health
        this.inventory = new Inventory();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + player.getName() + "!");
        System.out.println("Your quest begins!");

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Your goal: Pass through the tunnels, gather items, and defeat the dragon!");

        // Door 1: Forgotten Chamber
//        door1();
//
//        // Door 2: Abyssal Bridge
//        door2();
//
//        // Door 3: Chamber of Shadows
//        door3();
//
//        // Door 4: Garden of Despair
//        door4();

        // Final Boss: Dragon Battle
//        dragonBattle();
    }

//    private void door1() {
//        System.out.println("You reach the first door: The Forgotten Chamber.");
//        System.out.println("The carvings tell a story of a mighty king battling a dragon.");
//        System.out.println("You see an Amulet on the ground, you don't know whose it is.");
//        System.out.print("Do you want to take it?(y/n): ");
//        if (GetInput.getWordInput().equalsIgnoreCase("y")) {
//            inventory.addItem("Amulet");
//            System.out.println("You take the amulet and move on.");
//        }
//    }
//
//    private void door2() {
//        System.out.println("The second door opens to reveal the Abyssal Bridge.");
//        System.out.println("Whispers rise from the darkness below, warning you to turn back.");
//
//        if (inventory.hasItem("Amulet")) {
//            System.out.println("The amulet glows faintly, shielding you from the whispers.");
//        } else {
//            System.out.println("The whispers sow doubt in your heart. Your health decreases.");
//            player.takeDamage(10);
//        }
//
//        System.out.println("You cross the bridge safely and find a stone tablet.");
//        inventory.addItem("Tablet");
//    }
//
//    private void door3() {
//        System.out.println("The third door leads to the Chamber of Shadows.");
//        System.out.println("Mirrors line the walls, reflecting distorted images of you.");
//
//        if (inventory.hasItem("Amulet")) {
//            System.out.println("The amulet hums with energy, revealing your true self in the mirrors.");
//        } else {
//            System.out.println("The mirrors sow doubt in your mind. Your health decreases.");
//            player.takeDamage(10);
//        }
//
//        System.out.println("You find a vial behind the shattered mirror.");
//        System.out.println("Do you want to take it?");
//        if (GetInput.getWordInput().equalsIgnoreCase("y")) {
//            inventory.addItem("Vial");
//            System.out.println("You take the Vial and move on.");
//        }
//    }
//
//    private void door4() {
//        System.out.println("The fourth door opens to the Garden of Despair.");
//        System.out.println("A thorny vine lashes out, warning you to leave.");
//
//        System.out.println("You remember the wisdom from the tablet: 'Life blooms only where hope is sown.'");
//        System.out.println("You place the amulet on the pedestal, transforming the garden.");
//
//        System.out.println("A radiant white flower appears, opening the path forward.");
//    }

//    private void dragonBattle() {
//        System.out.println("The final door leads to the dragon's lair.");
//        System.out.println("Zarathor rises to challenge you in a game of Tic-Tac-Toe.");
//
//        TicTacToe ttt = new TicTacToe();
//        while (player.getHealth() > 0 && dragon.getHealth() > 0) {
//            System.out.println("Your Health: " + player.getHealth());
//            System.out.println("Dragon's Health: " + dragon.getHealth());
//
//            boolean result = ttt.playGame();
//            if (result) {
//                dragon.takeDamage(10);
//                System.out.println("You dealt 10 damage to the dragon!");
//            } else {
//                player.takeDamage(10);
//                System.out.println("The dragon dealt 10 damage to you!");
//            }
//        }
//
//        if (player.getHealth() > 0) {
//            System.out.println("Congratulations! You defeated the dragon and saved the princess!");
//        } else {
//            System.out.println("You were defeated by the dragon. Game Over.");
//        }
//    }
}