package development.game.model;

import java.util.Arrays;

public class Tablero {

    private final Cuadricula[][] grid;

    public Tablero(){
        this.grid = new Cuadricula[1][2];
    }

    public Cuadricula[][] getGrid(){
        return this.grid;
    }

    public void printGrid(){
        System.out.println(this.getGrid().length);
        for(int i= 0; i < this.getGrid().length; i ++){

            for(int j = 0; j < this.getGrid()[i].length; j++) {

                System.out.print(i + " " + j + "");
            }
        }
    }

    public void setGridOnTable(Cell[][] ... cells){
        for(Cell[][] rec: cells){
            boolean isBreak = false;
            for(int i = 0; i < this.getGrid().length; i++) {

                for(int j = 0; j < this.getGrid()[i].length; j++) {
                    if(this.getGrid()[i][j] == null){
                        isBreak = true;
                        this.getGrid()[i][j] = new Cuadricula(rec);
                        break;
                    }
                }
                if(isBreak){
                    break;
                }
            }

        }
    }

    @Override
    public String toString(){
        return "Tablero{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }
}
