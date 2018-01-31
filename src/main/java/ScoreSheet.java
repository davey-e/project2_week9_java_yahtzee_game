import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ScoreSheet {

    private LinkedHashMap<ScoreLine, Integer> scores;
    private int upperSectionScore;
    private int totalScore;
    private int upperSectionBonus;

    public ScoreSheet(){
        this.scores = new LinkedHashMap<>();
        this.setupScoresHashMap();
        this.upperSectionScore = 0;
        this.upperSectionBonus = 0;
        this.totalScore = 0;
    }

    private void setupScoresHashMap(){
        this.scores.put(ScoreLine.ONES, null);
        this.scores.put(ScoreLine.TWOS, null);
        this.scores.put(ScoreLine.THREES, null);
        this.scores.put(ScoreLine.FOURS, null);
        this.scores.put(ScoreLine.FIVES, null);
        this.scores.put(ScoreLine.SIXES, null);
    }

    public LinkedHashMap<ScoreLine, Integer> getScores() {
        return this.scores;
    }

    public int getSingleScore(ScoreLine scoreLine) {
        return this.scores.get(scoreLine);
    }

    public int getUpperSectionScore() {
        return this.upperSectionScore;
    }

    public int getUpperSectionBonus() {
        return this.upperSectionBonus;
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
        if (this.scores.get(scoreLine) == null){
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
                this.scores.put(scoreLine, 0);
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
            this.upperSectionBonus = 35;
        }
    }

    public void calculateTotalScore() {
        this.totalScore = this.upperSectionScore + this.upperSectionBonus;
    }
}
