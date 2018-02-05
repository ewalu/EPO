package pl.edu.atena.rest;

import java.time.LocalDate;
import java.util.List;

public class Result {
	
	private int wynik1;
	private int wynik2;
	private int wynik3;
	private LocalDate data;
	private List<String> lista;
	
	public int getWynik1() {
		return wynik1;
	}
	public void setWynik1(int wynik1) {
		this.wynik1 = wynik1;
	}
	public int getWynik2() {
		return wynik2;
	}
	public void setWynik2(int wynik2) {
		this.wynik2 = wynik2;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public int getWynik3() {
		return wynik3;
	}
	public void setWynik3(int wynik3) {
		this.wynik3 = wynik3;
	}
	public List<String> getLista() {
		return lista;
	}
	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
	

}
