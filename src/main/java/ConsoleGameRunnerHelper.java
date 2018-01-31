public class ConsoleGameRunnerHelper {

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
}
