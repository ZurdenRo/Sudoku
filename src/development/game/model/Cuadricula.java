package development.game.model;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cuadricula{

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

    public void walkGridOnRow(){
        finallyFinallyColumnSolution();
        System.out.println("init row algorithm");
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
                lsGrid.add(new PositionSearcher(String.valueOf(columnInGrid),i,j));
                columnInGrid++;
            }
            columnInGrid = 0;
        }

        for (int i = 0; i < totalColumn; i++) {
            int currentlyColumn = i;
            ArrayList<PositionSearcher> lsGridRow = lsGrid.stream().filter(rowActual -> Integer.parseInt(rowActual.getGrid()) == currentlyColumn).collect(Collectors.toCollection(ArrayList::new));

            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                for(PositionSearcher rec: lsGridRow){
                    Cuadricula subGrid = this.getGrid()[rec.getRow()][rec.getColumn()];
                    for(int k = 0; k < totalRow; k++) {
                        Cell tmpCell = subGrid.getCellsMatrix()[k][currentColumn];
                        if(lsHave.stream().map(PositionGrid::getCell).noneMatch(numberCell -> numberCell.getNumber() == tmpCell.getNumber())){
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[k][currentColumn], rec.getRow(), rec.getColumn());
                            lsHave.add(posTmp);
                        }else{
                            PositionGrid posTmp = new PositionGrid(subGrid.getIndicator(), subGrid.getCellsMatrix()[k][currentColumn], rec.getRow(), rec.getColumn());
                            posTmp.getCell().setRepeat(true);
                            lsHave.add(posTmp);
                        }
                    }
                }

                for(PositionSearcher rec: lsGridRow){
                    Cuadricula gridTmp = this.getGrid()[rec.getRow()][rec.getColumn()];
                    for(int row = 0; row < totalRow; row++) {
                        for(int column = 0; column < totalColumn; column++) {
                            if(column > currentColumn){
                                Cell tmpCell = gridTmp.getCellsMatrix()[row][column];
                                if(lsHave.stream().filter(have -> !have.getCell().isRepeat()).allMatch(notRepeat -> notRepeat.getCell().getNumber() != tmpCell.getNumber())){
                                    lsNumbersAbsent.add(new PositionGrid(gridTmp.getIndicator(),tmpCell , rec.getRow(), rec.getColumn()));
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
            Optional<PositionGrid> optPosRep = lsHave.stream().filter(have -> have.getCell().isRepeat()).findFirst();
            if(optPosRep.isPresent()){
                PositionGrid posRep = optPosRep.get();
                Cuadricula gridRep = this.getGrid()[posRep.getRow()][posRep.getColumn()];
                for (int i = 0; i < row; i++) {
                    if(i > posRep.getCell().getColumn()){
                        Cell repeatedCell = posRep.getCell();
                        Cell cellTmp = getCellOtherColumn(posRep, lsAbs, lsHave, i);
                        Cell tmpCell = cellTmp == null ? gridRep.getCellsMatrix()[posRep.getCell().getRow()][i] : cellTmp;
                        lsHave.stream().filter(have -> have.getCell().equalsPosition(repeatedCell) && have.getIdGrid().contentEquals(posRep.getIdGrid())).forEach(numRep -> numRep.getCell().setRepeat(false));
                        lsHave.stream().filter( have -> have.getCell().getNumber() == tmpCell.getNumber()).forEach( numRep -> numRep.getCell().setRepeat(true));
                        PositionGrid posFrom = new PositionGrid(posRep.getIdGrid(), repeatedCell, posRep.getRow(), posRep.getColumn());
                        PositionGrid posTo = new PositionGrid(posRep.getIdGrid(), tmpCell, posRep.getRow(), posRep.getColumn());
                        changePosition(posTo, posFrom);
                        lsAbs.removeIf( abs -> abs.getCell().getNumber() == posTo.getCell().getNumber() && abs.getCell().equalsPosition(posTo.getCell()));
                        //tmpCell
                        break;
                    }
                }
            }
            printGridTwoRowTwoCol();
        }

    }

    private Cell getCellOtherColumn(PositionGrid rec, ArrayList<PositionGrid> lsAbs, ArrayList<PositionGrid> lsHave, int column){
        Cuadricula grid = this.getGrid()[rec.getRow()][rec.getColumn()];
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
                lsGrid.add(new PositionSearcher(String.valueOf(currentRow),i, j));
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
                    Cuadricula grid = this.getGrid()[rec.getRow()][rec.getColumn()];
                    for(int k = 0; k < totalRow; k++) {
                        Cell tmpCell = grid.getCellsMatrix()[rowSubGrid][k];
                        PositionGrid posTmp = new PositionGrid( grid.getIndicator(), tmpCell, rec.getRow(), rec.getColumn());
                        if (lsNumberHave.stream().map(PositionGrid::getCell).anyMatch(have -> have.getNumber() == tmpCell.getNumber())) {
                            posTmp.getCell().setRepeat(true);
                        }
                        lsNumberHave.add(posTmp);
                    }
                }

                for(PositionSearcher value : lsGridRow){
                    Cuadricula gridTmp = this.getGrid()[value.getRow()][value.getColumn()];
                    for(int l = 0; l < totalRow; l++) {
                        if(l > rowSubGrid ){
                            for(int k = 0; k < totalRow; k++) {
                                Cell cellTmp = gridTmp.getCellsMatrix()[l][k];
                                if(lsNumberHave.stream().allMatch(have -> have.getCell().getNumber() != cellTmp.getNumber())){
                                    lsNumbersAbsent.add(new PositionGrid(gridTmp.getIndicator(), cellTmp, value.getRow(), value.getColumn()));
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
            System.out.println("Has change");
            Optional<PositionGrid> optPosRep = lsHave.stream().filter(have -> have.getCell().isRepeat()).findFirst();
            if(optPosRep.isPresent()){
                PositionGrid posRep = optPosRep.get();
                Cuadricula gridRep = this.getGrid()[posRep.getRow()][posRep.getColumn()];
                for(int i = 0; i < totalRow; i++) {
                    if(i > optPosRep.get().getCell().getRow()){
                        Cell repeatedCell = gridRep.getCellsMatrix()[posRep.getCell().getRow()][posRep.getCell().getColumn()];
                        Cell posAbs = getCellInSameColumnPositionRepeated(posRep, lsAbs, lsHave, i);
                        Cell tmpCell = posAbs == null ? gridRep.getCellsMatrix()[i][posRep.getCell().getColumn()] : posAbs;
                        lsHave.stream().filter( have -> have.getCell().getNumber() == tmpCell.getNumber()).forEach( numRep -> numRep.getCell().setRepeat(true));
                        PositionGrid posFrom = new PositionGrid(posRep.getIdGrid(), repeatedCell, posRep.getRow(), posRep.getColumn());
                        PositionGrid posTo = new PositionGrid(posRep.getIdGrid(), tmpCell, posRep.getRow(), posRep.getColumn());
                        repeatedCell.setRepeat(false);
                        changePosition(posTo, posFrom);
                        lsAbs.removeIf(abs -> abs.getCell().getNumber() == tmpCell.getNumber() );
                        break;
                    }
                }
            }
        }
    }

    private Cell getCellInSameColumnPositionRepeated(PositionGrid pos, ArrayList<PositionGrid> lsAbs, ArrayList<PositionGrid> lsHave, int sameRow){
        Cuadricula gridRep = this.getGrid()[pos.getRow()][pos.getColumn()];
        Cell positionInColumn = null;
        while (sameRow < gridRep.getCellsMatrix().length && positionInColumn == null){
            Cell tmp = gridRep.getCellsMatrix()[sameRow][pos.getCell().getColumn()];
            if(lsAbs.stream().anyMatch(abs -> abs.getCell().getNumber()  == tmp.getNumber()) && lsHave.stream().noneMatch( have -> have.getCell().getNumber() == tmp.getNumber())){
                positionInColumn = tmp;
            }
            sameRow++;
        }

        return positionInColumn;
    }

    public void changePosition(PositionGrid positionTo, PositionGrid positionFrom){
        int to = positionTo.getCell().getNumber();
        int from = positionFrom.getCell().getNumber();

        positionTo.getCell().setNumber(from);
        positionFrom.getCell().setNumber(to);
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