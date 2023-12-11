package bridge.domain.system;

public class Turn {
    private int number = 1;

    public void increaseTurn() {
        number++;
    }

    public int getNumber() {
        return number;
    }
}
