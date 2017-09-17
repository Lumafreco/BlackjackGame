package Logica;

public enum Cara {
	AS("A",11),
	DOS("2",2),
	TRES("3",3),
	CUATRO("4",4),
	CINCO("5",5),
	SEIS("6",6),
	SIETE("7",7),
	OCHO("8",8),
	NUEVE("9",9),
	DIEZ("10",10),
	J("J",10),
	Q("Q",10),
	K("K",10);
	
	private String rango;
	private int valor;
	private Cara(String rango, int valor) {
		this.rango = rango;
		this.valor = valor;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	

}
