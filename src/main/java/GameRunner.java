import java.util.ArrayList;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRunner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game game;
        game = new Game();
        int numberOfPlayers = 1;

        int numberOfTurns = game.getNumberOfTurns();

        //UI Output
        //---------
        System.out.println("How many players are playing?");
        //---------

        //UI Input
        //--------
        String numberOfPlayersInput = br.readLine();
        numberOfPlayers = Integer.parseInt(numberOfPlayersInput);
        //--------

        game.setupPlayers(numberOfPlayers);

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
                            ConsoleGameRunnerHelper.showRolledDiceWithColours(currentPlayer);
                            //---------


                        } else if (currentPlayer.getRollCount() == 1 || currentPlayer.getRollCount() == 2){

                            //UI Output
                            //---------
                            System.out.println("Please indicate which dice you want to hold? e.g. type T, F, T, F, T to hold dice 1, 3 and 5");
                            System.out.println("Just press Enter if you don't want to change the dice that are held");
                            //---------

                            //UI Input
                            //--------
                            String userInput = br.readLine();
                            //--------

                            //Convert user input into an arraylist of booleans
                            //------------------------------------------------
                            userInput = userInput.toUpperCase();
                            ArrayList<Boolean> diceToHoldAsBooleans = new ArrayList<>();
                            if (!(userInput.equals(""))) {
                                ArrayList<String> diceToHoldAsString = new ArrayList<>();
                                diceToHoldAsString.addAll(Arrays.asList(userInput.split(",")));

                                for (i = 0; i < 5; i++) {
                                    if (diceToHoldAsString.get(i).equals("T")) {
                                        diceToHoldAsBooleans.add(true);
                                    } else {
                                        diceToHoldAsBooleans.add(false);
                                    }
                                }
                                currentPlayer.playTurn(diceToHoldAsBooleans);
                            } else {
                                currentPlayer.playTurn();
                            }
                            //------------------------------------------------

                            //UI Output
                            //---------
                            ConsoleGameRunnerHelper.showRolledDiceWithColours(currentPlayer);
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

                            ScoreLine selectedScoreLine;
                            selectedScoreLine = ConsoleGameRunnerHelper.convertUserInputToScoreLine(userInput);

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

        System.out.println(ANSI_GREEN + "The winner is: " + game.getWinner().getName() + ANSI_RESET);
        //---------
    }

}
