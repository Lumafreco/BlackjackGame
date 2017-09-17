package Logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baraja {

private List<Carta> cartas;

	public Baraja(){
		this.cartas = new ArrayList<>();
		for(Palo p : Palo.values()){
			int orden = 0;
			for(Cara c : Cara.values()){
				Carta carta = new Carta();
				carta.setPalo(p.toString());
				carta.setRango(c.getRango());
				carta.setSort(orden);
				carta.setValor(c.getValor());
				cartas.add(carta);
				orden++;
				
			}
			
			Random random = new Random();
			Collections.shuffle(cartas, random);
			
		}
		
	}
	
	public List<Carta> getCartas(){
		return cartas;
	}
	public Carta cogerCarta(){
		return cartas.remove(0);
	}

}
