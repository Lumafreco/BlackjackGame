package Logica;

import java.util.ArrayList;
import java.util.List;

public class Mano {

	private List<Carta> cartasMano;
	private int puntajeMano;
	
	public Mano(){
		this.cartasMano = new ArrayList<>();
	}
	
	
	public List<Carta> getcartasMano(){
		return cartasMano;
	}

	
	public void AniadirCarta(Carta carta){
		this.cartasMano.add(carta);
		if("A".equalsIgnoreCase(carta.getRango())){
			if(puntajeMano<=10){
				puntajeMano += 11;
			}else{
				puntajeMano +=1;
			}
		}else{
			puntajeMano += carta.getValor();
		}
		
		if(puntajeMano > 21){
			puntajeMano = 0;
			for(Carta cartaT : cartasMano){
				if("A".equalsIgnoreCase(cartaT.getRango())){
					puntajeMano += 1;
				}else{
					puntajeMano += cartaT.getValor();
					
				}
			}
		}
			
		
	}
		
	
public int getPuntajeMano(){
	return puntajeMano;
}
public boolean TieneBlackJack(){
	if(puntajeMano == 21){
		return true;
	}else{
		return false;
	}
}
public boolean PierdeJuego(){
	if (puntajeMano > 21){
		return true;
	}else{
		return false;
	}
}
	
	
	
	
}
