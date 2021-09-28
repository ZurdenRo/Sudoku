package development.game.model;

import java.util.ArrayList;
import java.util.Random;

public class Cuadricula{

    public static Cell arr[][] = new Cell[3][3];
    public static Cell[] numerosDisponibles = new Cell[9];
    public static ArrayList<Integer> numerosFaltantes;
    public Tablero t;

    public Cuadricula(){

    }

    public Tablero getT(){
        return t;
    }

    public void setT(Tablero t){
        this.t = t;
    }

    public int generateNumberRandom(){
        Random number = new Random();
        int n = number.nextInt(9);
        return n += 1;
    }

    public void createMatrixNumber(Cell[][] cell){

        for(int i = 0; i < cell.length; i++) {
            for(int c = 0; c < cell[i].length; c++) {
                cell[i][c] = new Cell(generateNumberRandom(), false, new Position(i, c));
            }
        }
    }

    public static void llenarNumerosDisponibles(){
        for(int i = 0; i < numerosDisponibles.length; i++) {
            numerosDisponibles[i] = new Cell(i + 1, true);
        }

    }

    public void printMatrix(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                System.out.println(cell[i][j].getNumber());
            }
        }
    }

    public void removeNumberRepetitive(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            //System.out.println(arr[i]);
            for(int j = 0; j < cell[i].length; j++) {
                cellToCheck(cell[i][j], cell);
            }
        }
    }

    public void cellToCheck(Cell c, Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                if(!(c.isRepeat())) {
                    if(!(c.getPosition().equals(cell[i][j].getPosition()))) {
                        if(c.getNumber() == cell[i][j].getNumber()) {
                            // System.out.println( arr[j].getNumber() + "Repeat");
                            cell[i][j].setRepeat(true);
                        }
                    }
                }
            }
        }
    }

    public void printNumberRepetitive(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                if(cell[i][j].isRepeat()) {
                    System.out.println("Repetido" + cell[i][j].getNumber());
                }
            }

        }
    }

    public void markTrueNumberRepetitive(Cell[][] cell){
        numerosFaltantes = new ArrayList<>();
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                searchArrNumberEnable(cell[i][j]);
            }

        }
        changerNumerosReptidosPorFaltantes();
        seleccionarNumerosFaltantes(cell);
    }

    public void searchArrNumberEnable(Cell c){
        for(int i = 0; i < numerosDisponibles.length; i++) {
            if(numerosDisponibles[i].getNumber() == c.getNumber()) {
                numerosDisponibles[i].setNumberAbsent(false);
            }
        }
    }

    public void changerNumerosReptidosPorFaltantes(){
        for(int i = 0; i < numerosDisponibles.length; i++) {
            if(numerosDisponibles[i].isNumberAbsent()) {
                numerosFaltantes.add(numerosDisponibles[i].getNumber());
            }
        }
    }

    public void seleccionarNumerosFaltantes(Cell[][] cell){
        Random r = new Random();

        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                if(cell[i][j].isRepeat()) {
                    int n = r.nextInt(numerosFaltantes.size());

                    cell[i][j].setNumber(numerosFaltantes.get(n));
                    numerosFaltantes.remove(n);
                }
            }

        }
    }

    public void checkCol(){

    }

    @Override
    public String toString(){
        return super.toString();
    }
}