package com.example.game.designPattern.factory;

import com.example.game.model.Cell;
import com.example.game.model.Grid;

public class GridThree implements  IGrid{

    private Grid makeGrid;

    public GridThree(){};

    public Grid getMakeGrid(){
        return makeGrid;
    }

    public void setMakeGrid(Grid makeGrid){
        this.makeGrid = makeGrid;
    }

    @Override
    public void buildGrid(){
       this.setMakeGrid(new Grid());
       this.getMakeGrid().setSubGrid(new Grid.SubGrid[3][3]);
        int totalMatrixCell = 3 * 3;
        for(int i = 0; i < totalMatrixCell ; i++) {
            Cell[][] cellsOne = new Cell[3][3];
            Cell.createMatrix(cellsOne);
            this.getMakeGrid().setCellsOnGrid(cellsOne, i + 1);
        }
        this.getMakeGrid().organizeMatrix();
    }
}
