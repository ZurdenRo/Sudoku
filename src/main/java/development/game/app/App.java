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


        //GetUpFile.upFile(cellsOne, cellsTwo, cellsThree, cellsFour,cellsFive,cellsSix, cellsSeven, cellsEight, cellsNine);
        Cell.createMatrix(cellsOne);
        Cell.printMatrix(cellsOne);

        Cell.createMatrix(cellsTwo);
        Cell.printMatrix(cellsTwo);

        Cell.createMatrix(cellsThree);
        Cell.printMatrix(cellsThree);

        Cell.createMatrix(cellsFour);
        Cell.printMatrix(cellsFour);

        Cell.createMatrix(cellsFive);
        Cell.printMatrix(cellsFive);

        Cell.createMatrix(cellsSix);
        Cell.printMatrix(cellsSix);

        Cell.createMatrix(cellsSeven);
        Cell.printMatrix(cellsSeven);

        Cell.createMatrix(cellsEight);
        Cell.printMatrix(cellsEight);

        Cell.createMatrix(cellsNine);
        Cell.printMatrix(cellsNine);

        Cuadricula c = new Cuadricula();
        c.setGrid(new Cuadricula.SubGrid[3][3]);
        c.setCellsOnGrid(cellsOne, cellsTwo, cellsThree, cellsFour, cellsFive, cellsSix, cellsSeven, cellsEight, cellsNine);
        c.printGridTwoRowTwoCol();
        c.walkGridOnRow();


    }


}