import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Player winner;

    public Game() {
        this.players = new ArrayList<>();
        this.winner = null;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setupPlayers(int numberOfPlayers) {
        for (Integer i = 0; i < numberOfPlayers; i++){
            Integer playerNumber = i + 1;
            String playerName = "Player" + playerNumber.toString();
            Player player = new Player(playerName);
            players.add(player);
        }
    }
}
