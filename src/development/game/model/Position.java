package development.game.model;

public class Position{

    private int row;
    private int column;

    public Position(int row, int column){
        setRow(row);
        setColumn(column);
    }

    public int getRow(){
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
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