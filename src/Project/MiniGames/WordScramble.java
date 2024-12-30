package Project.MiniGames;

import Project.GetInput;

import java.util.Arrays;
import java.util.Collections;

public class WordScramble implements IMiniGame {
    private final String[] words = {"adventure", "dragon", "mystical", "flower", "puzzle", "talen", "wisdom"};

    @Override
    public boolean playGame() {
        int chances = 0;
        gameRules();
        String word = words[(int) (Math.random() * words.length)];
        String scrambledWord = scrambleWord(word);

        System.out.println("\n\nUnscramble this word to pass the door: " + scrambledWord);
        while (true) {
            System.out.print("Your answer: ");
            String userAnswer = GetInput.getWordInput().trim();

            if (userAnswer.equalsIgnoreCase(word)) {
                System.out.println("Correct! You have passed the door.");
                return true;
            } else {

                if (++chances != 4)
                    System.out.println("Wrong! Try again!");
                else {
                    System.out.println("You have used all your chances!");
                    System.out.println("The correct word was: " + word);
                    return false;
                }
            }
        }
    }

    private String scrambleWord(String word) {
        String[] letters = word.split("");
        Collections.shuffle(Arrays.asList(letters));
        return String.join("", letters);
    }

    @Override
    public void gameRules() {
        System.out.println();
        System.out.println("Game Rules:");
        System.out.println("1. You will be given a scrambled word.");
        System.out.println("2. Unscramble it correctly to pass.");
        System.out.println("3. You have 5 chances.");
        System.out.println("3. Pay attention to spelling!");
    }
}

