package development.game.model;

import development.game.model.interfaces.IPosition;

public class Cell implements IPosition{

    private int number;
    private int row;
    private int column;
    private boolean isRepeat;
    private boolean numberAbsent;
    private boolean isChecked;

    public Cell(int number, boolean isRepeat,int row, int column, boolean isChecked){
        setNumber(number);
        setRepeat(isRepeat);
        setRow(row);
        setColumn(column);
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

    @Override
    public int getRow(){
        return this.row;
    }

    @Override
    public void setRow(int row){
        this.row = row;
    }

    @Override
    public int getColumn(){
        return this.column;
    }

    @Override
    public void setColumn(int column){
        this.column = column;
    }

    @Override
    public boolean equalsPosition(IPosition otherPos){
        if(otherPos == null) return false;
        if(this.getColumn() != otherPos.getColumn() && this.getRow() != otherPos.getRow()) return false;
        if(this.getColumn() != otherPos.getColumn() || this.getRow() != otherPos.getRow()) return false;
        return this.getColumn() == otherPos.getColumn() && this.getRow() == otherPos.getRow();
    }

    @Override
    public String toString(){
        return "Cell{" +
                "number=" + number +
                ", isRepeat=" + isRepeat +
                ", row=" + row +
                ", column=" + column +
                ", numberAbsent=" + numberAbsent +
                ", isChecked=" + isChecked +
                '}';
    }
}