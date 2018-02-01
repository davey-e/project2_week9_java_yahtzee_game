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
            case "7": selectedScoreLine = ScoreLine.THREEOAK;
                break;
            case "8": selectedScoreLine = ScoreLine.FOUROAK;
                break;
            case "9": selectedScoreLine = ScoreLine.FH;
                break;
            case "10": selectedScoreLine = ScoreLine.SMALLSTR;
                break;
            case "11": selectedScoreLine = ScoreLine.LARGESTR;
                break;
            case "12": selectedScoreLine = ScoreLine.YAHTZEE;
                break;
            case "13": selectedScoreLine = ScoreLine.CHANCE;
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
        System.out.println(ANSI_CYAN + currentPlayer.getName() + " Turn # " + (turn + 1) + ANSI_RESET);
        showPlayersScoreSheet(currentPlayer);
    }


    public static void showRolledDiceWithColours(Player currentPlayer){
        System.out.println();
        System.out.println(ANSI_CYAN + "Roll # " + currentPlayer.getRollCount() + ANSI_RESET);
        System.out.println("You rolled:");
        System.out.println();
        if (currentPlayer.getRollCount() == 3){
            for (int l = 0; l < 5; l++) {
                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                System.out.print(ANSI_PURPLE + currentDieValue + " " + ANSI_RESET);
            }
        } else {
            for (int l = 0; l < 5; l++) {
                int currentDieValue = currentPlayer.getDice().get(l).getValue();
                Boolean currentDieHoldStatus = currentPlayer.getDice().get(l).getHoldStatus();
                if (currentDieHoldStatus){
                    System.out.print(ANSI_GREEN + currentDieValue + " " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_RED + currentDieValue + " " + ANSI_RESET);
                }
            }
        }
        System.out.println();
    }

    public static void showFormattedUpperSectionScores(ScoreSheet currentPlayerScoreSheet){
        System.out.println("******* Upper Section ********");
        System.out.println("(" + ScoreLine.ONES.getScoreLineValue() +")  Ones:                  " + currentPlayerScoreSheet.getScores().get(ScoreLine.ONES));
        System.out.println("(" + ScoreLine.TWOS.getScoreLineValue() +")  Twos:                  " + currentPlayerScoreSheet.getScores().get(ScoreLine.TWOS));
        System.out.println("(" + ScoreLine.THREES.getScoreLineValue() +")  Threes:                " + currentPlayerScoreSheet.getScores().get(ScoreLine.THREES));
        System.out.println("(" + ScoreLine.FOURS.getScoreLineValue() +")  Fours:                 " + currentPlayerScoreSheet.getScores().get(ScoreLine.FOURS));
        System.out.println("(" + ScoreLine.FIVES.getScoreLineValue() +")  Fives:                 " + currentPlayerScoreSheet.getScores().get(ScoreLine.FIVES));
        System.out.println("(" + ScoreLine.SIXES.getScoreLineValue() +")  Sixes:                 " + currentPlayerScoreSheet.getScores().get(ScoreLine.SIXES));
        System.out.println("******************************");
    }

    public static void showFormattedLowerSectionScores(ScoreSheet currentPlayerScoreSheet){
        System.out.println("******* Lower Section ********");
        System.out.println("(" + ScoreLine.THREEOAK.getScoreLineValue() +")  3 of a Kind:           " + currentPlayerScoreSheet.getScores().get(ScoreLine.THREEOAK));
        System.out.println("(" + ScoreLine.FOUROAK.getScoreLineValue() +")  4 of a Kind:           " + currentPlayerScoreSheet.getScores().get(ScoreLine.FOUROAK));
        System.out.println("(" + ScoreLine.FH.getScoreLineValue() +")  Full House:            " + currentPlayerScoreSheet.getScores().get(ScoreLine.FH));
        System.out.println("(" + ScoreLine.SMALLSTR.getScoreLineValue() +") Small Straight:        " + currentPlayerScoreSheet.getScores().get(ScoreLine.SMALLSTR));
        System.out.println("(" + ScoreLine.LARGESTR.getScoreLineValue() +") Large Straight:        " + currentPlayerScoreSheet.getScores().get(ScoreLine.LARGESTR));
        System.out.println("(" + ScoreLine.YAHTZEE.getScoreLineValue() +") Yahtzee:               " + currentPlayerScoreSheet.getScores().get(ScoreLine.YAHTZEE));
        System.out.println("(" + ScoreLine.CHANCE.getScoreLineValue() +") Chance:                " + currentPlayerScoreSheet.getScores().get(ScoreLine.CHANCE));
        System.out.println("******************************");
    }



    public static void showPlayersScoreSheet(Player currentPlayer){
        ScoreSheet currentPlayerScoreSheet = currentPlayer.getScoreSheet();
        System.out.println();
        System.out.println("Your scoresheet:");
        System.out.println();
        showFormattedUpperSectionScores(currentPlayerScoreSheet);
        System.out.println();
        showFormattedLowerSectionScores(currentPlayerScoreSheet);
    }

    public static void showFinalScores(Game game){
        for (int i = 0; i < game.getNumberOfPlayers(); i++){
            Player currentPlayer = game.getPlayers().get(i);
            ScoreSheet currentPlayerScoreSheet = currentPlayer.getScoreSheet();
            System.out.println(currentPlayer.getName() + " Scoresheet:");
            showFormattedUpperSectionScores(currentPlayerScoreSheet);
            System.out.println("Upper Section Score =       " + game.getPlayers().get(i).getScoreSheet().getUpperSectionScore());
            System.out.println("Upper Section Bonus =       " + game.getPlayers().get(i).getScoreSheet().getUpperSectionBonus());
            showFormattedLowerSectionScores(currentPlayerScoreSheet);
            System.out.println("Lower Section Score =       " + game.getPlayers().get(i).getScoreSheet().getLowerSectionScore());
            System.out.println(ANSI_CYAN + "Total Score =               " + game.getPlayers().get(i).getScoreSheet().getTotalScore() + ANSI_RESET);
        }

        System.out.println();
        if (game.getWinner() != null){
            System.out.println(ANSI_GREEN + "The winner is: " + game.getWinner().getName() + ANSI_RESET);
        } else if (game.getNumberOfPlayers() > 1){
            System.out.println(ANSI_GREEN + "It's a draw! " + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "That's a great score! Next time try playing against another player, you're sure to Win!" + ANSI_RESET);
        }
        System.out.println();

    }

    public static void showWelcomeScreen(){
        System.out.println(ANSI_CLEAR_SCREEN);
        System.out.println(ANSI_RED + "Welcome's to Dave's Yahtzee game!!!");
        System.out.println("-----------------------------------" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Rules");
        System.out.println("-----");
        System.out.println();
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
