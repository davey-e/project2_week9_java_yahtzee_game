import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private ArrayList<Die> dice;
    private ScoreSheet scoreSheet;
    private int rollCount;


    public Player(String name, ArrayList<Die> dice){
        this.name = name;
        this.dice = dice;
        this.scoreSheet = new ScoreSheet();
        this.rollCount = 0;
    }


    public String getName() {
        return this.name;
    }

    public ArrayList<Die> getDice() {
        return this.dice;
    }

    public ScoreSheet getScoreSheet() {
        return this.scoreSheet;
    }

    public int getRollCount() {
        return this.rollCount;
    }
}
