package development.game.model;

public class Position{

    private int row;
    private int column;
    private String idGrid;
    private Cell cell;

    public Position(int row, int column){
        setRow(row);
        setColumn(column);
    }

    public Position(String idGrid, Cell c){
        setIdGrid(idGrid);
        setCell(c);
    }

    public String getIdGrid() {
        return idGrid;
    }

    public void setIdGrid(String idGrid) {
        this.idGrid = idGrid;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
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
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                ", idGrid='" + idGrid + '\'' +
                ", cell=" + cell +
                '}';
    }
}