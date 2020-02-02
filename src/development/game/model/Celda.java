package development.game.model;

public class Celda {

	private Integer numero;
	private Posicion miPosicion;
	private boolean isRepeat;
	
	public Celda(boolean isRepeat, Integer numero) {
		this.setRepeat(isRepeat);
		this.setNumero(numero);
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Posicion getMiPosicion() {
		return miPosicion;
	}

	public void setMiPosicion(Posicion miPosicion) {
		this.miPosicion = miPosicion;
	}

	public boolean isRepeat() {
		return isRepeat;
	}

	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}
	
	public String toString() {
		return this.getNumero().toString();
	}
	
}