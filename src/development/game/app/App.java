package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;


public class App {
	public static void main(String[] args) {

		  	Cuadricula c = new Cuadricula();
	        Cell[] [] cellsOne =  new Cell[3] [3];
	        c.createMatrixNumber(cellsOne);
	        Cuadricula.fillNumbersAvailable();
	        c.removeNumberRepetitive(cellsOne);
	        c.markTrueNumberRepetitive(cellsOne);
	        c.printMatrix(cellsOne);
	}

}