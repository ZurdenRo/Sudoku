package development.game.app;


import development.game.model.Cuadricula;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Cuadricula c = new Cuadricula();
		c.createArrayNumber();
		Cuadricula.addNumber();
		c.removeNumberRepetitive();
		c.markTrueNumberRepetitive();
		Cuadricula.setArr(Cuadricula.arr);
		System.out.println(Arrays.toString(Cuadricula.getArr()));

	}

}