package development.game.designPattern.factory;

import development.game.model.Cell;
import development.game.model.Cuadricula;

public class GridTwo implements IGrid{

    public Cuadricula getC(){
        return c;
    }

    public void setC(Cuadricula c){
        this.c = c;
    }

    Cuadricula c ;

    public GridTwo(){}

    @Override
    public void buildGrid(){
        this.setC(new Cuadricula());
        this.getC().setGrid(new Cuadricula.SubGrid[2][2]);
        int totalMatrixCell = 2 * 2;
        for(int i = 0; i < totalMatrixCell ; i++) {
            Cell[][] cellsOne = new Cell[2][2];
            Cell.createMatrix(cellsOne);
            c.setCellsOnGrid(cellsOne, i + 1);
        }
        c.walkGridOnRow();
    }
}
