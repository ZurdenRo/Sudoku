package development.game.designPattern.factory;

import development.game.model.Cell;
import development.game.model.Cuadricula;

public class GridTwo implements IGrid{

    private Cuadricula c ;

    public Cuadricula getMakeGrid(){
        return c;
    }

    public void setMakeGrid(Cuadricula c){
        this.c = c;
    }

    public GridTwo(){}


    @Override
    public void buildGrid(){
        this.setMakeGrid(new Cuadricula());
        this.getMakeGrid().setSubGrid(new Cuadricula.SubGrid[2][2]);
        int totalMatrixCell = 2 * 2;
        for(int i = 0; i < totalMatrixCell ; i++) {
            Cell[][] cellsOne = new Cell[2][2];
            Cell.createMatrix(cellsOne);
            c.setCellsOnGrid(cellsOne, i + 1);
        }
        c.organizeMatrix();
    }
}
