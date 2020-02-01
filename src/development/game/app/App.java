package development.game.app;

import development.game.model.Cuadricula;
import development.game.model.Numeros;



public class App {
	public static void main(String[] args) {
		Cuadricula cuad = new Cuadricula();
		cuad.generarCuadro();
		cuad.printMatriz();
		Numeros.armarArray();
	
	}

}