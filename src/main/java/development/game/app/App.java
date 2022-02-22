package development.game.app;


import development.game.designPattern.factory.GridFactory;
import development.game.designPattern.factory.IGrid;

import java.io.IOException;


public class App{

    public static void main(String[] args) throws IOException{

        IGrid g = GridFactory.createGridTwo();

    }


}