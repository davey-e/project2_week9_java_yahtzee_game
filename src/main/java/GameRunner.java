import java.util.ArrayList;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRunner {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game game;
        ArrayList<Boolean> diceToHold;
        game = new Game();

        int numberOfTurns = game.getNumberOfTurns();
        game.setupPlayers(2);
        diceToHold = new ArrayList<>();
        diceToHold.addAll(Arrays.asList(true, true, true, true, true));

        for (int i = 0; i < numberOfTurns + 1; i++){
            if (game.getTurnCount() <= 5) {
                for (int j = 0; j < game.getNumberOfPlayers(); j++){
                    Player currentPlayer = game.getPlayers().get(j);
                    for (int k = 0; k < 4; k++){
                        if (currentPlayer.getRollCount() == 0){
                            currentPlayer.playTurn();
                            for (int l = 0; l < 5; l++){
                                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                                System.out.print(currentDieValue);
                            }
                            System.out.println(currentPlayer.getRollCount());
                        } else if (currentPlayer.getRollCount() == 1 || currentPlayer.getRollCount() == 2){

                            currentPlayer.playTurn(diceToHold);
                            for (int l = 0; l < 5; l++) {
                                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                                System.out.print(currentDieValue);
                            }
                            System.out.println(currentPlayer.getRollCount());

                        } else if (currentPlayer.getRollCount() == 3){
                            currentPlayer.playTurn(ScoreLine.ONES);
                            currentPlayer.resetDiceHoldStatus();
                        }
                    }
                }
            }
            game.incrementTurnCount();
        }

        game.calculatePlayerTotalScores();
        game.determineWinner();

        for (int i = 0; i < game.getNumberOfPlayers(); i++){
            System.out.println(game.getPlayers().get(i).getName() + " Score = " + game.getPlayers().get(i).getScoreSheet().getTotalScore());
        }

        System.out.println("The winner is: " + game.getWinner().getName());


    }

}
