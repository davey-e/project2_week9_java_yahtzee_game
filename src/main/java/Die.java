public class Die {

    private int value;
    private boolean holdStatus;

    public Die(){
        this.value = 0;
        this.holdStatus = false;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getHoldStatus() {
        return this.holdStatus;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setHoldStatus(boolean holdStatus) {
        this.holdStatus = holdStatus;
    }
}
