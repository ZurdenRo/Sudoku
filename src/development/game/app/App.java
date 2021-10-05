package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;


public class App{

    public static void main(String[] args){

        Cell[][] cellsOne = new Cell[2][2];
        Cell[][] cellsTwo = new Cell[2][2];
        Cell[][] cellsThree = new Cell[2][2];
        Cell[][] cellsFour = new Cell[2][2];
        Cuadricula c = new Cuadricula();;

        c.createMatrixNumber(cellsOne);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsOne);
        c.markTrueNumberRepetitive(cellsOne);
        c.printMatrix(cellsOne);

        c.createMatrixNumber(cellsTwo);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsTwo);
        c.markTrueNumberRepetitive(cellsTwo);
        c.printMatrix(cellsTwo);

        c.createMatrixNumber(cellsThree);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsThree);
        c.markTrueNumberRepetitive(cellsThree);
        c.printMatrix(cellsThree);

        c.createMatrixNumber(cellsFour);
        Cuadricula.fillNumbersAvailable();
        c.removeNumberRepetitive(cellsFour);
        c.markTrueNumberRepetitive(cellsFour);
        c.printMatrix(cellsFour);

        c.setGrid(new Cuadricula[2][2]);
        c.setCellsOnGrid(cellsOne, cellsTwo, cellsThree, cellsFour);
        c.printGridTwoRowTwoCol();
        c.walkGridOnRow();
    }

}