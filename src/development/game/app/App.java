package development.game.app;

import development.game.model.Celda;
import development.game.model.Cuadricula;
import development.game.model.Numeros;



public class App {
	public static void main(String[] args) {
		  Cuadricula c = new Cuadricula();
	        //Cuadricula.addNumber();
	        //Cuadricula.printNumber();
	        Celda [] [] celdas =  new Celda[3] [3];
	        c.createMatrixNumber(celdas);
	        Cuadricula.llenarNumerosDisponibles();
	        c.removeNumberRepetitive(celdas);
	        c.markTrueNumberRepetitive(celdas);
	        c.printMatrix(celdas);


	}

}