package development.game.designPattern.factory;

import development.game.model.Cell;
import development.game.model.Cuadricula;

public class GridThree implements  IGrid{

    private Cuadricula makeGrid;

    public GridThree(){};

    public Cuadricula getMakeGrid(){
        return makeGrid;
    }

    public void setMakeGrid(Cuadricula makeGrid){
        this.makeGrid = makeGrid;
    }

    @Override
    public void buildGrid(){
       this.setMakeGrid(new Cuadricula());
       this.getMakeGrid().setSubGrid(new Cuadricula.SubGrid[3][3]);
        int totalMatrixCell = 3 * 3;
        for(int i = 0; i < totalMatrixCell ; i++) {
            Cell[][] cellsOne = new Cell[3][3];
            Cell.createMatrix(cellsOne);
            this.getMakeGrid().setCellsOnGrid(cellsOne, i + 1);
        }
        this.getMakeGrid().organizeMatrix();
    }
}
