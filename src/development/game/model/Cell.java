package development.game.model;

import development.game.model.interfaces.IPosition;

import java.util.ArrayList;
import java.util.Random;

public class Cell implements IPosition{

    private int number;
    private int row;
    private int column;
    private boolean isRepeat;
    private boolean numberAbsent;
    private static ArrayList<Cell> numbersAvailable;
    private static ArrayList<Integer> numbersMissing;

    public Cell(int number, boolean isRepeat,int row, int column){
        setNumber(number);
        setRepeat(isRepeat);
        setRow(row);
        setColumn(column);
    }

    public Cell(int number, boolean numberAbsent){
        setNumber(number);
        setNumberAbsent(numberAbsent);
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isNumberAbsent() {
        return numberAbsent;
    }

    public void setNumberAbsent(boolean numberAbsent) {
        this.numberAbsent = numberAbsent;
    }

    @Override
    public int getRow(){
        return this.row;
    }

    @Override
    public void setRow(int row){
        this.row = row;
    }

    @Override
    public int getColumn(){
        return this.column;
    }

    @Override
    public void setColumn(int column){
        this.column = column;
    }

    @Override
    public boolean equalsPosition(IPosition otherPos){
        if(otherPos == null) return false;
        if(this.getColumn() != otherPos.getColumn() && this.getRow() != otherPos.getRow()) return false;
        if(this.getColumn() != otherPos.getColumn() || this.getRow() != otherPos.getRow()) return false;
        return this.getColumn() == otherPos.getColumn() && this.getRow() == otherPos.getRow();
    }

    public static int generateNumberRandom(int maxRandom){
        Random number = new Random();
        int n = number.nextInt(maxRandom);
        return n += 1;
    }

    public static void fillCellInMatrix(Cell[][] cell){
        int maxNumberRandom = cell.length * cell.length;
        for(int i = 0; i < cell.length; i++) {
            for(int c = 0; c < cell[i].length; c++) {
                cell[i][c] = new Cell(generateNumberRandom(maxNumberRandom), false, i, c);
            }
        }
        fillNumbersAvailable(cell);
    }

    public static void fillNumbersAvailable(Cell [][] c){
        if(Cell.numbersAvailable == null) Cell.numbersAvailable = new ArrayList<>();
        int maxRow = c.length;
        int maxCell = maxRow * maxRow;
        if(numbersAvailable.isEmpty()){
            for(int i = 0; i < maxCell; i++) {
                Cell.numbersAvailable.add(new Cell(i + 1, true));
            }
        }else if(numbersAvailable.size() != maxCell){
            numbersAvailable.clear();
            for(int i = 0; i < maxCell; i++) {
                Cell.numbersAvailable.add(new Cell(i + 1, true));
            }
        }else{
            for(Cell rec: numbersAvailable){
                rec.setNumberAbsent(true);
            }
        }

    }

    public static void setRepeatedInMatrix(Cell[][] matrixCell){
        for(Cell[] cells : matrixCell) {
            for(Cell value : cells) {
                cellToCheck(value, matrixCell);
            }
        }
    }

    public static void cellToCheck(Cell c, Cell[][] matrizCell){
        for(Cell[] cells : matrizCell) {
            for(Cell value : cells) {
                if(!(c.isRepeat())) {
                    if(!(c.equalsPosition(value))  &&  c.getNumber() == value.getNumber()) {
                        value.setRepeat(true);
                    }
                }
            }
        }
    }
    public static void sortMatrix(Cell[][] cell){
        numbersMissing = new ArrayList<>();
        for(Cell[] row : cell) {
            for(Cell column : row) {
                checkNumbersAbsentInNumAvailable(column);
            }
        }
        addNumbersAbsentInListMissing();
        changeNumberAbsentInCell(cell);
    }

    public static void checkNumbersAbsentInNumAvailable(Cell c){
        for(Cell cell : numbersAvailable) {
            if(cell.getNumber() == c.getNumber()) {
                cell.setNumberAbsent(false);
            }
        }
    }

    public static void addNumbersAbsentInListMissing(){
        for(Cell cell : numbersAvailable) {
            if(cell.isNumberAbsent()) {
                numbersMissing.add(cell.getNumber());
            }
        }
    }

    public static void changeNumberAbsentInCell(Cell[][] matrixCell){
        Random r = new Random();

        for(Cell[] cell : matrixCell) {
            for(Cell value : cell) {
                if(value.isRepeat()) {
                    int n = r.nextInt(numbersMissing.size());
                    int numAbs = numbersMissing.get(n);
                    value.setNumber(numAbs);
                    value.setRepeat(false);
                    numbersMissing.remove(n);
                }
            }
        }

    }

    public static void printMatrix(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                System.out.print(cell[i][j].getNumber() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Cell{" +
                "number=" + number +
                ", row=" + row +
                ", column=" + column +
                ", isRepeat=" + isRepeat +
                ", numberAbsent=" + numberAbsent +
                '}';
    }

}