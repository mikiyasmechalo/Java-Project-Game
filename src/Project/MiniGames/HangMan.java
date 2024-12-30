package Project.MiniGames;

import Project.GetInput;
import java.util.ArrayList;
import java.util.Random;

public class HangMan implements IMiniGame {
    private String wordToGuess;
    private final ArrayList<Character> guesses;
    private final ArrayList<Character> hangman;
    private int numWrongGuesses;

    public HangMan() {
        this.wordToGuess = randomWord();
        this.guesses = new ArrayList<>();
        for (int i = 0; i < wordToGuess.length(); i++) {
            guesses.add('_');
        }
        this.hangman = new ArrayList<>();
        this.numWrongGuesses = 0;
    }

    private String randomWord() {
        String[] words = {"door", "tablet", "princess", "king", "solomon", "zarathor", "dragon", "talen", "Amulet"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
    private void resetGame() {
        wordToGuess = randomWord();
        guesses.clear();
        for (int i = 0; i < wordToGuess.length(); i++)
            guesses.add('_');

        hangman.clear();
        numWrongGuesses = 0;
    }

    private void printGuesses() {
        for (char c : guesses)
            System.out.print(c + " ");

        System.out.println();
    }

    private void printHangman() {
        for (char c : hangman) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private boolean checkLetter(int index, char guessedLetter) {
        return (guesses.get(index) == '_') && (wordToGuess.charAt(index) == guessedLetter);
    }

    public boolean playGame() {

        gameRules();

        int chances = wordToGuess.length() * 3;

        while (chances > 0) {
            boolean finished = true;
            for (char c : guesses) {
                if (c == '_') {
                    finished = false;
                    break;
                }
            }

            if (finished) {
                System.out.println("\nCongratulations! You found all the letters!");
                System.out.println("You made " + numWrongGuesses + " wrong guesses.");
                break;
            }

            System.out.print("\nEnter your guess character: ");
            char pGuess = GetInput.getWordInput().charAt(0);
            boolean found = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (checkLetter(i, pGuess)) {
                    System.out.println("You got a correct one!");
                    guesses.set(i, pGuess);
                    printGuesses();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Wrong!");
                hangman.add('|');
                System.out.println("Hangman: ");
                printHangman();
                numWrongGuesses++;
                chances--;
            }
        }
        resetGame();
        return chances > 0;
    }

    @Override
    public void gameRules() {
        System.out.println("\n\nThis game is Hangman!");
        System.out.println("A random word is chosen from the context of the game.\n");
        System.out.println("you have (the length of the word) * 3 chances to guess the word fully!");
    }


    public static void main(String[] args) {
        var h = new HangMan();
        h.playGame();
    }


}
