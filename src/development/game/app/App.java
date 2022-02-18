package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;

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
        Cell.fillCellInMatrix(cellsOne);
        Cell.setRepeatedInMatrix(cellsOne);
        Cell.sortMatrix(cellsOne);
        Cell.printMatrix(cellsOne);

        Cell.fillCellInMatrix(cellsTwo);
        Cell.setRepeatedInMatrix(cellsTwo);
        Cell.sortMatrix(cellsTwo);
        Cell.printMatrix(cellsTwo);

        Cell.fillCellInMatrix(cellsThree);
        Cell.setRepeatedInMatrix(cellsThree);
        Cell.sortMatrix(cellsThree);
        Cell.printMatrix(cellsThree);

        Cell.fillCellInMatrix(cellsFour);
        Cell.setRepeatedInMatrix(cellsFour);
        Cell.sortMatrix(cellsFour);
        Cell.printMatrix(cellsFour);

        Cell.fillCellInMatrix(cellsFive);
        Cell.setRepeatedInMatrix(cellsFive);
        Cell.sortMatrix(cellsFive);
        Cell.printMatrix(cellsFive);

        Cell.fillCellInMatrix(cellsSix);
        Cell.setRepeatedInMatrix(cellsSix);
        Cell.sortMatrix(cellsSix);
        Cell.printMatrix(cellsSix);

        Cell.fillCellInMatrix(cellsSeven);
        Cell.setRepeatedInMatrix(cellsSeven);
        Cell.sortMatrix(cellsSeven);
        Cell.printMatrix(cellsSeven);

        Cell.fillCellInMatrix(cellsEight);
        Cell.setRepeatedInMatrix(cellsEight);
        Cell.sortMatrix(cellsEight);
        Cell.printMatrix(cellsEight);

        Cell.fillCellInMatrix(cellsNine);
        Cell.setRepeatedInMatrix(cellsNine);
        Cell.sortMatrix(cellsNine);
        Cell.printMatrix(cellsNine);

        c.setGrid(new Cuadricula[3][3]);
        c.setCellsOnGrid(cellsOne, cellsTwo, cellsThree, cellsFour, cellsFive, cellsSix, cellsSeven, cellsEight, cellsNine);
        c.printGridTwoRowTwoCol();
        c.walkGridOnRow();


    }


}