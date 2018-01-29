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
    public void setSingleScore(ScoreLine scoreLine, ArrayList<Die> dice) {
        int numberOfDice = dice.size();
        int score = 0;
        if (this.scores.get(scoreLine) == 0){
            for (int i = 0; i < numberOfDice; i++) {
                int diceValue = dice.get(i).getValue();
                if (diceValue == scoreLine.getScoreLineDieValue()) {
                    score += diceValue;
                }
            }
            this.scores.put(scoreLine, score);
        }
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
    }

    public void calculateTotalScore() {
        this.totalScore = this.upperSectionScore;
    }
}
