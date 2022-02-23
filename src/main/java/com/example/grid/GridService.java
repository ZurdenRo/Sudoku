package com.example.grid;

import com.example.game.designPattern.factory.GridFactory;
import com.example.game.designPattern.factory.IGrid;
import org.springframework.stereotype.Service;

@Service
public class GridService{


    public IGrid makeGridThree(){
        return GridFactory.createGridThree();
    }

    public IGrid makeGridTwo(){
        return GridFactory.createGridTwo();
    }

}
