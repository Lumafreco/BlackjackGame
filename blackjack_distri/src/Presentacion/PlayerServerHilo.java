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
	private DataOutputStream output;
	private DataInputStream input;
	private int idHilo;
	
	private Juego tableroJuego;
	
	public PlayerServerHilo(Socket socket, int idHilo) {
		super();
		this.socket = socket;
		this.idHilo = idHilo;
		
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public void run(){
		String comando = "";
		boolean bandera = true;
		while(bandera){
			try {
				comando =  input.readUTF();
				System.out.println(comando);
				if(comando.startsWith("PEDIR")){
					System.out.println("entre al if de pedir");
					
					output.writeUTF("El jugador "+this.idHilo+" recibe un AS");
					
				}else if(comando.startsWith("PASAR")){
					output.writeUTF("Turno cedido");
				}else if(comando.startsWith("QUIT")){
					output.writeUTF("Adios jugador");
					bandera = false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void desconectar(){
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


