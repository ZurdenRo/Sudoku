package development.game.model;

import java.util.Random;

public class Cuadricula {
	
	private Celda [] [] matrix;
	
	public Cuadricula() {
		this.setMatrix(new Celda [6] [6]);
	}

	public void generarCuadro() {			
		for (int f = 0; f < this.getMatrix().length; f++) {
			for (int c = 0; c <this.getMatrix()[f].length; c++) {
				matrix[f][c] = new Celda(false, new Posicion(f, c) , generateNumberRandom());
			}
		}
	}

	public int generateNumberRandom() {
		Random number = new Random();
		int n = number.nextInt(9);
		return n += 1;
	}

	public void printMatriz() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(this.getMatrix()[i][j]);
			}
			System.out.println();
		}
	}
	
	public Celda[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Celda[][] matrix) {
		this.matrix = matrix;
	}


}