package Project.MiniGames;

import Project.GetInput;
import java.util.Random;

public class TikTakToe implements IMiniGame {

    @Override
    public boolean playGame() {
        Random random = new Random();
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        boolean computerStarts = random.nextBoolean();
        System.out.println(computerStarts ? "The computer starts first!" : "You start first!");

        drawBoard();

        while (true) {


            if (boardFull(board)) {
                break;
            }

            if (computerStarts) {
                int compChoice = computerChoice(random, board, 'O', 'X');
                board[compChoice] = 'O';
                computerStarts = false;
            } else {
                System.out.println();
                drawBoard(board);
                System.out.println();

                System.out.print("Choose a free tile between 1 and 9 to place your mark: ");
                while (true) {
                    int choice = GetInput.getNumberInput();
                    if (choice > 9 || choice < 1 || board[choice - 1] != ' ') {
                        System.out.print("Please choose a free tile, 1-9: ");
                    } else {
                        board[choice - 1] = 'X';
                        break;
                    }
                }
                computerStarts = true;
            }

            if (chooseWinner(board) == 1 || chooseWinner(board) == 0) {
                break;
            }

            if (remainingMoves(board) == 1) {
                int winningMove = findWinningMove(board);
                if (winningMove == -1) {
                    System.out.println("No winning move available. Skipping...");
                    break;
                }
            }
        }

        drawBoard(board);

        if (chooseWinner(board) != 1 && chooseWinner(board) != 0) {
            System.out.println("\nIt's a tie!\n");
            return this.playGame();
        }

        return chooseWinner(board) == 1;
    }

    private boolean boardFull(char[] n) {
        for (char c : n) {
            if (c == ' ') return false;
        }
        return true;
    }

    @Override
    public void gameRules() {
        System.out.println("The rules are clear.");
        System.out.println("You need to match 3 characters in a row, column, or diagonal to win.\n");
    }

    public int computerChoice(Random random, char[] board, char computer, char player) {
        int useStrategy = random.nextInt(9);

        if (useStrategy < 7) {
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = computer;
                    if (chooseWinner(board) == 1) {
                        board[i] = ' ';
                        return i;
                    }
                    board[i] = ' ';
                }
            }

            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = player;
                    if (chooseWinner(board) == 1) {
                        board[i] = ' ';
                        return i;
                    }
                    board[i] = ' ';
                }
            }

            if (board[4] == ' ') {
                return 4;
            }

            int[] corners = {0, 2, 6, 8};
            for (int corner : corners) {
                if (board[corner] == ' ') {
                    return corner;
                }
            }

            int[] edges = {1, 3, 5, 7};
            for (int edge : edges) {
                if (board[edge] == ' ') {
                    return edge;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    return i;
                }
            }
        }
        while (true) {
            int randomIndex = random.nextInt(9);
            if (board[randomIndex] == ' ') {
                return randomIndex;
            }
        }
    }

    public int chooseWinner(char[] n) {
        int[][] winningConditions = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] condition : winningConditions) {
            if (n[condition[0]] == 'X' && n[condition[1]] == 'X' && n[condition[2]] == 'X') {
                return 1;
            }
            if (n[condition[0]] == 'O' && n[condition[1]] == 'O' && n[condition[2]] == 'O') {
                return 0;
            }
        }
        return -1;
    }

    private int remainingMoves(char[] board) {
        int count = 0;
        for (char c : board) {
            if (c == ' ') count++;
        }
        return count;
    }

    private int findWinningMove(char[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = 'X';
                if (chooseWinner(board) == 1) {
                    board[i] = ' ';
                    return i;
                }
                board[i] = ' ';
            }
        }
        return -1;
    }

    private void drawBoard() {
        for (int i = 1; i < 10; i++) {
            System.out.println(" " + i++ + " | " + i++ + " | " + i);
            if (i != 9) System.out.println("---|---|---");
        }
    }

    private void drawBoard(char[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println(" " + n[i++] + " | " + n[i++] + " | " + n[i]);
            if (i != n.length - 1) System.out.println("---|---|---");
        }
    }
}
