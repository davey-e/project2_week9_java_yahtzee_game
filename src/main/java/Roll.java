import java.util.ArrayList;

public class Roll {

    public static void rollDice(ArrayList<Die> dice){
        int numberOfDice = dice.size();
        for(int i = 0; i < numberOfDice; i++){
            dice.get(i).rollDie();
        }
    }
}
