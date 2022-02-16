package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;
import development.game.model.Position;

import java.io.*;
import java.nio.file.Files;
import java.util.List;


public class App{
    public static void upFile(Cell[][] cOne, Cell[][] cTwo,Cell[][] cThree, Cell[][] cFour, Cell[][] fiv, Cell[][] six, Cell[][] sev, Cell[][] eight, Cell[][] nine) throws IOException{
        List<String> ls = Files.readAllLines(new File("src/development/resources/three.csv").toPath());
        int i = 0;
        boolean canBreak = false;
        for(String rec : ls){
            if(i < 9){
                for(int j = 0; j < cOne.length; j++) {
                    for(int k = 0; k < cOne[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cOne[j][k] == null){
                            cOne[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 18){
                for(int j = 0; j < cTwo.length; j++) {
                    for(int k = 0; k < cTwo[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cTwo[j][k] == null){
                            cTwo[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 27){
                for(int j = 0; j < cThree.length; j++) {
                    for(int k = 0; k < cThree[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cThree[j][k] == null){
                            cThree[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 36){
                for(int j = 0; j < cFour.length; j++) {
                    for(int k = 0; k < cFour[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(cFour[j][k] == null){
                            cFour[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 45){
                for(int j = 0; j < fiv.length; j++) {
                    for(int k = 0; k < fiv[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(fiv[j][k] == null){
                            fiv[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 54){
                for(int j = 0; j < six.length; j++) {
                    for(int k = 0; k < six[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(six[j][k] == null){
                            six[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 63){
                for(int j = 0; j < sev.length; j++) {
                    for(int k = 0; k < sev[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(sev[j][k] == null){
                            sev[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 72){
                for(int j = 0; j < eight.length; j++) {
                    for(int k = 0; k < eight[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(eight[j][k] == null){
                            eight[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
                            canBreak = true;
                        }
                        if(canBreak) break;
                    }
                    if(canBreak) break;
                }
            }else if(i < 81){
                for(int j = 0; j < nine.length; j++) {
                    for(int k = 0; k < nine[j].length; k++) {
                        String[] arr = rec.split(",");
                        if(nine[j][k] == null){
                            nine[j][k] = new Cell(Integer.parseInt(arr[0]),Boolean.parseBoolean(arr[1]), Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Boolean.parseBoolean(arr[4]));
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

        //App.upFile(cellsOne, cellsTwo, cellsThree, cellsFour,cellsFive,cellsSix, cellsSeven, cellsEight, cellsNine);

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