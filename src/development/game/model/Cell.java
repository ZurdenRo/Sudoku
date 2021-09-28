package development.game.model;

public class Cell{

	private int number;
    private boolean isRepeat;
    private int position;
    private boolean numberAbsent;

    public Cell(int number, boolean isRepeat, int position){
        setNumber(number);
        setRepeat(isRepeat);
        setPosition(position);
    }

    public Cell(int number, boolean numberAbsent){
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String toString(){
        return String.valueOf(this.getNumber());
    }

    public boolean isNumberAbsent() {
        return numberAbsent;
    }

    public void setNumberAbsent(boolean numberAbsent) {
        this.numberAbsent = numberAbsent;
    }

}