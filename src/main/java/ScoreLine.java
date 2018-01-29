public enum ScoreLine {

    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6);

    private final int dieValue;

    ScoreLine(int dieValue){
        this.dieValue = dieValue;
    }

    public int getScoreLineDieValue(){
        return this.dieValue;
    }

}
