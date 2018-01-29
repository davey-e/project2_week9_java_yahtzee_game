import java.util.ArrayList;
import java.util.HashMap;

public class ScoreSheet {

    private HashMap<String, Integer> scores;
    private int upperSectionScore;
    private int totalScore;

    public ScoreSheet(){
        this.scores = new HashMap<>();
        this.setupScoresHashMap();
        this.upperSectionScore = 0;
        this.totalScore = 0;
    }

    private void setupScoresHashMap(){
        this.scores.put("Ones", 0);
        this.scores.put("Twos", 0);
        this.scores.put("Threes", 0);
        this.scores.put("Fours", 0);
        this.scores.put("Fives", 0);
        this.scores.put("Sixes", 0);
    }

    public HashMap<String, Integer> getScores() {
        return this.scores;
    }

    public int getSingleScore(String scoreLine) {
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
    public void setSingleScore(String scoreLine, ArrayList<Die> dice) {
        int numberOfDice = dice.size();
        int score = 0;
        if (this.scores.get(scoreLine) == 0){

            switch (scoreLine){

                case "Ones":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 1) {
                            score += diceValue;
                        }
                    }
                    break;

                case "Twos":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 2) {
                            score += diceValue;
                        }
                    }
                    break;

                case "Threes":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 3) {
                            score += diceValue;
                        }
                    }
                    break;

                case "Fours":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 4) {
                            score += diceValue;
                        }
                    }
                    break;
                case "Fives":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 5) {
                            score += diceValue;
                        }
                    }
                    break;
                case "Sixes":
                    for (int i = 0; i < numberOfDice; i++) {
                        int diceValue = dice.get(i).getValue();
                        if (diceValue == 6) {
                            score += diceValue;
                        }
                    }
                    break;
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
        this.upperSectionScore += scores.get("Ones");
        this.upperSectionScore += scores.get("Twos");
        this.upperSectionScore += scores.get("Threes");
        this.upperSectionScore += scores.get("Fours");
        this.upperSectionScore += scores.get("Fives");
        this.upperSectionScore += scores.get("Sixes");
    }

    public void calculateTotalScore() {
        this.totalScore = this.upperSectionScore;
    }
}
