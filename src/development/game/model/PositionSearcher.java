package development.game.model;

public class PositionSearcher{

    private String grid;
    private Position positionSearcher;
    private Movements movements;

    public PositionSearcher(String indicatorGrid, Position positionSearcher, Movements movements){
        setGrid(indicatorGrid);
        setPositionSearcher(positionSearcher);
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
    public String toString() {
        return "PositionSearcher{" +
                "grid='" + grid + '\'' +
                ", p=" + positionSearcher +
                ", movements=" + movements +
                '}';
    }
}
