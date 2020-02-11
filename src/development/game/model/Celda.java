package development.game.model;

public class Celda {

	private Integer numero;
	private Posicion miPosicion;
	private boolean isRepeat;
	
	public Celda(Posicion p, Integer numero) {
		this.setNumero(numero);
		this.setMiPosicion(p);
		this.setRepeat(false);
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