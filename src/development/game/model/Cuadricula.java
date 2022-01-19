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

        for(int i = 0; i < this.getGrid().length; i++) {
            for(int j = 0; j < this.getGrid()[i].length; j++) {

                for(int k = 0; k < this.getGrid()[i][j].getCellsMatrix().length; k++) {
                    for(int l = 0; l < this.getGrid()[i][j].getCellsMatrix()[k].length; l++) {
                        PositionGrid p = getPositionNotChecked();
                        //finallyUltimateSolution(p);
                        printGridTwoRowTwoCol();
                    }
                }

            }
        }
        searchInRowSolutionFinal();
    }

    public void searchInRowSolutionFinal(){
        int row = this.getGrid().length;
        int column = this.getGrid()[row - 1].length;
        int currentRow = 0;
        ArrayList<PositionSearcher> lsGrid = new ArrayList<>();
        Cell [][] c = new Cell[3][3];
        Cuadricula.fillNumbersAvailable(c);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                lsGrid.add(new PositionSearcher(String.valueOf(currentRow),new Position(i,j),null));
            }
            currentRow++;
        }


        for(int i = 0; i < row; i++) {
            int currentRowFinal = i;
            List<PositionSearcher> lsGridRow = lsGrid.stream().filter(rowActual -> Integer.parseInt(rowActual.getGrid()) == currentRowFinal).collect(Collectors.toList());
            ArrayList<PositionGrid> lsNumberHave = new ArrayList<>();
            ArrayList<PositionGrid> lsNumberRepeated = new ArrayList<>();
            ArrayList<PositionGrid> lsNumbersAbsent = new ArrayList<>();
            for(int j = 0; j < row; j++) {

                for(PositionSearcher r : lsGridRow){
                    Cuadricula subGrid = this.getGrid()[r.getPositionSearcher().getRow()][r.getPositionSearcher().getColumn()];

                    for(int k = 0; k < row; k++) {
                        //System.out.println(subGrid.getCellsMatrix()[j][k].getNumber());
                        int numberToChek = subGrid.getCellsMatrix()[j][k].getNumber();
                        if(lsNumberHave.stream().map(PositionGrid::getCell).noneMatch(numberCell -> numberCell.getNumber() == numberToChek)){
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[j][k], r.getPositionSearcher());
                            lsNumberHave.add(posTmp);
                        }else{
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[j][k], r.getPositionSearcher());
                            lsNumberRepeated.add(posTmp);
                            Optional<PositionGrid> pairRepeated = lsNumberHave.stream().filter(numberHave -> numberHave.getCell().getNumber() == posTmp.getCell().getNumber()).findFirst();
                            pairRepeated.ifPresent( pair -> ifNotExistPairAddToListRepetitive(pair, lsNumberRepeated));
                        }
                    }
                }
                // here keep code
                List<Integer> numberAbsent = Cuadricula.numbersAvailable.stream().map(Cell::getNumber).filter(number -> lsNumberHave.stream().noneMatch(numbersHave -> numbersHave.getCell().getNumber() == number)).collect(Collectors.toList());
                for(int k = 0; k < row; k++) {
                    if( k > j){
                        for(PositionSearcher value : lsGridRow){
                            Cuadricula gridTmp = this.getGrid()[value.getPositionSearcher().getRow()][value.getPositionSearcher().getColumn()];
                            Arrays.stream(gridTmp.getCellsMatrix()[k]).filter( cell -> numberAbsent.stream().anyMatch(absent -> absent == cell.getNumber())).forEach(cell -> lsNumbersAbsent.add(new PositionGrid(gridTmp.getIndicator(), cell, value.getPositionSearcher())));
                        }
                    }
                }

                lsNumberHave.clear();
                lsNumberRepeated.clear();
            }

        }

    }

    private void ifNotExistPairAddToListRepetitive(PositionGrid repeated, ArrayList<PositionGrid> lsNumberRepetitive){
         if(lsNumberRepetitive.stream().noneMatch(lsRepeated -> lsRepeated.getPositionGrid().equalsPosition(repeated.getPositionGrid()) && lsRepeated.getCell().getNumber() == repeated.getCell().getNumber())){
            lsNumberRepetitive.add(repeated);
        }
    }

    public void searchInRow(){

        int row = this.getGrid().length;
        int column = this.getGrid()[row - 1].length;
        int currentRow = 0;
        ArrayList<PositionSearcher> lsGrid = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                lsGrid.add(new PositionSearcher(String.valueOf(currentRow),new Position(i,j),null));
            }
            currentRow++;
        }

        for(int i = 0; i < row; i++) {
            int currentRowFinal = i;

                for(int j = 0; j < row; j++) {
                    ArrayList<Integer> lsNumberIhave = new ArrayList<>();
                    ArrayList<PositionGrid> lsPosRepetitive = new ArrayList<>();
                    List<PositionSearcher> lsGridRow = lsGrid.stream().filter(rowActual -> Integer.parseInt(rowActual.getGrid()) == currentRowFinal).collect(Collectors.toList());
                    for(PositionSearcher rec: lsGridRow){
                        for(int k = 0; k < row; k++) {
                            Cuadricula gridTmp = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                            Cell cellTmp = gridTmp.getCellsMatrix()[j][k];

                            PositionGrid posTmp = new PositionGrid(gridTmp.getIndicator(), cellTmp, rec.getPositionSearcher());
                            if(lsNumberIhave.stream().allMatch(number -> number != cellTmp.getNumber())){
                                lsNumberIhave.add(cellTmp.getNumber());
                            }
                            for(PositionSearcher r: lsGridRow){
                                for(int l = 0; l < row; l++) {
                                    Cuadricula grid = this.getGrid()[r.getPositionSearcher().getRow()][r.getPositionSearcher().getColumn()];
                                    if(!posTmp.getCell().getPosition().equalsPosition(grid.getCellsMatrix()[j][l].getPosition())){
                                        int numberTmp = grid.getCellsMatrix()[j][l].getNumber();
                                        if(lsNumberIhave.stream().allMatch(number -> number != numberTmp)){
                                            lsNumberIhave.add(numberTmp);
                                        }
                                        if(posTmp.getCell().getNumber() == grid.getCellsMatrix()[j][l].getNumber()){
                                            PositionGrid pos = new PositionGrid(grid.getIndicator(),grid.cellsMatrix[j][l], r.getPositionSearcher());
                                            lsPosRepetitive.add(pos);
                                        }

                                    }else{
                                        if(!posTmp.getIdGrid().contentEquals(grid.getIndicator())){
                                            int numberTmp = grid.getCellsMatrix()[j][l].getNumber();
                                            if(lsNumberIhave.stream().allMatch(number -> number != numberTmp)){
                                                lsNumberIhave.add(numberTmp);
                                            }
                                            if(posTmp.getCell().getNumber() == grid.getCellsMatrix()[j][l].getNumber()){
                                                PositionGrid pos = new PositionGrid(grid.getIndicator(),grid.cellsMatrix[j][l], r.getPositionSearcher());
                                                lsPosRepetitive.add(pos);
                                            }
                                        }
                                    }
                                }
                            }
                            if(lsPosRepetitive.stream().findFirst().isPresent()){
                                System.out.println("here");
                                Optional<PositionGrid> obj = lsPosRepetitive.stream().findFirst();
                                PositionGrid pos = obj.get();
                                Cuadricula cTmp = this.getGrid()[pos.getPositionGrid().getRow()][pos.getPositionGrid().getColumn()];
                                for(int l = 0; l < row; l++) {
                                    for(int m = 0; m < column; m++) {
                                        int numberChecking = cTmp.getCellsMatrix()[l][m].getNumber();
                                        if(lsNumberIhave.stream().noneMatch(numberHave -> numberHave == numberChecking)){
                                            PositionGrid from = new PositionGrid(cTmp.getIndicator(), cTmp.getCellsMatrix()[l][m], pos.getPositionGrid());
                                            PositionGrid to = new PositionGrid(cTmp.getIndicator(), cTmp.getCellsMatrix()[pos.getCell().getPosition().getRow()][m], pos.getPositionGrid());
                                            if(lsNumberIhave.stream().allMatch( numberHave -> numberHave != numberChecking) &&  pos.getCell().getNumber() != to.getCell().getNumber()){
                                                lsNumberIhave.removeIf( numberHave -> numberHave == to.getCell().getNumber());

                                            }
                                            lsNumberIhave.add(from.getCell().getNumber());

                                            changePosition(to, from);
                                            printGridTwoRowTwoCol();
                                        }
                                    }
                                }
                                lsPosRepetitive.clear();
                            }
                            // chequear aca los repetidos, moverlos, ver que numeros me faltan
                        }
                    }

                printGridTwoRowTwoCol();
                }


        }

    }

    public void finallyUltimateSolution(PositionGrid positionAnalyzed){
        int rowGrid = positionAnalyzed.getPositionGrid().getRow();
        int colGrid = positionAnalyzed.getPositionGrid().getColumn();
        Cuadricula c = this.getGrid()[rowGrid][colGrid];


        List<Cell> lsNumberAvailable = Cuadricula.numbersAvailable;
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

        ArrayList<PositionSearcher> waysToSearchLeftRight = whereFindNumberGridLeftRight(positionAnalyzed);

        for(PositionSearcher rec: waysToSearchLeftRight){
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
        List<Cell> lsNumberAbsent = lsNumberAvailable.stream().filter(e -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( z -> z != e.getNumber())).collect(Collectors.toList());

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


        ArrayList<PositionSearcher> waysToSearchUpDown = whereFindNumberGridUpDown(positionAnalyzed);
        lsNumberRepeated.clear();
        lsNumbersIHave.clear();
        lsNumbersIHave.add(positionAnalyzed);

        for(PositionSearcher rec: waysToSearchUpDown){
            if(rec.getMovements().name().contentEquals(Movements.DOWN.name()) || rec.getMovements().name().contentEquals(Movements.UP.name())){
                for (int i = 0; i < limitRow; i++) {
                    if(positionAnalyzed.getCell().getPosition().getRow() != i ){

                        PositionGrid posTmp = new PositionGrid(c.getIndicator(),  c.getCellsMatrix()[i][positionAnalyzed.getCell().getPosition().getColumn()], positionAnalyzed.getPositionGrid());
                        lsNumbersIHave.add(posTmp);
                    }
                }
            }
        }

        for(PositionSearcher rec: waysToSearchUpDown){
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

        lsNumberAbsent = lsNumberAvailable.stream().filter(numberAvail -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( numberCell -> numberCell != numberAvail.getNumber())).collect(Collectors.toList());

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


        waysToSearchLeftRight.clear();
        waysToSearchUpDown.clear();
        lsNumberRepeated.clear();
        lsNumbersIHave.clear();

        positionAnalyzed.getCell().setChecked(true);
    }

    public ArrayList<PositionSearcher> whereFindNumberGridLeftRight(PositionGrid positionAnalyzed){
        int limitColumn  = this.getGrid().length;

        ArrayList<PositionSearcher> list = new ArrayList<>();

        /*run column maybe set right or left*/
        if(positionAnalyzed.getPositionGrid().getColumn() < limitColumn - 1){
            for(int i = 0; i < limitColumn; i++) {
                if( i != positionAnalyzed.getPositionGrid().getColumn() ){
                    //searcher.put(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i));
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[positionAnalyzed.getPositionGrid().getRow()][i].getIndicator(), new Position(positionAnalyzed.getPositionGrid().getRow(), i), Movements.RIGHT);
                    list.add(ps);
                }
            }
        }
        else if(positionAnalyzed.getPositionGrid().getColumn() == limitColumn - 1){
            for(int i = 0; i < limitColumn; i++) {
                if( i != positionAnalyzed.getPositionGrid().getColumn() ){
                    //searcher.put(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i));
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[positionAnalyzed.getPositionGrid().getRow()][i].getIndicator(), new Position(positionAnalyzed.getPositionGrid().getRow(), i), Movements.LEFT);
                    list.add(ps);
                }
            }
        }

        return list;
    }

    public ArrayList<PositionSearcher> whereFindNumberGridUpDown(PositionGrid positionAnalyzed){
        int limitRow = this.getGrid().length;
        ArrayList<PositionSearcher> list = new ArrayList<>();

        /*run row maybe set down or up*/
        if(positionAnalyzed.getPositionGrid().getRow() < limitRow - 1){
            for(int i = 0; i < limitRow; i++) {
                if( i != positionAnalyzed.getPositionGrid().getRow() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[i][positionAnalyzed.getPositionGrid().getColumn()].getIndicator(), new Position(i, positionAnalyzed.getPositionGrid().getColumn() ), (Movements.DOWN) );
                    list.add(ps);
                }
            }
        }
        else if(positionAnalyzed.getPositionGrid().getRow() == (limitRow  - 1) ){
            for(int i = 0; i < limitRow; i++) {
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

    public ArrayList<PositionSearcher> getWaysToSearcherAList(PositionGrid p, int limitRow, int maxColumn){
        ArrayList<PositionSearcher> list = new ArrayList<>();

        /*run row maybe set down or up*/
        if(p.getPositionGrid().getRow() < limitRow - 1){
            for(int i = 0; i < limitRow; i++) {
                if( i != p.getPositionGrid().getRow() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[i][p.getPositionGrid().getColumn()].getIndicator(), new Position(i, p.getPositionGrid().getColumn() ), (Movements.DOWN) );
                    list.add(ps);
                }
            }
        }
        else if(p.getPositionGrid().getRow() == (limitRow  - 1) ){
            for(int i = 0; i < limitRow; i++) {
                if( i != p.getPositionGrid().getRow() ){
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[i][p.getPositionGrid().getColumn()].getIndicator(), new Position(i, p.getPositionGrid().getColumn() ), (Movements.UP) );
                    list.add(ps);
                }
            }
        }

        /*run column maybe set right or left*/
        if(p.getPositionGrid().getColumn() < maxColumn - 1){
            for(int i = 0; i < maxColumn; i++) {
                if( i != p.getPositionGrid().getColumn() ){
                    //searcher.put(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i));
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i), Movements.RIGHT);
                    list.add(ps);
                }
            }
        }
        else if(p.getPositionGrid().getColumn() == maxColumn - 1){
            for(int i = 0; i < maxColumn; i++) {
                if( i != p.getPositionGrid().getColumn() ){
                    //searcher.put(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i));
                    PositionSearcher ps = new PositionSearcher(this.getGrid()[p.getPositionGrid().getRow()][i].getIndicator(), new Position(p.getPositionGrid().getRow(), i), Movements.LEFT);
                    list.add(ps);
                }
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return "Cuadricula{" +
                "grid=" + Arrays.toString(grid) +
                ", c=" + Arrays.toString(cellsMatrix) +
                ", indicator='" + indicator + '\'' +
                '}';
    }

}