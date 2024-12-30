package Project;

public class GameLoop {

    private final NarrativeManager narrator;
    private final GamesList gameList;
    private final Character player;
    private final Character dragon;

    public GameLoop(String playerName) {
        Inventory inventory = new Inventory();
        player = new Character(playerName, 100);
        dragon = new Character("Dragon", 100);
        narrator = new NarrativeManager(inventory, player);
        gameList = new GamesList();
    }

    public void run() {
        boolean gameLost = false;

        while (true) {
            narrator.proposeChallenge();
            System.out.print("DO you accept this Challenge?(Y/N): ");
            String choice = GetInput.getWordInput();

            if (choice.equalsIgnoreCase("n")) {
                return;
            }

            System.out.println("\nGet ready " + player.getName());

            while (gameList.notLastGame() && !gameLost) {
                narrator.nextDoorNarration();

                while (gameList.notLastGame()) {
                    boolean wonMiniGame = gameList.playNextGame();

                    if (!wonMiniGame) {
                        player.takeDamage(10);
                        System.out.println("Your health is " + player.getHealth());
                        if (player.getHealth() <= 0) {
                            gameLost = true;
                            break;
                        }
                        System.out.print("Mini Game Lost! Try again?(Y/N): ");
                        if (GetInput.getWordInput().equalsIgnoreCase("n")) {
                            narrator.gameLostMessage();
                            return;
                        }
                    }
                    else break;
                }
            }

            if(!gameLost)
                gameLost = playLastGame(gameLost);


            if (gameLost) {
                narrator.gameLostMessage();
            } else {
                narrator.gameWonMessage();
            }

            System.out.print("\n\nPlay Again?(Y/N): ");

            choice = GetInput.getWordInput();
            if (choice.toLowerCase().charAt(0) == 'n') {
                break;
            }

            restartGame();
            gameLost = false;
        }
    }

    private void restartGame() {
        gameList.restartGame();
        narrator.restartNarration();
        player.resetStats();
        dragon.resetStats();
    }

    private boolean playLastGame(boolean gameLost) {
        narrator.nextDoorNarration();
        narrator.lastGameRules();

        while (!gameLost && dragon.getHealth() > 0){
            boolean wonLastGame = gameList.playNextGame();
            int i;
            int roll = gameList.playDice();
            if(wonLastGame) {
                if(roll < 0){
                    dragon.takeDamage(-roll*5);
                    System.out.println("dragon is hit for "+ -roll*5 +" health points.");
                }
                i = 1;
            }else {
                if(roll > 0){
                    player.takeDamage(roll*5);
                    System.out.println("You are hit for "+ roll*5 +" health points.");
                }
                if(player.getHealth() <= 0){
                    gameLost = true;
                    continue;
                }
                i = 0;
            }
            narrator.getDragonConversation(i);
        }
        return gameLost;
    }
}
