import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private ArrayList<Die> dice;
    private ScoreSheet scoreSheet;


    public Player(String name, ArrayList<Die> dice){
        this.name = name;
        this.dice = dice;
        this.scoreSheet = new ScoreSheet();

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
}
