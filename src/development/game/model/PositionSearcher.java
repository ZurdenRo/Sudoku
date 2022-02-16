package development.game.model;

public class PositionSearcher implements IPosition{

    private String grid;
    private Position positionSearcher;
    private Movements movements;
    private int row;
    private int column;

    public PositionSearcher(String indicatorGrid, int row, int column, Movements movements){
        setGrid(indicatorGrid);
        setRow(row);
        setColumn(column);
        setMovements(movements);
    }

    public String getGrid(){
        return grid;
    }

    public void setGrid(String grid){
        this.grid = grid;
    }

    public Position getPositionSearcher(){
        return positionSearcher;
    }

    public void setPositionSearcher(Position positionSearcher){
        this.positionSearcher = positionSearcher;
    }

    public Movements getMovements(){
        return movements;
    }

    public void setMovements(Movements movements){
        this.movements = movements;
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
    public String toString() {
        return "PositionSearcher{" +
                "grid='" + grid + '\'' +
                ", p=" + positionSearcher +
                ", movements=" + movements +
                '}';
    }
}
