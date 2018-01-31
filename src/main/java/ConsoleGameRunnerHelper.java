import java.util.ArrayList;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGameRunnerHelper {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_CLEAR_SCREEN = "\033[H\033[2J";
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static ScoreLine convertUserInputToScoreLine(String userInput){

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
        return selectedScoreLine;
    }


    public static ArrayList<Boolean> convertUserInputToArrayListOfBooleans(String userInput){

        //Convert user input into an arraylist of booleans
        //------------------------------------------------
        userInput = userInput.toUpperCase();
        ArrayList<Boolean> diceToHoldAsBooleans = new ArrayList<>();
        if (!(userInput.equals(""))) {
            ArrayList<String> diceToHoldAsString = new ArrayList<>();
            diceToHoldAsString.addAll(Arrays.asList(userInput.split("")));

            for (int i = 0; i < 5; i++) {
                if (diceToHoldAsString.get(i).equals("T")) {
                    diceToHoldAsBooleans.add(true);
                } else {
                    diceToHoldAsBooleans.add(false);
                }
            }
            return diceToHoldAsBooleans;
        } else {
            return null;
        }
    }

    public static void showGameStatus(Player currentPlayer, int turn){
        System.out.print(ANSI_CLEAR_SCREEN);
        System.out.println(currentPlayer.getName() + " Turn # " + (turn + 1));
        showPlayersScoreSheet(currentPlayer);
    }


    public static void showRolledDiceWithColours(Player currentPlayer){
        System.out.println();
        System.out.println("Roll # " + currentPlayer.getRollCount());
        System.out.println("You rolled:");
        System.out.println();
        for (int l = 0; l < 5; l++) {
            int currentDieValue = currentPlayer.getDice().get(l).getValue();
            Boolean currentDieHoldStatus = currentPlayer.getDice().get(l).getHoldStatus();
            if (currentDieHoldStatus){
                System.out.print(ANSI_GREEN + currentDieValue + " " + ANSI_RESET);
            } else {
                System.out.print(ANSI_RED + currentDieValue + " " + ANSI_RESET);
            }

        }
        System.out.println();
    }

    public static void showFormattedUpperSectionScores(ScoreSheet currentPlayerScoreSheet){

        System.out.println("Ones: " + currentPlayerScoreSheet.getScores().get(ScoreLine.ONES));
        System.out.println("Twos: " + currentPlayerScoreSheet.getScores().get(ScoreLine.TWOS));
        System.out.println("Threes: " + currentPlayerScoreSheet.getScores().get(ScoreLine.THREES));
        System.out.println("Fours: " + currentPlayerScoreSheet.getScores().get(ScoreLine.FOURS));
        System.out.println("Fives: " + currentPlayerScoreSheet.getScores().get(ScoreLine.FIVES));
        System.out.println("Sixes: " + currentPlayerScoreSheet.getScores().get(ScoreLine.SIXES));

    }

    public static void showPlayersScoreSheet(Player currentPlayer){
        ScoreSheet currentPlayerScoreSheet = currentPlayer.getScoreSheet();
        System.out.println();
        System.out.println("Your scoresheet currently looks like this:");
        showFormattedUpperSectionScores(currentPlayerScoreSheet);
    }

    public static void showFinalScores(Game game){
        for (int i = 0; i < game.getNumberOfPlayers(); i++){
            Player currentPlayer = game.getPlayers().get(i);
            ScoreSheet currentPlayerScoreSheet = currentPlayer.getScoreSheet();
            System.out.println(currentPlayer.getName() + " Scoresheet:");
            showFormattedUpperSectionScores(currentPlayerScoreSheet);
            System.out.println("Upper Section Score = " + game.getPlayers().get(i).getScoreSheet().getUpperSectionScore());
            System.out.println("Upper Section Bonus = " + game.getPlayers().get(i).getScoreSheet().getUpperSectionBonus());
            System.out.println("Total Score = " + game.getPlayers().get(i).getScoreSheet().getTotalScore());
            System.out.println();
        }

        System.out.println();
        System.out.println(ANSI_GREEN + "The winner is: " + game.getWinner().getName() + ANSI_RESET);
    }

    public static String getUserInput() throws IOException {
        String userInput;
        while (true){
            userInput = br.readLine();
            if (!(userInput.equals(""))){
                break;
            }
            else {
                System.out.println("Please enter a valid selection");
            }
        }
        return userInput;
    }

    public static void setScoreForSelectedScoreLine(Player currentPlayer) throws IOException {

        String userInput;
        while (true) {
            userInput = ConsoleGameRunnerHelper.getUserInput();
            ScoreLine selectedScoreLine;
            selectedScoreLine = ConsoleGameRunnerHelper.convertUserInputToScoreLine(userInput);
            int setScoreStatus = currentPlayer.setScore(selectedScoreLine);
            if (setScoreStatus == 0) {
                break;
            } else if (setScoreStatus == 1){
                break;
            } else if (setScoreStatus == 2){
                System.out.println("You have already set a score for that line, please select another line");
            }
        }

    }
}
