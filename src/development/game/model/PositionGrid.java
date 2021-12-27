package development.game.model;

public class PositionGrid{

    private Cell cell;
    private String idGrid;
    private Position positionGrid;

    public PositionGrid(String idGrid, Cell cell, Position positionGrid){
        setIdGrid(idGrid);
        setCell(cell);
        setPositionGrid(positionGrid);
    }

    public Position getPositionGrid(){
        return positionGrid;
    }

    public void setPositionGrid(Position positionGrid){
        this.positionGrid = positionGrid;
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell = cell;
    }

    public String getIdGrid(){
        return idGrid;
    }

    public void setIdGrid(String idGrid){
        this.idGrid = idGrid;
    }

    @Override
    public String toString(){
        return "PositionGrid{" +
                "idGrid='" + idGrid + '\'' +
                "cell=" + cell +
                ", positionGrid=" + positionGrid +
                '}';
    }

}
