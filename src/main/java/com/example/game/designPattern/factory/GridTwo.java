package com.example.game.designPattern.factory;

import com.example.game.model.Grid;
import com.example.game.model.Cell;

public class GridTwo implements IGrid{

    private Grid grid;

    public Grid getMakeGrid(){
        return grid;
    }

    public void setMakeGrid(Grid c){
        this.grid = c;
    }

    public GridTwo(){}


    @Override
    public void buildGrid(){
        this.setMakeGrid(new Grid());
        this.getMakeGrid().setSubGrid(new Grid.SubGrid[2][2]);
        int totalMatrixCell = 2 * 2;
        for(int i = 0; i < totalMatrixCell ; i++) {
            Cell[][] cellsOne = new Cell[2][2];
            Cell.createMatrix(cellsOne);
            grid.setCellsOnGrid(cellsOne, i + 1);
        }
        grid.organizeMatrix();
    }
}
