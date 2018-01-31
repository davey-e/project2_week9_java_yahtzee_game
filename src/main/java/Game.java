import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Player winner;
    private int numberOfTurns;
    private int turnCount;

    public Game() {
        this.players = new ArrayList<>();
        this.winner = null;
        this.numberOfTurns = 13;
        this.turnCount = 0;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public Player getWinner() {
        return this.winner;
    }

    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }

    public int getTurnCount() {
        return this.turnCount;
    }

    public void incrementTurnCount() {
        this.turnCount +=1;
    }

    public void setupPlayers(int numberOfPlayers) {
        for (Integer i = 0; i < numberOfPlayers; i++){
            Integer playerNumber = i + 1;
            String playerName = "Player" + playerNumber.toString();
            Player player = new Player(playerName);
            players.add(player);
        }
    }

    public int getNumberOfPlayers(){
        return this.players.size();
    }

    public void calculatePlayerTotalScores() {
        for (int i = 0; i < this.getNumberOfPlayers(); i++) {
            Player currentPlayer = this.getPlayers().get(i);
            currentPlayer.getScoreSheet().calculateUpperSectionScore();
            currentPlayer.getScoreSheet().calculateTotalScore();
        }
    }

    public void determineWinner() {
        Player currentWinner = null;
        int numberOfPlayers = getNumberOfPlayers();
        int currentHighestScore = 0;
        for (int i = 0; i < numberOfPlayers; i++){
            int playerScore = this.players.get(i).getScoreSheet().getTotalScore();
            if (playerScore > currentHighestScore){
                currentHighestScore = playerScore;
                currentWinner = this.players.get(i);
            }
        }
        this.winner = currentWinner;
    }
}
