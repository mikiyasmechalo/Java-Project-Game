package Project.MiniGames;

import Project.GetInput;
import java.util.Random;

public class DiceRoll  implements IMiniGame{
    private final Random random = new Random();
    private int playerRoll = 0;

    public boolean playGame(){
        System.out.println("Roll a higher number than the Dragon to do Damage or to avoid Damage");
        System.out.println("Press ENTER to roll your dice.");

        System.out.print("Your roll: ");
        GetInput.getSentenceInput();

        playerRoll = rollDice();
        System.out.println("You rolled: " + playerRoll);

        System.out.println("\nThe Dragon rolls...\n");

        int dragonRoll = rollDice();
        System.out.println("The Dragon rolled: " + dragonRoll);

        if (playerRoll > dragonRoll) {
            System.out.println("You win!\n");
            return true;
        } else if (playerRoll < dragonRoll) {
            System.out.println("You lose!\n");
            return false;
        } else {
            System.out.println("It's a tie! The Dragon laughs and lets you try again.\n");
            return playGame();
        }
    }
    public int roll(){
        if (playGame())
            return  playerRoll;
        return -playerRoll;
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void gameRules() {
        System.out.println("Game Rules:");
        System.out.println("1. Roll a six-sided die.");
        System.out.println("2. Your roll must be higher than the dragon's to do damage.");
        System.out.println("3. If you win your roll is multiplied by 5 to do damage.");
        System.out.println("4. In case of a tie, you may roll again.");
    }

}
