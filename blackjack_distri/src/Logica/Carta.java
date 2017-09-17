package Logica;

public class Carta {

private String rango;
private String palo;
private int valor;
private int sort;

public String getRango() {
	return rango;
}
public void setRango(String rango) {
	this.rango = rango;
}
public String getPalo() {
	return palo;
}
public void setPalo(String palo) {
	this.palo = palo;
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}
public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}
@Override
public String toString() {
	return "Carta [rango=" + rango + ", palo=" + palo + ", valor=" + valor + ", sort=" + sort + "]";
}

}
