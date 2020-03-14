package development.game.app;

import development.game.model.Cuadricula;



public class App {
	public static void main(String[] args) {
		Cuadricula c = new Cuadricula();
		c.createArrayNumber();
		Cuadricula.addNumber();
		c.printNumber(Cuadricula.arr);
		c.removeNumberRepetitive();
		c.markTrueNumberRepetitive();
		c.printNumber(Cuadricula.arr);
	}

}