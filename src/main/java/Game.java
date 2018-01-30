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
        return winner;
    }
}
