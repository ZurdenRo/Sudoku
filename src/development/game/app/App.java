package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;
import development.game.model.Position;

import java.io.*;
import java.nio.file.Files;
import java.util.List;


public class App{
    public static void upFile(Cell[][] cOne, Cell[][] cTwo,Cell[][] cThree, Cell[][] cFour) throws IOException{
        List<String> ls = Files.readAllLines(new File("src/development/resources/sarasa.csv").toPath());
        int i = 1;
        boolean canBreak = false;
        for(String rec : ls){
            if(i < 5){
                for(int j = 0; j < cOne.length; j++) {
                    for(int k = 0; k < cOne[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cOne[j][k] == null){
                            cOne[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), new Position(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 9){
                for(int j = 0; j < cTwo.length; j++) {
                    for(int k = 0; k < cTwo[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cTwo[j][k] == null){
                            cTwo[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), new Position(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 13){
                for(int j = 0; j < cThree.length; j++) {
                    for(int k = 0; k < cThree[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cThree[j][k] == null){
                            cThree[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), new Position(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 17){
                for(int j = 0; j < cFour.length; j++) {
                    for(int k = 0; k < cFour[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cFour[j][k] == null){
                            cFour[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), new Position(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }
            i++;
            canBreak = false;
        }
    }
    public static void main(String[] args) throws IOException{

        Cell[][] cellsOne = new Cell[2][2];
        Cell[][] cellsTwo = new Cell[2][2];
        Cell[][] cellsThree = new Cell[2][2];
        Cell[][] cellsFour = new Cell[2][2];
        Cuadricula c = new Cuadricula();;

        App.upFile(cellsOne, cellsTwo, cellsThree, cellsFour);

      /*c.createMatrixNumber(cellsOne);
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
        c.printMatrix(cellsFour);*/

        c.setGrid(new Cuadricula[2][2]);
        c.setCellsOnGrid(cellsOne, cellsTwo, cellsThree, cellsFour);
        c.printGridTwoRowTwoCol();
        c.walkGridOnRow();

    }

}