package development.game.model;

public class PositionSearcher{

    private String grid;
    private Position p;


    private Movements movements;

    public PositionSearcher(String indicatorGrid, Position p, Movements movements){
        setGrid(indicatorGrid);
        setP(p);
        setMovements(movements);
    }

    public String getGrid(){
        return grid;
    }

    public void setGrid(String grid){
        this.grid = grid;
    }

    public Position getP(){
        return p;
    }

    public void setP(Position p){
        this.p = p;
    }

    public Movements getMovements(){
        return movements;
    }

    public void setMovements(Movements movements){
        this.movements = movements;
    }

    @Override
    public String toString(){
        return "PositionSearcher{" +
                "grid='" + grid + '\'' +
                ", p=" + p +
                ", movements=" + movements +
                '}';
    }

}
