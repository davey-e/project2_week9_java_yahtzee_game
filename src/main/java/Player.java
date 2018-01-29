import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private ArrayList<Die> dice;


    public Player(String name, ArrayList<Die> dice){
        this.name = name;
        this.dice = dice;

    }


    public String getName() {
        return this.name;
    }

    public ArrayList<Die> getDice() {
        return this.dice;
    }
}
