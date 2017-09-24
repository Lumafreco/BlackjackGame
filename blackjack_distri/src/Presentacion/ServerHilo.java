/**
 * 
 */
package Presentacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Logica.Juego;

/**
 * @author Ricardo
 *
 */
public class ServerHilo extends Thread{

	private Socket socket;
	private DataOutputStream doutput;
	private DataInputStream dinput;
	private int idHilo;
	
	public ServerHilo(Socket socket, int idHilo) {
		super();
		this.socket = socket;
		this.idHilo = idHilo;
		try {
			this.dinput = new DataInputStream(socket.getInputStream());
			this.doutput = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
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
	
	
	@Override
	public void run(){
		String inMessage;
		try {
			inMessage = dinput.readUTF();
			
			while(Juego.juegoTerminado!=true){
				
				//TODO Logica del Crupier Servidor
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desconectar();
	}
}
