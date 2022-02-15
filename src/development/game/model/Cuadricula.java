package development.game.model;


import java.util.*;
import java.util.stream.Collectors;

public class Cuadricula{

    private static ArrayList<Cell> numbersAvailable;
    private static ArrayList<Integer> numbersMissing;
    private Cuadricula[][] grid;
    private Cell[][] cellsMatrix;
    private String indicator;

    public Cuadricula(Cell[][] cellsMatrix, String indicator){
        setCellsMatrix(cellsMatrix);
        setIndicator(indicator);
    }

    public Cuadricula(){

    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public Cuadricula[][] getGrid() {
        return grid;
    }

    public void setGrid(Cuadricula[][] grid) {
        this.grid = grid;
    }

    public Cell[][] getCellsMatrix(){
        return this.cellsMatrix;
    }

    private void setCellsMatrix(Cell[][] cellsMatrix){
        this.cellsMatrix = cellsMatrix;
    }

    public int generateNumberRandom(){
        Random number = new Random();
        int n = number.nextInt(4);
        return n += 1;
    }

    public void createMatrixNumber(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int c = 0; c < cell[i].length; c++) {
                cell[i][c] = new Cell(generateNumberRandom(), false, new Position(i, c), false);
            }
        }
        fillNumbersAvailable(cell);
    }

    public static void fillNumbersAvailable(Cell [][] c){
        Cuadricula.numbersAvailable = new ArrayList<>();
        int maxRow = c.length;
        int maxCell = maxRow * maxRow;
        for(int i = 0; i < maxCell; i++) {
            Cuadricula.numbersAvailable.add(new Cell(i + 1, true));
        }
    }

    public void printMatrix(Cell[][] cell){
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                System.out.print(cell[i][j].getNumber() + " ");
            }
            System.out.println();
        }
    }

    public void removeNumberRepetitive(Cell[][] matrixCell){
        for(Cell[] cells : matrixCell) {
            for(Cell value : cells) {
                cellToCheck(value, matrixCell);
            }
        }
    }

    public void cellToCheck(Cell c, Cell[][] matrizCell){
        for(Cell[] cells : matrizCell) {
            for(Cell value : cells) {
                if(!(c.isRepeat())) {
                    if(!(c.getPosition().equalsPosition(value.getPosition()))) {
                        if(c.getNumber() == value.getNumber()) {
                            value.setRepeat(true);
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
        numbersMissing = new ArrayList<>();
        for(Cell[] row : cell) {
            for(Cell column : row) {
                searchArrNumberEnable(column);
            }

        }
        changerNumberRepetitiveForMissing();
        selectNumberMissing(cell);
    }

    public void searchArrNumberEnable(Cell c){
        for(Cell cell : numbersAvailable) {
            if(cell.getNumber() == c.getNumber()) {
                cell.setNumberAbsent(false);
            }
        }
    }

    public void changerNumberRepetitiveForMissing(){
        for(Cell cell : numbersAvailable) {
            if(cell.isNumberAbsent()) {
                numbersMissing.add(cell.getNumber());
            }
        }
    }

    public void selectNumberMissing(Cell[][] matrixCell){
        Random r = new Random();

        for(Cell[] cell : matrixCell) {
            for(Cell value : cell) {
                if(value.isRepeat()) {
                    int n = r.nextInt(numbersMissing.size());

                    value.setNumber(numbersMissing.get(n));
                    value.setRepeat(false);
                    numbersMissing.remove(n);
                }
            }

        }
    }

    public void setCellsOnGrid(Cell[][] ... cells){
        int count = 0;
        for(Cell[][] rec: cells){
            boolean isBreak = false;
            for(int i = 0; i < this.getGrid().length; i++) {
                for(int j = 0; j < this.getGrid().length; j++) {
                    if(this.getGrid()[i][j] == null){
                        count++;
                        this.getGrid()[i][j] = new Cuadricula(rec, "IDGrid: " + count);
                        isBreak = true;
                        break;
                    }
                }
                if(isBreak){
                    break;
                }
            }

        }
    }

    public void printGridTwoRowTwoCol(){
        String rowOnes = "";
        String rowTwo = "";
        String splitLines = "\n";
        String rowFinal = "";
        String rowThree = "";

        for (int i = 0; i < this.getGrid().length; i++) {
            for (int j = 0; j < this.getGrid()[i].length; j++) {

                for (int k = 0; k < this.getGrid()[i][j].getCellsMatrix().length; k++) {
                    for (int l = 0; l < this.getGrid()[i][j].getCellsMatrix()[k].length; l++) {
                        if(k == 0){
                            rowOnes = rowOnes + this.getGrid()[i][j].getCellsMatrix()[k][l].getNumber() + " ";
                        }
                        else if (k ==1){
                            rowTwo = rowTwo + this.getGrid()[i][j].getCellsMatrix()[k][l].getNumber() + " ";
                        }
                        else if(k == 2){
                            rowThree = rowThree + this.getGrid()[i][j].getCellsMatrix()[k][l].getNumber() + " ";
                        }
                    }
                }
                if(this.getGrid().length == 2){
                    if(i == 0 && j == 1){
                        rowFinal = rowOnes.concat(splitLines).concat(rowTwo);
                        rowOnes = "";
                        rowTwo = "";
                    }
                    else if(i == 1 && j == 1){
                        rowFinal = rowFinal.concat(splitLines).concat(rowOnes).concat(splitLines).concat(rowTwo);
                    }
                }else if(this.getGrid().length == 3){
                    if(i == 0 && j == 2){
                        rowFinal = rowOnes.concat(splitLines).concat(rowTwo).concat(splitLines).concat(rowThree);
                        rowOnes = "";
                        rowTwo = "";
                        rowThree = "";
                    }
                    else if(i == 1 && j == 2){
                        rowFinal = rowFinal.concat(splitLines).concat(rowOnes).concat(splitLines).concat(rowTwo).concat(splitLines).concat(rowThree);
                        rowOnes = "";
                        rowTwo = "";
                        rowThree = "";
                    }else if(i == 2 && j == 2){
                        rowFinal = rowFinal.concat(splitLines).concat(rowOnes).concat(splitLines).concat(rowTwo).concat(splitLines).concat(rowThree);
                        rowOnes = "";
                        rowTwo = "";
                        rowThree = "";
                    }
                }

            }
        }

        System.out.println("-------------");
        System.out.println(rowFinal);
        System.out.println("-------------");
    }

    public PositionGrid getPositionNotChecked(){
        PositionGrid p = null ;
        boolean getPosition = false;
        for (int i = 0; i < this.getGrid().length; i++) {
            for (int j = 0; j < this.getGrid()[i].length; j++) {

                for (int k = 0; k < this.getGrid()[i][j].getCellsMatrix().length; k++) {
                    for (int l = 0; l < this.getGrid()[i][j].getCellsMatrix()[k].length; l++) {
                        p = new PositionGrid(this.getGrid()[i][j].getIndicator(), this.getGrid()[i][j].getCellsMatrix()[k][l], new Position(i,j));
                        if(!this.getGrid()[i][j].getCellsMatrix()[k][l].isChecked()){
                            p = new PositionGrid(this.getGrid()[i][j].getIndicator(), this.getGrid()[i][j].getCellsMatrix()[k][l], new Position(i,j));
                            getPosition = true;
                            break;
                        }
                    }
                    if(getPosition){
                        break;
                    }
                }
                if(getPosition){
                    break;
                }
            }
            if(getPosition){
                break;
            }
        }
        return  p;
    }

    public void walkGridOnRow(){
        finallyFinallyColumnSolution();
        searchInRowSolutionFinal();
    }

    public void finallyFinallyColumnSolution(){
        int totalRow = this.getGrid().length;
        int totalColumn = this.getGrid()[totalRow - 1].length;
        int columnInGrid = 0;
        ArrayList<PositionGrid> lsHave = new ArrayList<>();
        ArrayList<PositionGrid> lsNumbersAbsent = new ArrayList<>();
        ArrayList<PositionSearcher> lsGrid = new ArrayList<>();
        for(int i = 0; i < totalRow; i++) {
            for(int j = 0; j < totalColumn; j++) {
                lsGrid.add(new PositionSearcher(String.valueOf(columnInGrid),new Position(i,j),null));
                columnInGrid++;
            }
            columnInGrid = 0;
        }

        for (int i = 0; i < totalColumn; i++) {
            int currentlyColumn = i;
            ArrayList<PositionSearcher> lsGridRow = lsGrid.stream().filter(rowActual -> Integer.parseInt(rowActual.getGrid()) == currentlyColumn).collect(Collectors.toCollection(ArrayList::new));

            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                for(PositionSearcher rec: lsGridRow){
                    Cuadricula subGrid = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                    for(int k = 0; k < totalRow; k++) {
                        Cell tmpCell = subGrid.getCellsMatrix()[k][currentColumn];
                        if(lsHave.stream().map(PositionGrid::getCell).noneMatch(numberCell -> numberCell.getNumber() == tmpCell.getNumber())){
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[k][currentColumn], rec.getPositionSearcher());
                            lsHave.add(posTmp);
                        }else{
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[k][currentColumn], rec.getPositionSearcher());
                            posTmp.getCell().setRepeat(true);
                            lsHave.add(posTmp);
                        }
                    }
                }

                for(PositionSearcher rec: lsGridRow){
                    Cuadricula gridTmp = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                    for(int row = 0; row < totalRow; row++) {
                        for(int column = 0; column < totalColumn; column++) {
                            if(column > currentColumn){
                                Cell tmpCell = gridTmp.getCellsMatrix()[row][column];
                                if(lsHave.stream().filter(have -> !have.getCell().isRepeat()).allMatch(notRepeat -> notRepeat.getCell().getNumber() != tmpCell.getNumber())){
                                    lsNumbersAbsent.add(new PositionGrid(gridTmp.getIndicator(),tmpCell , rec.getPositionSearcher()));
                                }
                            }
                        }
                    }
                }
                changeColumn(lsHave, lsNumbersAbsent, totalColumn);
                lsHave.clear();
                lsNumbersAbsent.clear();
            }

        }

    }

    private void changeColumn(ArrayList<PositionGrid> lsHave,ArrayList<PositionGrid> lsAbs, int row){

        while(lsHave.stream().anyMatch( have -> have.getCell().isRepeat())){
            Optional<PositionGrid> posRep = lsHave.stream().filter(have -> have.getCell().isRepeat()).findFirst();
            Cuadricula gridRep = this.getGrid()[posRep.get().getPositionGrid().getRow()][posRep.get().getPositionGrid().getColumn()];
            for (int i = 0; i < row; i++) {
                if(i > posRep.get().getCell().getPosition().getColumn()){
                    Cell repeatedCell = posRep.get().getCell();
                    Cell cellTmp = changePositionInColumn(posRep.get(), lsAbs, lsHave, i);
                    Cell tmpCell = cellTmp == null ? gridRep.getCellsMatrix()[posRep.get().getCell().getPosition().getRow()][i] : cellTmp;
                    lsHave.stream().filter(have -> have.getCell().getPosition().equalsPosition(repeatedCell.getPosition()) && have.getIdGrid().contentEquals(posRep.get().getIdGrid())).forEach(numRep -> numRep.getCell().setRepeat(false));
                    lsHave.stream().filter( have -> have.getCell().getNumber() == tmpCell.getNumber()).forEach( numRep -> numRep.getCell().setRepeat(true));
                    PositionGrid posFrom = new PositionGrid(posRep.get().getIdGrid(), repeatedCell, posRep.get().getPositionGrid());
                    PositionGrid posTo = new PositionGrid(posRep.get().getIdGrid(), tmpCell, posRep.get().getPositionGrid());
                    changePosition(posTo, posFrom);
                    lsAbs.removeIf( abs -> abs.getCell().getNumber() == posTo.getCell().getNumber() && abs.getCell().getPosition().equalsPosition(posTo.getCell().getPosition()));
                    break;
                }
            }
            printGridTwoRowTwoCol();
        }

    }

    private Cell changePositionInColumn(PositionGrid rec, ArrayList<PositionGrid> lsAbs,ArrayList<PositionGrid> lsHave, int column){
        Cuadricula grid = this.getGrid()[rec.getPositionGrid().getRow()][rec.getPositionGrid().getColumn()];
        Cell positionInColumn = null;
        while(positionInColumn == null && column < grid.getCellsMatrix().length){
            for(int i = 0; i < grid.getCellsMatrix().length; i++) {
                Cell cell = grid.getCellsMatrix()[i][column];
                if(lsAbs.stream().anyMatch(abs -> abs.getCell().getNumber() == cell.getNumber()) && lsHave.stream().noneMatch(have -> have.getCell().getNumber() == cell.getNumber())){
                    positionInColumn = cell;
                    break;
                }
            }
            column++;
        }
        return positionInColumn;
    }

    public void searchInRowSolutionFinal(){
        int totalRow = this.getGrid().length;
        int totalColumn = this.getGrid()[totalRow - 1].length;
        int currentRow = 0;
        ArrayList<PositionSearcher> lsGrid = new ArrayList<>();
        for(int i = 0; i < totalRow; i++) {
            for(int j = 0; j < totalColumn; j++) {
                lsGrid.add(new PositionSearcher(String.valueOf(currentRow),new Position(i,j),null));
            }
            currentRow++;
        }

        for(int i = 0; i < totalRow; i++) {
            int currentRowFinal = i;
            ArrayList<PositionSearcher> lsGridRow = lsGrid.stream().filter(rowActual -> Integer.parseInt(rowActual.getGrid()) == currentRowFinal).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<PositionGrid> lsNumberHave = new ArrayList<>();
            ArrayList<PositionGrid> lsNumbersAbsent = new ArrayList<>();
            for(int rowSubGrid = 0; rowSubGrid < totalRow; rowSubGrid++) {

                for(PositionSearcher rec: lsGridRow){
                    Cuadricula grid = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                    for(int k = 0; k < totalRow; k++) {
                        Cell tmpCell = grid.getCellsMatrix()[rowSubGrid][k];
                        PositionGrid posTmp = new PositionGrid( grid.getIndicator(), tmpCell, rec.getPositionSearcher());
                        if (lsNumberHave.stream().map(PositionGrid::getCell).anyMatch(have -> have.getNumber() == tmpCell.getNumber())) {
                            posTmp.getCell().setRepeat(true);
                        }
                        lsNumberHave.add(posTmp);
                    }
                }

                for(PositionSearcher value : lsGridRow){
                    Cuadricula gridTmp = this.getGrid()[value.getPositionSearcher().getRow()][value.getPositionSearcher().getColumn()];
                    for(int l = 0; l < totalRow; l++) {
                        if(l > rowSubGrid ){
                            for(int k = 0; k < totalRow; k++) {
                                Cell cellTmp = gridTmp.getCellsMatrix()[l][k];
                                if(lsNumberHave.stream().allMatch(have -> have.getCell().getNumber() != cellTmp.getNumber())){
                                    lsNumbersAbsent.add(new PositionGrid(gridTmp.getIndicator(), cellTmp, value.getPositionSearcher()));
                                }
                            }
                        }
                    }
                }

                changePossibleNumberNotEqual(lsNumberHave, lsNumbersAbsent, totalRow);
                printGridTwoRowTwoCol();
                cleanList(lsNumberHave, lsNumbersAbsent);
            }

        }

    }

    public void cleanList(ArrayList<PositionGrid> lsTwo, ArrayList<PositionGrid> lsThree) {
        lsTwo.clear();
        lsThree.clear();
    }

    private void changePossibleNumberNotEqual(ArrayList<PositionGrid> lsHave, ArrayList<PositionGrid> lsAbs, int totalRow){

        while(lsHave.stream().anyMatch( have -> have.getCell().isRepeat())){
            Optional<PositionGrid> optPosRep = lsHave.stream().filter(have -> have.getCell().isRepeat()).findFirst();
            if(optPosRep.isPresent()){
                PositionGrid posRep = optPosRep.get();
                Cuadricula gridRep = this.getGrid()[posRep.getPositionGrid().getRow()][posRep.getPositionGrid().getColumn()];
                for(int i = 0; i < totalRow; i++) {
                    if(i > optPosRep.get().getCell().getPosition().getRow()){
                        Cell repeatedCell = gridRep.getCellsMatrix()[posRep.getCell().getPosition().getRow()][posRep.getCell().getPosition().getColumn()];
                        Cell posAbs = getCellInSameColumnRepeated(posRep, lsAbs, lsHave, i);
                        Cell tmpCell = posAbs == null ? gridRep.getCellsMatrix()[i][posRep.getCell().getPosition().getColumn()] : posAbs;
                        lsHave.stream().filter( have -> have.getCell().getNumber() == tmpCell.getNumber()).forEach( numRep -> numRep.getCell().setRepeat(true));
                        PositionGrid posFrom = new PositionGrid(posRep.getIdGrid(), repeatedCell, optPosRep.get().getPositionGrid());
                        PositionGrid posTo = new PositionGrid(posRep.getIdGrid(), tmpCell, optPosRep.get().getPositionGrid());
                        repeatedCell.setRepeat(false);
                        changePosition(posTo, posFrom);
                        lsAbs.removeIf(abs -> abs.getCell().getNumber() == tmpCell.getNumber() );
                        break;
                    }
                }
            }
        }
    }

    private Cell getCellInSameColumnRepeated(PositionGrid pos, ArrayList<PositionGrid> lsAbs, ArrayList<PositionGrid> lsHave, int sameRow){
        Cuadricula gridRep = this.getGrid()[pos.getPositionGrid().getRow()][pos.getPositionGrid().getColumn()];
        Cell positionInColumn = null;
        for (int i = 0; i < gridRep.getCellsMatrix().length; i++) {

        }
        while (sameRow < gridRep.getCellsMatrix().length && positionInColumn == null){
            Cell tmp = gridRep.getCellsMatrix()[sameRow][pos.getCell().getPosition().getColumn()];
            if(lsAbs.stream().anyMatch(abs -> abs.getCell().getNumber()  == tmp.getNumber()) && lsHave.stream().noneMatch( have -> have.getCell().getNumber() == tmp.getNumber())){
                positionInColumn = tmp;
            }
            sameRow++;
        }

        return positionInColumn;
    }

    private boolean isPresentEqualGridAndColumn(PositionGrid pos, ArrayList<PositionGrid> lsAbs){
        boolean isPresent  = false;
        for (PositionGrid r : lsAbs) {
            if (pos.getCell().getPosition().getColumn() == r.getCell().getPosition().getColumn() && pos.getIdGrid().contentEquals(r.getIdGrid())) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    private void removeLastPositionInLsRepeated(PositionGrid pos, ArrayList<PositionGrid> ls){
        ls.removeIf(r -> pos.getCell().getPosition().equalsPosition(r.getCell().getPosition()) && pos.getIdGrid().contentEquals(r.getIdGrid()));
        long countNumber = ls.stream().filter( repeat -> repeat.getCell().getNumber() == pos.getCell().getNumber()).count();
        if(countNumber == 1){
            ls.removeIf( rep -> rep.getCell().getNumber() == pos.getCell().getNumber());
        }
    }

    private void ifNotExistPairAddToListRepetitive(PositionGrid posRepeated, ArrayList<PositionGrid> lsNumberRepetitive){
         if(lsNumberRepetitive.stream().noneMatch(lsRepeated -> lsRepeated.getPositionGrid().equalsPosition(posRepeated.getPositionGrid()) && lsRepeated.getCell().getNumber() == posRepeated.getCell().getNumber())){
            lsNumberRepetitive.add(posRepeated);
        }
    }

    private ArrayList<Integer> findNumberAbsentInLsThatHaveNumber(ArrayList<PositionGrid> lsNumberHave){
        ArrayList<Integer> numbersAbsent = new ArrayList<>();
        for(Cell cell : numbersAvailable) {
            for(int l = 0; l < lsNumberHave.size(); l++) {
                if(lsNumberHave.get(l).getCell().getNumber() == cell.getNumber()) {
                    break;
                }
                if( l == lsNumberHave.size() - 1 ) {
                    numbersAbsent.add(cell.getNumber());
                }
            }
        }
        return numbersAbsent;
    }

    public void finallyUltimateSolution(PositionGrid positionAnalyzed){
        int rowGrid = positionAnalyzed.getPositionGrid().getRow();
        int colGrid = positionAnalyzed.getPositionGrid().getColumn();
        Cuadricula c = this.getGrid()[rowGrid][colGrid];

        Cell [][] rowCell = new Cell[3][3];
        Cuadricula.fillNumbersAvailable(rowCell);
        ArrayList<PositionGrid> lsNumbersIHave = new ArrayList<>();
        ArrayList<PositionGrid> lsNumberRepeated = new ArrayList<>();
        lsNumbersIHave.add(positionAnalyzed);

        int limitRow = this.getGrid().length;
        int maxColumn = this.getGrid()[limitRow - 1].length;

        for (int i = 0; i < limitRow; i++) {
            if(positionAnalyzed.getCell().getPosition().getColumn() != i ){
                PositionGrid posTmp = new PositionGrid(c.getIndicator(),  c.getCellsMatrix()[positionAnalyzed.getCell().getPosition().getRow()][i], positionAnalyzed.getPositionGrid());
                lsNumbersIHave.add(posTmp);
            }
        }

        ArrayList<PositionSearcher> waysToSearch = getWaysToSearch(positionAnalyzed);

        for(PositionSearcher rec: waysToSearch){
            if(rec.getMovements().name().contentEquals(Movements.RIGHT.name()) || rec.getMovements().name().contentEquals(Movements.LEFT.name())){
                for(int i = 0; i < limitRow; i++) {
                    Cuadricula cTmp = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                    int numberCheck = cTmp.getCellsMatrix()[positionAnalyzed.getCell().getPosition().getRow()][i].getNumber();
                    if(lsNumbersIHave.stream().noneMatch(numberHave -> numberHave.getCell().getNumber() == numberCheck )){
                        PositionGrid posTmp = new PositionGrid(cTmp.getIndicator(), cTmp.getCellsMatrix()[positionAnalyzed.getCell().getPosition().getRow()][i], rec.getPositionSearcher());
                        lsNumbersIHave.add(posTmp);
                    }else{
                        PositionGrid posTmp = new PositionGrid(cTmp.getIndicator(), cTmp.getCellsMatrix()[positionAnalyzed.getCell().getPosition().getRow()][i], rec.getPositionSearcher());
                        lsNumberRepeated.add(posTmp);
                    }
                }
            }
        }
        //Generate a list, He tell me, what number is absent
        ArrayList<Cell> lsNumberAbsent = Cuadricula.numbersAvailable.stream().filter(e -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( z -> z != e.getNumber())).collect(Collectors.toCollection(ArrayList::new));

        if(lsNumberAbsent.size() != 0 ){
            for(PositionGrid rec: lsNumberRepeated){
                for(int i = 0; i < limitRow; i++) {
                    for(int j = 0; j < maxColumn; j++) {
                        Cuadricula cTmp = this.getGrid()[rec.getPositionGrid().getRow()][rec.getPositionGrid().getColumn()];
                        Cell cell =  cTmp.getCellsMatrix()[i][j];
                        int numberToCheck = cell.getNumber();
                        if(lsNumberAbsent.stream().map(Cell::getNumber).anyMatch( number -> number == numberToCheck)){
                            PositionGrid tmp = new PositionGrid(cTmp.getIndicator(), cell, rec.getPositionGrid());
                            changePosition(rec, tmp);
                            lsNumberAbsent.removeIf(numberAbsent -> numberAbsent.getNumber() == numberToCheck);
                        }
                    }
                }
            }
        }

        lsNumberRepeated.clear();
        lsNumbersIHave.clear();
        lsNumbersIHave.add(positionAnalyzed);

        for(PositionSearcher rec: waysToSearch){
            if(rec.getMovements().name().contentEquals(Movements.DOWN.name()) || rec.getMovements().name().contentEquals(Movements.UP.name())){
                for (int i = 0; i < limitRow; i++) {
                    if(positionAnalyzed.getCell().getPosition().getRow() != i ){
                        PositionGrid posTmp = new PositionGrid(c.getIndicator(),  c.getCellsMatrix()[i][positionAnalyzed.getCell().getPosition().getColumn()], positionAnalyzed.getPositionGrid());
                        lsNumbersIHave.add(posTmp);
                    }
                }
            }
        }

        for(PositionSearcher rec: waysToSearch){
            if(rec.getMovements().name().contentEquals(Movements.DOWN.name()) || rec.getMovements().name().contentEquals(Movements.UP.name())){
                for(int i = 0; i < limitRow; i++) {
                    Cuadricula gridTmp = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                    Cell cell = gridTmp.getCellsMatrix()[i][positionAnalyzed.getCell().getPosition().getColumn()];
                    if(lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).noneMatch( number -> number == cell.getNumber())){
                        PositionGrid posTmp = new PositionGrid(gridTmp.getIndicator(), cell, rec.getPositionSearcher());
                        lsNumbersIHave.add(posTmp);
                    }else{
                        PositionGrid posTmp = new PositionGrid(gridTmp.getIndicator(), cell, rec.getPositionSearcher());
                        lsNumberRepeated.add(posTmp);
                    }
                }
            }
        }

        lsNumberAbsent = Cuadricula.numbersAvailable.stream().filter(num -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( numHave -> numHave != num.getNumber())).collect(Collectors.toCollection(ArrayList::new));

        if(lsNumberAbsent.size() != 0 ){
            for(PositionGrid rec: lsNumberRepeated){
                for(int i = 0; i < limitRow; i++) {
                    for(int j = 0; j < maxColumn; j++) {
                        Cuadricula cTmp = this.getGrid()[rec.getPositionGrid().getRow()][rec.getPositionGrid().getColumn()];
                        Cell cell = cTmp.getCellsMatrix()[i][j];
                        int number = cell.getNumber();
                        if(lsNumberAbsent.stream().map(Cell::getNumber).anyMatch( numberAbsent -> numberAbsent == number)){
                            PositionGrid pgFrom = new PositionGrid(cTmp.getIndicator(), cell, rec.getPositionGrid());
                            changePosition(rec,pgFrom);
                            lsNumberAbsent.removeIf(numberAbsent -> numberAbsent.getNumber() == number);
                        }
                    }
                }
            }
        }

        waysToSearch.clear();
        lsNumberRepeated.clear();
        lsNumbersIHave.clear();

        positionAnalyzed.getCell().setChecked(true);
    }



    public ArrayList<PositionSearcher> getWaysToSearch(PositionGrid positionAnalyzed){
        int limitGrid  = this.getGrid().length;
        ArrayList<PositionSearcher> list = new ArrayList<>();

        if(positionAnalyzed.getPositionGrid().getColumn() < limitGrid - 1){
            for(int i = 0; i < limitGrid; i++) {
                if( i != positionAnalyzed.getPositionGrid().getColumn() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[positionAnalyzed.getPositionGrid().getRow()][i].getIndicator(), new Position(positionAnalyzed.getPositionGrid().getRow(), i), Movements.RIGHT);
                    list.add(ps);
                }
            }
        }
        else if(positionAnalyzed.getPositionGrid().getColumn() == limitGrid - 1){
            for(int i = 0; i < limitGrid; i++) {
                if( i != positionAnalyzed.getPositionGrid().getColumn() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[positionAnalyzed.getPositionGrid().getRow()][i].getIndicator(), new Position(positionAnalyzed.getPositionGrid().getRow(), i), Movements.LEFT);
                    list.add(ps);
                }
            }
        }

        if(positionAnalyzed.getPositionGrid().getRow() < limitGrid - 1){
            for(int i = 0; i < limitGrid; i++) {
                if( i != positionAnalyzed.getPositionGrid().getRow() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[i][positionAnalyzed.getPositionGrid().getColumn()].getIndicator(), new Position(i, positionAnalyzed.getPositionGrid().getColumn() ), (Movements.DOWN) );
                    list.add(ps);
                }
            }
        }
        else if(positionAnalyzed.getPositionGrid().getRow() == (limitGrid  - 1) ){
            for(int i = 0; i < limitGrid; i++) {
                if( i != positionAnalyzed.getPositionGrid().getRow() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[i][positionAnalyzed.getPositionGrid().getColumn()].getIndicator(), new Position(i, positionAnalyzed.getPositionGrid().getColumn() ), (Movements.UP) );
                    list.add(ps);
                }
            }
        }

        return list;
    }

    public Movements whereIsMyRepeat(PositionGrid positionSearchRepetitive, PositionGrid positionAnalyzed){
        Movements mov = null;
        if(positionAnalyzed.getPositionGrid().getRow() == positionSearchRepetitive.getPositionGrid().getRow()){
            if(positionAnalyzed.getPositionGrid().getColumn()  < positionSearchRepetitive.getPositionGrid().getColumn() ){
                mov = Movements.LEFT;
            }else if (positionAnalyzed.getPositionGrid().getColumn() > positionSearchRepetitive.getPositionGrid().getColumn()){
                mov = Movements.RIGHT;
            }
        }else if (positionAnalyzed.getPositionGrid().getColumn() == positionSearchRepetitive.getPositionGrid().getColumn()){
                if(positionAnalyzed.getPositionGrid().getRow() < positionSearchRepetitive.getPositionGrid().getRow()){
                    mov = Movements.UP;
                }else if(positionAnalyzed.getPositionGrid().getRow() > positionSearchRepetitive.getPositionGrid().getRow()){
                    mov = Movements.DOWN;
                }
        }
        return mov;
    }

    public void changePosition(PositionGrid positionTo, PositionGrid positionFrom){
        int to = positionTo.getCell().getNumber();
        int from = positionFrom.getCell().getNumber();

        Cell[][] cTo = this.getGrid()[positionTo.getPositionGrid().getRow()][positionTo.getPositionGrid().getColumn()].getCellsMatrix();
        Cell[][] cFrom = this.getGrid()[positionFrom.getPositionGrid().getRow()][positionFrom.getPositionGrid().getColumn()].getCellsMatrix();
        cTo[positionTo.getCell().getPosition().getRow()][positionTo.getCell().getPosition().getColumn()].setNumber(from);
        cFrom[positionFrom.getCell().getPosition().getRow()][positionFrom.getCell().getPosition().getColumn()].setNumber(to);
    }

    @Override
    public String toString() {
        return "Cuadricula{" +
                "grid=" + Arrays.toString(grid) +
                ", c=" + Arrays.toString(cellsMatrix) +
                ", indicator='" + indicator + '\'' +
                '}';
    }

    private class SubGrid{

    }

}