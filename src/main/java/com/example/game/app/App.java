package com.example.game.app;


import com.example.game.designPattern.factory.GridFactory;

import java.io.IOException;


public class App{

    public static void main(String[] args) throws IOException{

        GridFactory.createGridThree();
    }


}