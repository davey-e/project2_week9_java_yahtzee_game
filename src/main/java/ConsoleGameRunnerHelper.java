public class ConsoleGameRunnerHelper {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


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

    public static void showRolledDiceWithColours(Player currentPlayer){

        System.out.println("Roll # " + currentPlayer.getRollCount());
        System.out.println("You rolled:");
        for (int l = 0; l < 5; l++) {
            int currentDieValue = currentPlayer.getDice().get(l).getValue();
            Boolean currentDieHoldStatus = currentPlayer.getDice().get(l).getHoldStatus();
            if (currentDieHoldStatus){
                System.out.print(ANSI_GREEN + currentDieValue + ANSI_RESET);
            } else {
                System.out.print(ANSI_RED + currentDieValue + ANSI_RESET);
            }

        }
        System.out.println();
    }
}
