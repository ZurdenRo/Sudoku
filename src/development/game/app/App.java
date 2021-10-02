package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;
import development.game.model.Tablero;


public class App{

    public static void main(String[] args){

        Cuadricula c = new Cuadricula();;
        Cell[][] cellsOne = new Cell[3][3];
        c.createMatrixNumber(cellsOne);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsOne);
        c.markTrueNumberRepetitive(cellsOne);
        c.printMatrix(cellsOne);

        Cell[][] cellsTwo = new Cell[3][3];
        c.createMatrixNumber(cellsTwo);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsTwo);
        c.markTrueNumberRepetitive(cellsTwo);
        c.printMatrix(cellsTwo);

        Tablero tablero = new Tablero();
        tablero.setGridOnTable(cellsOne, cellsTwo);
        //t.printGrid();
    }

}