package development.game.model;

import java.util.ArrayList;
import java.util.Random;

public class Cuadricula {
	
	private Celda [] [] matrix;
	private ArrayList<Integer> numerosEncontrados;
	
	public Cuadricula() {
		this.setMatrix(new Celda [6] [6]);
	}

	public Celda[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Celda[][] matrix) {
		this.matrix = matrix;
	}
	
	public void generarCuadro() {	
		iniciarNumeroGrilla();
		for (int f = 0; f < this.getMatrix().length; f++) {
			for (int c = 0; c < this.getMatrix()[f].length; c++) {
				int numeroAsignado = generateNumberRandom();
				if(numeroAsignado <= numerosEncontrados.size() ) {
					int num = numerosEncontrados.get(numeroAsignado - 1);
					getMatrix()[f][c] = new Celda(new Posicion(f, c), num);
					numerosEncontrados.remove(numeroAsignado - 1);
				}
				
			}
		}
	}

	public int generateNumberRandom() {
		Random number = new Random();
		int n = number.nextInt(9);
		return n += 1;
	}

	public void printMatriz() 
	{
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(this.getMatrix()[i][j]);
			}
			System.out.println();
		}
	}

	public void iniciarNumeroGrilla() {
		numerosEncontrados = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			numerosEncontrados.add(i + 1);
		}
	}
	
	public void limpiarNumerosRepetidos( Celda arr[][]) 
	{	
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
			
		}
	}
	}
}