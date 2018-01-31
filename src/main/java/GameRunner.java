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

                    //UI Output
                    //---------
                    System.out.println(currentPlayer.getName() + "'s turn");
                    System.out.println("Your scoresheet currently looks like this:");
                    System.out.println(currentPlayer.getScoreSheet().getScores());
                    //---------

                    for (int k = 0; k < 4; k++){
                        if (currentPlayer.getRollCount() == 0){
                            currentPlayer.playTurn();

                            //UI Output
                            //---------
                            System.out.println("Roll # " + currentPlayer.getRollCount());
                            System.out.println("You rolled:");
                            for (int l = 0; l < 5; l++){
                                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                                System.out.print(currentDieValue);
                            }
                            System.out.println();
                            //---------

                        } else if (currentPlayer.getRollCount() == 1 || currentPlayer.getRollCount() == 2){

                            //UI Output
                            //---------
                            System.out.println("Please indicate which dice you want to hold? e.g. type T, F, T, F, T to hold dice 1, 3 and 5");
                            //---------

                            //UI Input
                            //--------
                            String userInput = br.readLine();
                            //--------

                            //Convert user input into an arraylist of booleans
                            //------------------------------------------------
                            ArrayList<String> diceNumbersToHoldAsString = new ArrayList<>();
                            diceNumbersToHoldAsString.addAll(Arrays.asList(userInput.split(",")));
                            ArrayList<Boolean> diceToHoldAsBooleans = new ArrayList<>();
                            for (i = 0; i < 5; i++){
                                if (diceNumbersToHoldAsString.get(i).equals("T")){
                                    diceToHoldAsBooleans.add(true);
                                } else {
                                    diceToHoldAsBooleans.add(false);
                                }
                            }
                            //------------------------------------------------

                            currentPlayer.playTurn(diceToHoldAsBooleans);

                            //UI Output
                            //---------
                            System.out.println("Roll # " + currentPlayer.getRollCount());
                            System.out.println("You rolled:");
                            for (int l = 0; l < 5; l++) {
                                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                                System.out.print(currentDieValue);
                            }
                            System.out.println();
                            //---------

                        } else if (currentPlayer.getRollCount() == 3){

                            //UI Output
                            //---------
                            System.out.println("Which Scoreline do you want to assign these dice to? e.g. type 1 to assign to Ones");
                            //--------

                            //UI Input
                            //--------
                            String userInput = br.readLine();
                            //--------

                            //Convert user input into ScoreLine enum
                            //--------------------------------------

                            ScoreLine selectedScoreLine = null;
                            switch (userInput){
                                case "1": selectedScoreLine = ScoreLine.ONES;
                                            break;
                                case "2": selectedScoreLine = ScoreLine.TWOS;
                                            break;
                                case "3": selectedScoreLine = ScoreLine.THREES;
                                            break;
                                case "4": selectedScoreLine = ScoreLine.FOURS;
                                            break;
                                case "5": selectedScoreLine = ScoreLine.FIVES;
                                            break;
                                case "6": selectedScoreLine = ScoreLine.SIXES;
                                            break;

                            }

                            //---------------------------------------

                            currentPlayer.playTurn(selectedScoreLine);
                            currentPlayer.resetDiceHoldStatus();
                        }
                    }
                }
            }
            game.incrementTurnCount();
        }

        game.calculatePlayerTotalScores();
        game.determineWinner();

        //UI Output
        //---------
        for (int i = 0; i < game.getNumberOfPlayers(); i++){
            System.out.println(game.getPlayers().get(i).getName() + " Upper Section Score = " + game.getPlayers().get(i).getScoreSheet().getUpperSectionScore());
            System.out.println(game.getPlayers().get(i).getName() + " Total Score = " + game.getPlayers().get(i).getScoreSheet().getTotalScore());
        }

        System.out.println("The winner is: " + game.getWinner().getName());
        //---------
    }

}
