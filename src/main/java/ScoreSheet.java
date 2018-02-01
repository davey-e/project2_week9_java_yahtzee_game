import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ScoreSheet {

    private LinkedHashMap<ScoreLine, Integer> scores;
    private int upperSectionScore;
    private int upperSectionBonus;
    private int lowerSectionScore;
    private int totalScore;


    public ScoreSheet(){
        this.scores = new LinkedHashMap<>();
        this.setupScoresHashMap();
        this.upperSectionScore = 0;
        this.upperSectionBonus = 0;
        this.lowerSectionScore = 0;
        this.totalScore = 0;
    }

    private void setupScoresHashMap(){
        this.scores.put(ScoreLine.ONES, null);
        this.scores.put(ScoreLine.TWOS, null);
        this.scores.put(ScoreLine.THREES, null);
        this.scores.put(ScoreLine.FOURS, null);
        this.scores.put(ScoreLine.FIVES, null);
        this.scores.put(ScoreLine.SIXES, null);
        this.scores.put(ScoreLine.THREEOAK, null);
        this.scores.put(ScoreLine.FOUROAK, null);
        this.scores.put(ScoreLine.FH, null);
        this.scores.put(ScoreLine.SMALLSTR, null);
        this.scores.put(ScoreLine.LARGESTR, null);
        this.scores.put(ScoreLine.YAHTZEE, null);
        this.scores.put(ScoreLine.CHANCE, null);
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

    public int getLowerSectionScore() {
        return lowerSectionScore;
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
            if (scoreLine.getScoreLineValue() >= 1 && scoreLine.getScoreLineValue() <= 6) {
                for (int i = 0; i < numberOfDice; i++) {
                    int diceValue = dice.get(i).getValue();
                    if (diceValue == scoreLine.getScoreLineValue()) {
                        score += diceValue;
                    }
                }
            } else if (scoreLine.getScoreLineValue() == 7){
                //TODO Do logic to confirm 3 of a kind
                for (int i = 0; i < numberOfDice; i++) {
                    int diceValue = dice.get(i).getValue();
                    score += diceValue;
                }
            } else if (scoreLine.getScoreLineValue() == 8){
                //TODO Do logic to confirm 4 of a kind
                for (int i = 0; i < numberOfDice; i++) {
                    int diceValue = dice.get(i).getValue();
                    score += diceValue;
                }
            } else if (scoreLine.getScoreLineValue() == 9){
                //TODO Do logic to confirm full house
                score = 25;
            } else if (scoreLine.getScoreLineValue() == 10){
                //TODO Do logic to confirm small straight
                score = 30;
            } else if (scoreLine.getScoreLineValue() == 11){
                //TODO Do logic to confirm large straight
                score = 40;
            } else if (scoreLine.getScoreLineValue() == 12){
                int equalityCounter = 1;
                int previousDieValue = 0;
                for (int i = 0; i < numberOfDice; i++) {
                    int diceValue = dice.get(i).getValue();
                    if (diceValue == previousDieValue){
                        equalityCounter += 1;
                    }
                    previousDieValue = diceValue;
                }
                if (equalityCounter == 5){
                    score = 50;
                }

            }else if (scoreLine.getScoreLineValue() == 13){
                //No checks needed for chance
                for (int i = 0; i < numberOfDice; i++) {
                    int diceValue = dice.get(i).getValue();
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

    public void calculateLowerSectionScore() {
        this.lowerSectionScore += scores.get(ScoreLine.THREEOAK);
        this.lowerSectionScore += scores.get(ScoreLine.FOUROAK);
        this.lowerSectionScore += scores.get(ScoreLine.FH);
        this.lowerSectionScore += scores.get(ScoreLine.SMALLSTR);
        this.lowerSectionScore += scores.get(ScoreLine.LARGESTR);
        this.lowerSectionScore += scores.get(ScoreLine.YAHTZEE);
        this.lowerSectionScore += scores.get(ScoreLine.CHANCE);
    }

    public void calculateTotalScore() {
        this.totalScore = this.upperSectionScore + this.upperSectionBonus + this.lowerSectionScore;
    }


}
