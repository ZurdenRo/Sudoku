package development.game.model;

public class PositionSearcher implements IPosition{

    private String grid;
    private int row;
    private int column;

    public PositionSearcher(String indicatorGrid, int row, int column){
        setGrid(indicatorGrid);
        setRow(row);
        setColumn(column);
    }

    public String getGrid(){
        return grid;
    }

    public void setGrid(String grid){
        this.grid = grid;
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

    @Override
    public String toString(){
        return "PositionSearcher{" +
                "grid='" + grid + '\'' +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
