package development.game.model;


import java.util.*;
import java.util.stream.Collectors;

public class Cuadricula{

    private static final Cell[] numberAvailable = new Cell[4];
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
    }

    public static void fillNumbersAvailable(){
        for(int i = 0; i < numberAvailable.length; i++) {
            numberAvailable[i] = new Cell(i + 1, true);
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
                    if(!(c.getPosition().equalsPosition(cell[i][j].getPosition()))) {
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
        numbersMissing = new ArrayList<>();
        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                searchArrNumberEnable(cell[i][j]);
            }

        }
        changerNumberRepetitiveForMissing();
        selectNumberMissing(cell);
    }

    public void searchArrNumberEnable(Cell c){
        for(int i = 0; i < numberAvailable.length; i++) {
            if(numberAvailable[i].getNumber() == c.getNumber()) {
                numberAvailable[i].setNumberAbsent(false);
            }
        }
    }

    public void changerNumberRepetitiveForMissing(){
        for(int i = 0; i < numberAvailable.length; i++) {
            if(numberAvailable[i].isNumberAbsent()) {
                numbersMissing.add(numberAvailable[i].getNumber());
            }
        }
    }

    public void selectNumberMissing(Cell[][] cell){
        Random r = new Random();

        for(int i = 0; i < cell.length; i++) {
            for(int j = 0; j < cell[i].length; j++) {
                if(cell[i][j].isRepeat()) {
                    int n = r.nextInt(numbersMissing.size());

                    cell[i][j].setNumber(numbersMissing.get(n));
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

                for(int j = 0; j < this.getGrid()[i].length; j++) {
                    if(this.getGrid()[i][j] == null){
                        isBreak = true;
                        count++;
                        this.getGrid()[i][j] = new Cuadricula(rec, "IDGrid: " + count);
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
                    }
                }
                if(i == 0 && j == 1){
                    rowFinal = rowOnes.concat(splitLines).concat(rowTwo);
                    rowOnes = "";
                    rowTwo = "";
                }
                else if(i == 1 && j == 1){
                    rowFinal = rowFinal.concat(splitLines).concat(rowOnes).concat(splitLines).concat(rowTwo);
                }
            }

        }
        System.out.println("-------------");
        System.out.println(rowFinal);
        System.out.println("-------------");
    }

    public PositionGrid getPositionNotChecked()
    {
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
                        finallyUltimateSolution(p);
                        printGridTwoRowTwoCol();
                    }
                }

            }
        }
        

    }

    public void finallyUltimateSolution(PositionGrid positionAnalyzed){
        int rowGrid = positionAnalyzed.getPositionGrid().getRow();
        int colGrid = positionAnalyzed.getPositionGrid().getColumn();
        Cuadricula c = this.getGrid()[rowGrid][colGrid];

        fillNumbersAvailable();
        List<Cell> lsNumberAvailable = Arrays.asList(Cuadricula.numberAvailable);
        ArrayList<PositionGrid> lsNumbersIHave = new ArrayList<>();
        ArrayList<PositionGrid> lsNumbersRepetitive = new ArrayList<>();
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
                        lsNumbersRepetitive.add(posTmp);
                    }
                }
            }
        }
        //Genero una lista que me dice que numeros me faltan de toda mi fila!
        List<Cell> lsNumberAbsent = lsNumberAvailable.stream().filter(e -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( z -> z != e.getNumber())).collect(Collectors.toList());

        if(lsNumberAbsent.size() != 0 ){
            for(PositionGrid rec: lsNumbersRepetitive){
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



        lsNumbersRepetitive.clear();
        ArrayList<PositionSearcher> waysToSearchUpDown = whereFindNumberGridUpDown(positionAnalyzed);
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
                        lsNumbersRepetitive.add(posTmp);
                    }
                }
            }
        }

        lsNumberAbsent = lsNumberAvailable.stream().filter(e -> lsNumbersIHave.stream().map(PositionGrid::getCell).map(Cell::getNumber).allMatch( z -> z != e.getNumber())).collect(Collectors.toList());

        if(lsNumberAbsent.size() != 0 ){
            for(PositionGrid rec: lsNumbersRepetitive){
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
        lsNumbersRepetitive.clear();
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


    public ArrayList<PositionGrid> walkToRowOrColumnAndVerifyIfIsChecked(ArrayList <PositionSearcher> waysList, PositionGrid pg){
        ArrayList<PositionGrid> lsPositionRepeatChecked = new ArrayList<>();

        for (PositionSearcher rec : waysList){
            if(rec.getMovements().name().contentEquals(Movements.UP.name()) ){
                Cuadricula gridToSearch = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                for (int i = 0; i < gridToSearch.getCellsMatrix().length; i++) {
                    System.out.println(gridToSearch.getCellsMatrix()[i][pg.getCell().getPosition().getColumn()].getNumber());
                    if(pg.getCell().getNumber() == gridToSearch.getCellsMatrix()[i][pg.getCell().getPosition().getColumn()].getNumber()){
                        if(gridToSearch.getCellsMatrix()[i][pg.getCell().getPosition().getColumn()].isChecked()){
                            Cell c = gridToSearch.getCellsMatrix()[i][pg.getCell().getPosition().getColumn()];
                            lsPositionRepeatChecked.add(new PositionGrid(rec.getGrid(), c, rec.getPositionSearcher()));
                        }
                    }
                }
            }else if(rec.getMovements().name().contentEquals(Movements.LEFT.name()) ){
                Cuadricula gridToSearch = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                for (int i = 0; i < gridToSearch.getCellsMatrix().length; i++) {
                            if(gridToSearch.getCellsMatrix()[pg.getCell().getPosition().getRow()][i].getNumber() == pg.getCell().getNumber()){
                                if(gridToSearch.getCellsMatrix()[pg.getCell().getPosition().getRow()][i].isChecked()){
                                    Cell c = gridToSearch.getCellsMatrix()[pg.getCell().getPosition().getRow()][i];
                                    lsPositionRepeatChecked.add(new PositionGrid(rec.getGrid(), c, rec.getPositionSearcher()));
                                }
                            }
                }
            }

        }
        return lsPositionRepeatChecked;
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