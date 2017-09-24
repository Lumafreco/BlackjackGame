package Logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Jugador extends Thread{

	private int idJugador;
	private Socket socket;
	private boolean conected;
	private static final int TWAIT_PLAYER = 250;
	private static final int SERVER_MAIN = 6000;
	private static final int SERVER_MIRROR = 6001;
	private DataInputStream input;
	private DataOutputStream output;
	

	public Jugador(int idJugador) {
		super();
		this.idJugador = idJugador;
		
	}
	
	@Override
	public void run(){
		try {
			socket = new Socket("127.0.0.1", SERVER_MAIN);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
						
			
			// TODO Llame funciones de Logica
						
			
			input.close();
			output.close();
			socket.close();
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo establecer conexion con el servidor.");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Argumentos invalidos.");
			e.printStackTrace();
		}finally{
			
			
		}
		
	}
	
	/**
	 * Getters/Setters
	 * @return
	 */

	public boolean estaConectdo() {
		// TODO Auto-generated method stub
		return false;
	}

}
