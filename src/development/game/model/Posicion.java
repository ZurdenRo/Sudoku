package development.game.model;

public class Posicion {

	private Integer fila;
	private Integer columna;
	
	public Posicion(Integer fila, Integer columna){
		this.setFila(fila);
		this.setColumna(columna);
	}
	

	public Integer getColumna() {
		return columna;
	}

	public void setColumna(Integer columna) {
		this.columna = columna;
	}
	
	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}
	
}