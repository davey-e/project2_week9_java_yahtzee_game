public enum ScoreLine {

    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    THREEOAK(7),
    FOUROAK(8),
    SMALLSTR(9),
    LARGESTR(10),
    FH(11),
    YAHTZEE(12),
    CHANCE(13);

    private final int value;

    ScoreLine(int value){
        this.value = value;
    }

    public int getScoreLineValue(){
        return this.value;
    }

}
