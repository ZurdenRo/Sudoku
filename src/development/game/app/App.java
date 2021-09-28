package development.game.app;


import development.game.model.Cell;
import development.game.model.Cuadricula;


public class App {
	public static void main(String[] args) {

		  Cuadricula c = new Cuadricula();
	        Cell[] [] cells =  new Cell[3] [3];
	        c.createMatrixNumber(cells);
	        Cuadricula.llenarNumerosDisponibles();
	        c.removeNumberRepetitive(cells);
	        c.markTrueNumberRepetitive(cells);
	        c.printMatrix(cells);



	}

}