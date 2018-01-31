import java.util.ArrayList;

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
    public static final String ANSI_CLEAR_SCREEN = "\033[H\033[2J";




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
        String numberOfPlayersInput = ConsoleGameRunnerHelper.getUserInput();
        numberOfPlayers = Integer.parseInt(numberOfPlayersInput);
        //--------

        game.setupPlayers(numberOfPlayers);

        for (int i = 0; i < numberOfTurns + 1; i++){
            int turnCount = game.getTurnCount();
            if (turnCount <= 5) {
                for (int j = 0; j < game.getNumberOfPlayers(); j++){
                    Player currentPlayer = game.getPlayers().get(j);

                    for (int k = 0; k < 4; k++){
                        if (currentPlayer.getRollCount() == 0){
                            currentPlayer.playTurn();

                            //UI Output
                            //---------
                            ConsoleGameRunnerHelper.showGameStatus(currentPlayer, turnCount);
                            ConsoleGameRunnerHelper.showRolledDiceWithColours(currentPlayer);
                            //---------


                        } else if (currentPlayer.getRollCount() == 1 || currentPlayer.getRollCount() == 2){

                            //UI Output
                            //---------
                            System.out.println();
                            System.out.println("Please indicate which dice you want to hold? e.g. type tftft or TFTFT to hold dice 1, 3 and 5");
                            System.out.println("Just press Enter if you don't want to change the dice that are held");
                            //---------

                            //UI Input
                            //--------
                            String userInput = br.readLine();
                            //--------

                            ArrayList<Boolean> diceToHoldAsBooleans = new ArrayList<>();
                            diceToHoldAsBooleans = ConsoleGameRunnerHelper.convertUserInputToArrayListOfBooleans(userInput);

                            if (diceToHoldAsBooleans != null) {
                                currentPlayer.playTurn(diceToHoldAsBooleans);
                            } else {
                                currentPlayer.playTurn();
                            }

                            //UI Output
                            //---------
                            ConsoleGameRunnerHelper.showGameStatus(currentPlayer, turnCount);
                            ConsoleGameRunnerHelper.showRolledDiceWithColours(currentPlayer);
                            //---------

                        } else if (currentPlayer.getRollCount() == 3){

                            //UI Output
                            //---------
                            System.out.println();
                            System.out.println("Which Scoreline do you want to assign these dice to? e.g. type 1 to assign to Ones");
                            //--------

                            ConsoleGameRunnerHelper.setScoreForSelectedScoreLine(currentPlayer);
                            currentPlayer.resetDiceHoldStatus();
                        }
                    }
                }
            }
            game.incrementTurnCount();
        }

        game.calculatePlayerTotalScores();
        game.determineWinner();
        System.out.print(ANSI_CLEAR_SCREEN);
        //UI Output
        //---------
        ConsoleGameRunnerHelper.showFinalScores(game);
        //---------
    }

}
