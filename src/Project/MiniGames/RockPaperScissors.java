package Project.MiniGames;

import Project.GetInput;

public class RockPaperScissors implements IMiniGame {

    @Override
    public void gameRules(){
        System.out.println("A classic game of RPS.");
        System.out.println("The first to score 3 wins!");
    }

    @Override
    public boolean playGame(){
        gameRules();
        char computerChoice;
        char userChoice = ' ';

        int userScore = 0;
        int computerScore = 0;


        while (userScore != 3 && computerScore != 3) {
            System.out.println();
            computerChoice = getComputerChoice();

            userChoice = getUserChoice();

            System.out.println("Computer chose: " + computerChoice);

            int winner = chooseWinner(userChoice, computerChoice);
            if (winner == 1)
                userScore++;
            else if(winner == 0)
                computerScore++;
        }

        return userScore == 3;
    }

    private static char getComputerChoice() {
        char computerChoice;
        int randomNum = (int) (Math.random() * 3);
        if (randomNum == 0) {
            computerChoice = 'r';
        } else if (randomNum == 1) {
            computerChoice = 'p';
        } else {
            computerChoice = 's';
        }
        return computerChoice;
    }

    private char getUserChoice() {
        char userChoice = ' ';
        while (true){
            System.out.println();
            System.out.print("Enter your choice (rock/ r, paper/ p, scissors/ s): ");
            userChoice = GetInput.getWordInput().toLowerCase().charAt(0);

            if (!(userChoice == 'r') && !(userChoice == 'p') && !(userChoice == 's')){
                System.out.println("Invalid input. Please enter rock/ r, paper/ p, scissors/ s.");
            }
            else break;
        }
        return userChoice;
    }

    private int chooseWinner(char userChoice, char computerChoice){

        if (userChoice == computerChoice) {
            System.out.println("It's a tie!");
            return -1;
        } else if (userChoice == 'r') {
            if (computerChoice == 's') {
                System.out.println("You win!");
                return 1;
            } else {
                System.out.println("The Shadow wins!");
                return 0;
            }
        } else if (userChoice == 'p') {
            if (computerChoice == 'r') {
                System.out.println("You win!");
                return 1;
            } else {
                System.out.println("The Shadow wins!");
                return 0;
            }
        } else if (userChoice== 's') {
            if (computerChoice == 'p') {
                System.out.println("You win!");
                return 1;
            } else {
                System.out.println("The Shadow wins!");
                return 0;
            }
        }

        return 0;
    }


}