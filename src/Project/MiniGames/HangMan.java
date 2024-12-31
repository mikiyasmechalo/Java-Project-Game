package Project.MiniGames;

import Project.GetInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HangMan implements IMiniGame {
    private String wordToGuess;
    private final ArrayList<Character> guesses;
    private final ArrayList<Character> hangman;
    private int numWrongGuesses;
    Map<String, String> hangmanHints;



    public HangMan() {
        this.wordToGuess = randomWord();
        this.guesses = new ArrayList<>();
        for (int i = 0; i < wordToGuess.length(); i++) {
            guesses.add('_');
        }
        this.hangman = new ArrayList<>();
        this.numWrongGuesses = 0;
        hangmanHints = new HashMap<>();
        hangmanHints.put("door", "A way in or out.");
        hangmanHints.put("tablet", "Flat and often held in hand.");
        hangmanHints.put("princess", "Royal, yet not crowned.");
        hangmanHints.put("king", "Ruler by birthright.");
        hangmanHints.put("solomon", "Known for wisdom.");
        hangmanHints.put("zarathor", "A name shrouded in power.");
        hangmanHints.put("dragon", "Scales and fire.");
        hangmanHints.put("talen", "A name fit for a hero.");
        hangmanHints.put("Amulet", "Worn for unseen protection.");
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
                printGuesses();
                System.out.println();
                System.out.println("Wrong!");
                hangman.add('|');
                System.out.print("\nHangman: ");
                printHangman();

                if(hangman.size() == 3 && numWrongGuesses == 2){
                    System.out.print("\nDo you want hints?{y/n}: ");
                    String i = String.valueOf(GetInput.getWordInput().charAt(0));
                    if (i.equalsIgnoreCase("y")){
                        System.out.print("\n Hint: ");
                        System.out.print(hangmanHints.get(wordToGuess));
                        System.out.println();
                    }else {
                        System.out.println("\nGood Luck!\n");
                    }
                }
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
        System.out.println("you have (the length of the word) * 3 = _" +  wordToGuess.length() * 3 + "_ chances to guess the word fully!");
    }

    public static void main(String[] args) {
        var h = new HangMan();
        h.playGame();
    }
}
