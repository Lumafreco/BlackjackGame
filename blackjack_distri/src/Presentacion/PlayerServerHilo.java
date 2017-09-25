/**
 * 
 */
package Presentacion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

import Logica.Juego;

/**
 * @author Ricardo
 *
 */
public class PlayerServerHilo extends Thread implements Serializable{

	private Socket socket;
	private PrintWriter output;
	private BufferedReader input;
	private int idHilo;
	
	private Juego tableroJuego;
	
	public PlayerServerHilo(Socket socket, int idHilo) {
		super();
		this.socket = socket;
		this.idHilo = idHilo;
		
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public void run(){
		
		while(true){
			try {
				String comando =  input.readLine();
				
				if(comando.equalsIgnoreCase("PEDIR")){
					output.println("Recibes un AS");
				}else if(comando.equalsIgnoreCase("PASAR")){
					output.println("Turno cedido");
				}else if(comando.equalsIgnoreCase("QUIT")){
					output.println("Adios jugador");
					return;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
