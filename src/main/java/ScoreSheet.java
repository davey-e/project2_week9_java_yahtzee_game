import java.util.HashMap;

public class ScoreSheet {

    private HashMap<String, Integer> scores;
    private int upperSectionScore;
    private int totalScore;

    public ScoreSheet(){
        this.scores = new HashMap<>();
        this.scores.put("Ones", 0);
        this.scores.put("Twos", 0);
        this.scores.put("Threes", 0);
        this.scores.put("Fours", 0);
        this.scores.put("Fives", 0);
        this.scores.put("Sixes", 0);
        this.upperSectionScore = 0;
        this.totalScore = 0;
    }

    public HashMap<String, Integer> getScores() {
        return this.scores;
    }

    public int getUpperSectionScore() {
        return this.upperSectionScore;
    }

    public int getTotalScore() {
        return this.totalScore;
    }
}
