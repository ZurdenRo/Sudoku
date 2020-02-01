package development.game.model;

public final class Numeros {
	
	private boolean meEncuentro;
	private Integer numeros;
	private static Numeros [] ARR;
	
	
	public Numeros(Integer numeros, boolean meEncuentro) {
		this.setNumeros(numeros);
		this.setMeEncuentro(meEncuentro);
	}
	
	public Numeros() {
		
	}
	
	public Integer getNumeros() {
		return numeros;
	}

	public void setNumeros(Integer numeros) {
		this.numeros = numeros;
	}

	
	public boolean isMeEncuentro() {
		return meEncuentro;
	}

	public void setMeEncuentro(boolean meEncuentro) {
		this.meEncuentro = meEncuentro;
	}
	
	public static Numeros[] getArr() {
		return ARR;
	}

	public static void setArr(Numeros[] arr) {
		Numeros.ARR = arr;
	}

	public static void armarArray() {
		Numeros.setArr(new Numeros[9]);
		for (int i = 0; i < Numeros.getArr().length; i++) {
			Numeros.getArr()[i] = new Numeros(i+1,false);
		}
	}
}