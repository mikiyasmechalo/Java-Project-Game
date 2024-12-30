package Project;

import Project.MiniGames.*;
import java.util.ArrayList;

public class GamesList {

    private int index = 0;

     ArrayList<IMiniGame> miniGames;
     DiceRoll die = new DiceRoll();

     public GamesList() {
         miniGames = new ArrayList<>();
         miniGames.add(new RockPaperScissors());
         miniGames.add(new HangMan());
         miniGames.add(new WordScramble());
         miniGames.add(new TikTakToe());
     }

     public boolean playNextGame(){
         boolean wonGame = miniGames.get(index).playGame();

         if(wonGame && notLastGame()){
             index++;
         }
         return wonGame;
     }

     public int playDice(){
         return die.roll();
     }

     public void restartGame(){
         index = 0;
     }

     public boolean notLastGame(){
         return index != miniGames.size()-1;
     }
}
