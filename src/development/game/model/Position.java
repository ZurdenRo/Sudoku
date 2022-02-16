package development.game.model;

public class Position implements  IPosition{

    private int row;
    private int column;

    public Position(int row, int column){
        setRow(row);
        setColumn(column);
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
        return false;
    }


    public boolean equalsPosition(Position obj){
        if(obj == null) return false;
        if(this.getColumn() == obj.getColumn() && this.getRow() == obj.getRow()) return true;
        if(this.getColumn() != obj.getColumn() || this.getRow() != obj.getRow()) return false;
        return this.getColumn() != obj.getColumn() && this.getRow() != obj.getRow();
    }

    @Override
    public String toString(){
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}