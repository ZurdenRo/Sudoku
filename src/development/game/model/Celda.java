package development.game.model;

public class Celda {


    private int number;
    private boolean isRepeat;
    private Position position;
    private boolean numberAbsent;

    public Celda(int number, boolean isRepeat, Position p){
        setNumber(number);
        setRepeat(isRepeat);
        setPosition(p);
    }

    public Celda(int number, boolean numberAbsent){
        setNumber(number);
        setNumberAbsent(numberAbsent);
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isNumberAbsent() {
        return numberAbsent;
    }

    public void setNumberAbsent(boolean numberAbsent) {
        this.numberAbsent = numberAbsent;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "{" +
                "number=" + number +
                ", isRepeat=" + isRepeat +
                ", position=" + position +
                ", numberAbsent=" + numberAbsent +
                '}';
    }

	
}