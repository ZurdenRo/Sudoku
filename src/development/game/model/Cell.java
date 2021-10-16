package development.game.model;

public class Cell{


    private int number;
    private boolean isRepeat;
    private Position position;
    private boolean numberAbsent;
    private boolean isChecked;

    public Cell(int number, boolean isRepeat, Position p, boolean isChecked){
        setNumber(number);
        setRepeat(isRepeat);
        setPosition(p);
        setChecked(isChecked);
    }

    public Cell(int number, boolean numberAbsent){
        setNumber(number);
        setNumberAbsent(numberAbsent);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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
        return "Cell{" +
                "number=" + number +
                ", isRepeat=" + isRepeat +
                ", position=" + position +
                ", numberAbsent=" + numberAbsent +
                ", isChecked=" + isChecked +
                '}';
    }
}