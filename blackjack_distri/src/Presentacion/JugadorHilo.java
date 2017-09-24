package Presentacion;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class JugadorHilo extends Thread{

	private int idJugador;
	private String nickName;
	private Socket socket;
	private boolean conected;
	private static final int TWAIT_PLAYER = 250;
	private static final int SERVER_MAIN = 6000;
	private static final int SERVER_MIRROR = 6001;
	private DataInputStream input;
	private DataOutputStream output;
	
	public JugadorHilo(int idJugador) {
		super();
		this.idJugador = idJugador;
		this.nickName = nickName;	
	}
	
	@Override
	public void run(){
		try {
			
			socket = new Socket("192.168.43.120", SERVER_MAIN);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo establecer conexion con el servidor.");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Argumentos invalidos.");
			e.printStackTrace();
		}
		
		String respuesta = "";
		
		while(respuesta == null){
			try {
				output.writeUTF("hola");
				respuesta = input.readUTF();
				
				
				// TODO Llame funciones de Logica
				
				
				
				System.out.println(this.idJugador+ " envia un saludo");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
		
		
		//Cerrar conexion
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	public void pedirCarta(){
		
	}
	
	public void ceder(){
			
	}
	
	/**
	 * Getters/Setters
	 * @return
	 */

	public boolean estaConectdo() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
