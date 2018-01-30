import java.util.ArrayList;
import java.util.HashMap;

public class ScoreSheet {

    private HashMap<ScoreLine, Integer> scores;
    private int upperSectionScore;
    private int totalScore;

    public ScoreSheet(){
        this.scores = new HashMap<>();
        this.setupScoresHashMap();
        this.upperSectionScore = 0;
        this.totalScore = 0;
    }

    private void setupScoresHashMap(){
        this.scores.put(ScoreLine.ONES, 0);
        this.scores.put(ScoreLine.TWOS, 0);
        this.scores.put(ScoreLine.THREES, 0);
        this.scores.put(ScoreLine.FOURS, 0);
        this.scores.put(ScoreLine.FIVES, 0);
        this.scores.put(ScoreLine.SIXES, 0);
    }

    public HashMap<ScoreLine, Integer> getScores() {
        return this.scores;
    }

    public int getSingleScore(ScoreLine scoreLine) {
        return this.scores.get(scoreLine);
    }

    public int getUpperSectionScore() {
        return this.upperSectionScore;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    // This is where the rules of applying a score to a specific scoreline will be enforced, so logic could get messy, but will be a good opportunity for refactoring
    //Logic pseudocode (for upper section only):
    // If scoreLine has not yet been set (i.e. current score == 0) then
    //      check which scoreLine the player wants to assign the score to (case)
    //          iterate through each of the dice in the ArrayList and for each one where the die value == scoreLine value add the die value to a totalizer
    //      add the totalizer score to the scores hashmap
    //
    // the int that this method now returns is a status indicator for the result of this method.
    // 0 = score successfully assigned to the ScoreLine as selected by the Player
    // 1 = no dice match the selected ScoreLine, so score has been set to 0
    // 2 = score has already been assigned to the ScoreLine, so can't be assigned again
    //
    public int setSingleScore(ScoreLine scoreLine, ArrayList<Die> dice) {
        int numberOfDice = dice.size();
        int score = 0;
        if (this.scores.get(scoreLine) == 0){
            for (int i = 0; i < numberOfDice; i++) {
                int diceValue = dice.get(i).getValue();
                if (diceValue == scoreLine.getScoreLineDieValue()) {
                    score += diceValue;
                }
            }
            if (score > 0){
                this.scores.put(scoreLine, score);
                return 0;
            } else {
                return 1;
            }
        }
        return 2;
    }

    public void setUpperSectionScore(int score) {
        this.upperSectionScore = score;
    }

    public void setTotalScore(int score) {
        this.totalScore = score;
    }

    public void calculateUpperSectionScore() {
        this.upperSectionScore += scores.get(ScoreLine.ONES);
        this.upperSectionScore += scores.get(ScoreLine.TWOS);
        this.upperSectionScore += scores.get(ScoreLine.THREES);
        this.upperSectionScore += scores.get(ScoreLine.FOURS);
        this.upperSectionScore += scores.get(ScoreLine.FIVES);
        this.upperSectionScore += scores.get(ScoreLine.SIXES);
        if (this.upperSectionScore >= 63 ){
            this.upperSectionScore += 35;
        }
    }

    public void calculateTotalScore() {
        this.totalScore = this.upperSectionScore;
    }
}
