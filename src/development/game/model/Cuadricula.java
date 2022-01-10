package development.game.model;


import java.util.*;

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
                        PositionGrid positionRepeat = null;
                        finallyUltimateSolution(p);
                        //finallyMethodSolution(p);
                      /* int limitRow = this.getGrid().length;
                        int maxColumn = this.getGrid()[limitRow - 1].length;
                        ArrayList<PositionSearcher> list;

                        list = getWaysToSearcherAList( p, limitRow, maxColumn);
                        PositionGrid positionRepetitive = searchNumberRepetitiveAllGrid(list, p);
                        if(positionRepetitive != null ){
                            setNumberOnGridAndSetChecked(positionRepetitive, p);
                        }else{
                            p.getCell().setChecked(true);
                        }
                        */
                        printGridTwoRowTwoCol();
                    }
                }

            }
        }
        

    }

    public PositionGrid searchNumberRepetitiveAllGrid(ArrayList<PositionSearcher> waysList, PositionGrid positionSearchRepetitive){
        PositionGrid ps = null;
        boolean breakForEach = false;

        for(PositionSearcher rec: waysList){
            if(rec.getMovements().getPositionMovements().equals(Movements.RIGHT.getPositionMovements())){
                Cuadricula gridToSearch = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                for(int i = 0; i < gridToSearch.getCellsMatrix().length; i++) {
                    System.out.println(gridToSearch.getCellsMatrix()[positionSearchRepetitive.getCell().getPosition().getRow()][i].getNumber());
                    System.out.println("--");
                    if(gridToSearch.getCellsMatrix()[positionSearchRepetitive.getCell().getPosition().getRow()][i].getNumber() == positionSearchRepetitive.getCell().getNumber() ){
                        ps = new PositionGrid(rec.getGrid(), gridToSearch.getCellsMatrix()[positionSearchRepetitive.getCell().getPosition().getRow()][i], rec.getPositionSearcher());
                        breakForEach = true;
                    }
                    if(breakForEach){ break; }
                }
            }else if(rec.getMovements().getPositionMovements().equals(Movements.DOWN.getPositionMovements())){
                Cuadricula gridToSearch = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()];
                for(int i = 0; i < gridToSearch.getCellsMatrix().length; i++) {
                    System.out.println(gridToSearch.getCellsMatrix()[i][positionSearchRepetitive.getCell().getPosition().getColumn()].getNumber());
                    System.out.println("--");
                    if(gridToSearch.getCellsMatrix()[i][positionSearchRepetitive.getCell().getPosition().getColumn()].getNumber() == positionSearchRepetitive.getCell().getNumber() ){
                        ps = new PositionGrid(rec.getGrid(), gridToSearch.getCellsMatrix()[i][positionSearchRepetitive.getCell().getPosition().getColumn()], rec.getPositionSearcher());
                        breakForEach = true;
                    }
                    if(breakForEach){ break; }
                }
            }
            if(breakForEach){ break; }
        }
        return ps;
    }

    public void finallyUltimateSolution(PositionGrid positionAnalyzed){
        int rowGrid = positionAnalyzed.getPositionGrid().getRow();
        int colGrid = positionAnalyzed.getPositionGrid().getColumn();
        Cuadricula c = this.getGrid()[rowGrid][colGrid];

        fillNumbersAvailable();
        List<Cell> ls = Arrays.asList(Cuadricula.numberAvailable);
        ArrayList<PositionGrid> lsNumberHave = new ArrayList<>();
        lsNumberHave.add(positionAnalyzed);
        int limitRow = this.getGrid().length;
        int maxColumn = this.getGrid()[limitRow - 1].length;

        for (int i = 0; i < limitRow; i++) {
            if(positionAnalyzed.getCell().getPosition().getColumn() != i ){
                PositionGrid posTmp = new PositionGrid(c.getIndicator(),  c.getCellsMatrix()[positionAnalyzed.getCell().getPosition().getRow()][i], positionAnalyzed.getPositionGrid());
                lsNumberHave.add(posTmp);
            }
        }



    }

    public void finallyMethodSolution(PositionGrid positionAnalyzed){
        int rowGrid = positionAnalyzed.getPositionGrid().getRow();
        int colGrid = positionAnalyzed.getPositionGrid().getColumn();
        Cuadricula c = this.getGrid()[rowGrid][colGrid];

        int limitRow = this.getGrid().length;
        int maxColumn = this.getGrid()[limitRow - 1].length;

        ArrayList<PositionSearcher> ls = getWaysToSearcherAList(positionAnalyzed, limitRow, maxColumn);

        boolean isChange = false;

        for (int i = 0; i < limitRow; i++) {
            for (int j = 0; j < maxColumn; j++) {
                while(!c.getCellsMatrix()[i][j].isChecked()){
                    isChange = false;
                    PositionGrid tmpAnalyzed = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[i][j], positionAnalyzed.getPositionGrid());
                    ArrayList<PositionGrid> waysToPositionTrue = walkToRowOrColumnAndVerifyIfIsChecked(ls, tmpAnalyzed);

                    if(waysToPositionTrue.size() == 0 ){
                        c.getCellsMatrix()[i][j].setChecked(true);
                    }else if(waysToPositionTrue.size() == 1){
                        for (PositionGrid rec: waysToPositionTrue){
                            Movements m = whereIsMyRepeat(tmpAnalyzed, rec);
                            if (m.name().contentEquals(Movements.UP.name())) {
                                for (int k = 0; k < rowGrid; k++) {
                                    for (int l = 0; l < maxColumn; l++) {
                                        if (l != rec.getCell().getPosition().getColumn()) {
                                            if (!c.getCellsMatrix()[k][l].isChecked()) {
                                                PositionGrid posToChange = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[k][l], positionAnalyzed.getPositionGrid());
                                                changePosition(posToChange, tmpAnalyzed);
                                                isChange = true;
                                                tmpAnalyzed = posToChange;
                                            }
                                        }
                                        if (isChange) {
                                            break;
                                        }
                                    }
                                    if (isChange) {
                                        break;
                                    }
                                }
                            }else if(m.name().contentEquals(Movements.LEFT.name())){
                                for (int k = 0; k < limitRow; k++) {
                                    if(rec.getCell().getPosition().getRow() !=  k ){
                                        for (int l = 0; l < maxColumn; l++) {
                                            if(!c.getCellsMatrix()[k][l].isChecked()){
                                                PositionGrid posToChange = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[k][l], positionAnalyzed.getPositionGrid() );
                                                changePosition(posToChange, tmpAnalyzed);
                                                isChange = true;
                                                tmpAnalyzed = posToChange;
                                            }
                                            if (isChange) {
                                                break;
                                            }
                                        }
                                        if (isChange) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        tmpAnalyzed.getCell().setChecked(true);
                    }else if(waysToPositionTrue.size() == 2){
                        for (int k = 0; k < waysToPositionTrue.size() - 1; k++) {
                            Movements movOne = whereIsMyRepeat(tmpAnalyzed, waysToPositionTrue.get(k));
                            Movements movTwo = whereIsMyRepeat(tmpAnalyzed, waysToPositionTrue.get(k + 1));
                            if(movOne.name().contentEquals(Movements.UP.name()) && movTwo.name().contentEquals(Movements.LEFT.name())){
                                for (int l = 0; l < limitRow; l++) {
                                    if(l != waysToPositionTrue.get(k).getCell().getPosition().getRow()){
                                        for (int m = 0; m < maxColumn; m++) {
                                            if(m != waysToPositionTrue.get(k + 1).getCell().getPosition().getColumn()){
                                                if(!c.getCellsMatrix()[l][m].isChecked()){
                                                    PositionGrid posToChange = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[l][m], positionAnalyzed.getPositionGrid() );
                                                    changePosition(posToChange, tmpAnalyzed);
                                                    isChange = true;
                                                    tmpAnalyzed = posToChange;
                                                }
                                                if (isChange) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (isChange) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        tmpAnalyzed.getCell().setChecked(true);
                    }
                }
            }
        }
    }

    public void moveMyPositionBecauseIcantMoveThePositionIFound(PositionGrid positionToChangeInGrid){
        int rowGrid = positionToChangeInGrid.getPositionGrid().getRow();
        int colGrid = positionToChangeInGrid.getPositionGrid().getColumn();
        int limitRow = this.getGrid().length;
        int maxColumn = this.getGrid()[limitRow - 1].length;

        ArrayList<PositionSearcher> ls = getWaysToSearcherAList(positionToChangeInGrid, limitRow, maxColumn);
        //changePositionAndForceTrueChecked(positionToChangeInGrid, waysToPositionTrue, ls);
        Cuadricula c = this.getGrid()[rowGrid][colGrid];

        boolean isChange = false;

            for (int i = 0; i < limitRow; i++) {
                for (int j = 0; j < maxColumn; j++) {

                        while(!c.getCellsMatrix()[i][j].isChecked()) {

                            if (!c.getCellsMatrix()[i][j].isChecked()) {
                                isChange = false;
                                PositionGrid tmpAnalyzed = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[i][j], positionToChangeInGrid.getPositionGrid());
                                ArrayList<PositionGrid> waysToPositionTrue = walkToRowOrColumnAndVerifyIfIsChecked(ls, tmpAnalyzed);
                                while (waysToPositionTrue.size() != 0) {

                                    for (PositionGrid rec : waysToPositionTrue) {
                                        if (waysToPositionTrue.size() == 1) {
                                            Movements m = whereIsMyRepeat(tmpAnalyzed, rec);
                                            if (m.name().contentEquals(Movements.UP.name())) {

                                                for (int k = 0; k < limitRow; k++) {
                                                    for (int l = 0; l < maxColumn; l++) {
                                                        if (l != rec.getCell().getPosition().getColumn()) {
                                                            if (!c.getCellsMatrix()[k][l].isChecked()) {
                                                                PositionGrid posToChange = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[k][l], positionToChangeInGrid.getPositionGrid());
                                                                changePosition(posToChange, tmpAnalyzed);
                                                                isChange = true;
                                                                tmpAnalyzed = posToChange;
                                                            }
                                                        }
                                                        if (isChange) {
                                                            break;
                                                        }
                                                    }
                                                    if (isChange) {
                                                        break;
                                                    }
                                                }
                                            }else if( m.name().contentEquals(Movements.LEFT.name()) ){
                                                for (int k = 0; k < limitRow; k++) {
                                                    if(rec.getCell().getPosition().getRow() !=  k ){
                                                        for (int l = 0; l < maxColumn; l++) {
                                                            if(!c.getCellsMatrix()[k][l].isChecked()){
                                                                PositionGrid posToChange = new PositionGrid(c.getIndicator(), c.getCellsMatrix()[k][l], positionToChangeInGrid.getPositionGrid() );
                                                                changePosition(posToChange, tmpAnalyzed);
                                                                isChange = true;
                                                                tmpAnalyzed = posToChange;
                                                            }
                                                            if (isChange) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (isChange) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }else if(waysToPositionTrue.size() == 2){

                                        }
                                    }
                                    waysToPositionTrue = walkToRowOrColumnAndVerifyIfIsChecked(ls, tmpAnalyzed);
                                }

                                tmpAnalyzed.getCell().setChecked(true);

                            }
                        }

                    if(isChange){break;}
                }
                if(isChange){break;}
            }

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

    public void setNumberOnGridAndSetChecked(PositionGrid positionSearchRepetitive, PositionGrid positionAnalyzed){
        System.out.println(positionSearchRepetitive);
        System.out.println(positionAnalyzed);
        boolean isChange = false;
        int limitRow = this.getGrid().length;
        //ArrayList<PositionSearcher> list = getWaysToSearcherAList(positionAnalyzed, limitRow, maxColumn );

        if(positionSearchRepetitive.getCell().isChecked() != true){
            Movements m = whereIsMyRepeat(positionSearchRepetitive, positionAnalyzed);

            if(m.name().contentEquals(Movements.LEFT.name()) || m.name().contentEquals(Movements.RIGHT.name())){
                for (int i = 0; i < this.getGrid().length; i++) {
                    if(i != positionSearchRepetitive.getCell().getPosition().getRow()){
                        for (int j = 0; j < this.getGrid()[i].length; j++) {
                            Cell c = this.getGrid()[positionSearchRepetitive.getPositionGrid().getRow()][positionSearchRepetitive.getPositionGrid().getColumn()].getCellsMatrix()[i][j];
                            PositionGrid posTmp = new PositionGrid(positionSearchRepetitive.getIdGrid(), c, positionSearchRepetitive.getPositionGrid());
                            if(notExistNumberOnRowOrColumn(posTmp, positionSearchRepetitive)){
                                System.out.println("here");
                                changePosition(positionSearchRepetitive, posTmp);
                                isChange = true;
                            }
                            if(isChange){
                                break;
                            }
                        }
                    }
                    if(isChange){
                        break;
                    }
                }
            }else if (m.name().contentEquals(Movements.UP.name()) || m.name().contentEquals(Movements.DOWN.name())){
                for (int i = 0; i < this.getGrid().length; i++) {

                    for (int j = 0; j < this.getGrid()[i].length; j++) {
                        if(j !=  positionSearchRepetitive.getCell().getPosition().getColumn() ){
                            Cell c = this.getGrid()[positionSearchRepetitive.getPositionGrid().getRow()][positionSearchRepetitive.getPositionGrid().getColumn()].getCellsMatrix()[i][j];
                            PositionGrid posTmp = new PositionGrid(positionSearchRepetitive.getIdGrid(), c, positionSearchRepetitive.getPositionGrid());
                            if(notExistNumberOnRowOrColumn(posTmp, positionSearchRepetitive)){
                                System.out.println("here");
                                changePosition(positionSearchRepetitive, posTmp);
                                isChange = true;
                            }
                            if(isChange){
                                break;
                            }
                        }
                    }
                    if(isChange){
                        break;
                    }
                }
            }
        }else{


            moveMyPositionBecauseIcantMoveThePositionIFound(positionAnalyzed);

        }


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



    /*
    * Este metodo verifica 2 posiciones
    * */
    public boolean notExistNumberOnRowOrColumn(PositionGrid positionGrid, PositionGrid positionToCheck) {
        int limitRow = this.getGrid().length;
        int maxColumn = this.getGrid()[limitRow - 1].length;
        boolean notExistNumberOnRowOrColumn = true;
        boolean canBreak = false;
        ArrayList<PositionSearcher> list = getWaysToSearcherAList(positionGrid, limitRow, maxColumn);

        for (PositionSearcher rec : list) {
            Cell[][] cell = this.getGrid()[rec.getPositionSearcher().getRow()][rec.getPositionSearcher().getColumn()].getCellsMatrix();
            if (rec.getMovements().equals(Movements.DOWN) || rec.getMovements().equals(Movements.UP)) {
                for (int i = 0; i < cell.length; i++) {
                    if (cell[i][positionGrid.getCell().getPosition().getColumn()].getNumber() == positionToCheck.getCell().getNumber()) {
                        notExistNumberOnRowOrColumn = false;
                        canBreak = true;
                    }
                    System.out.println(cell[i][positionGrid.getCell().getPosition().getColumn()].getNumber());
                }
                if (canBreak) {
                    break;
                }
            } else if (rec.getMovements().equals(Movements.LEFT) || rec.getMovements().equals(Movements.RIGHT)) {
                for (int i = 0; i < cell.length; i++) {
                    if (cell[positionGrid.getCell().getPosition().getRow()][i].getNumber() == positionToCheck.getCell().getNumber()) {
                        notExistNumberOnRowOrColumn = false;
                        canBreak = true;
                    }
                    System.out.println(cell[positionGrid.getCell().getPosition().getRow()][i].getNumber());
                }
                if (canBreak) {
                    break;
                }
            }
        }
        return notExistNumberOnRowOrColumn;
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


    private class InternPositionGrid{

    }
}