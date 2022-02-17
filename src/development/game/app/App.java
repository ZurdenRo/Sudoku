package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;
import development.game.utils.GetUpFile;

import java.io.IOException;


public class App{

    public static void main(String[] args) throws IOException{

        Cell[][] cellsOne = new Cell[3][3];
        Cell[][] cellsTwo = new Cell[3][3];
        Cell[][] cellsThree = new Cell[3][3];
        Cell[][] cellsFour = new Cell[3][3];
        Cell[][] cellsFive = new Cell[3][3];
        Cell[][] cellsSix = new Cell[3][3];
        Cell[][] cellsSeven = new Cell[3][3];
        Cell[][] cellsEight = new Cell[3][3];
        Cell[][] cellsNine = new Cell[3][3];
        Cuadricula c = new Cuadricula();

        //GetUpFile.upFile(cellsOne, cellsTwo, cellsThree, cellsFour,cellsFive,cellsSix, cellsSeven, cellsEight, cellsNine);

        c.createMatrixNumber(cellsOne);
        c.removeNumberRepetitive(cellsOne);
        c.markTrueNumberRepetitive(cellsOne);
        c.printMatrix(cellsOne);

        c.createMatrixNumber(cellsTwo);
        c.removeNumberRepetitive(cellsTwo);
        c.markTrueNumberRepetitive(cellsTwo);
        c.printMatrix(cellsTwo);

        c.createMatrixNumber(cellsThree);
        c.removeNumberRepetitive(cellsThree);
        c.markTrueNumberRepetitive(cellsThree);
        c.printMatrix(cellsThree);

        c.createMatrixNumber(cellsFour);
        c.removeNumberRepetitive(cellsFour);
        c.markTrueNumberRepetitive(cellsFour);
        c.printMatrix(cellsFour);

        c.createMatrixNumber(cellsFive);
        c.removeNumberRepetitive(cellsFive);
        c.markTrueNumberRepetitive(cellsFive);
        c.printMatrix(cellsFive);

        c.createMatrixNumber(cellsSix);
        c.removeNumberRepetitive(cellsSix);
        c.markTrueNumberRepetitive(cellsSix);
        c.printMatrix(cellsSix);

        c.createMatrixNumber(cellsSeven);
        c.removeNumberRepetitive(cellsSeven);
        c.markTrueNumberRepetitive(cellsSeven);
        c.printMatrix(cellsSeven);

        c.createMatrixNumber(cellsEight);
        c.removeNumberRepetitive(cellsEight);
        c.markTrueNumberRepetitive(cellsEight);
        c.printMatrix(cellsEight);

        c.createMatrixNumber(cellsNine);
        c.removeNumberRepetitive(cellsNine);
        c.markTrueNumberRepetitive(cellsNine);
        c.printMatrix(cellsNine);

        c.setGrid(new Cuadricula[3][3]);
        c.setCellsOnGrid(cellsOne, cellsTwo, cellsThree, cellsFour, cellsFive, cellsSix, cellsSeven, cellsEight, cellsNine);
        c.printGridTwoRowTwoCol();
        c.walkGridOnRow();


    }


}