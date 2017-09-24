/**
 * 
 */
package Presentacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Ricardo
 *
 */
public class ServerHilo extends Thread{

	/**
	 *	Se creara un hilo para jugador 
	 */
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
			// TODO Auto-generated catch block
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
			if(inMessage.equals("hola")){
				System.out.println("El cliente dice "+this.idHilo+" saluda");
				doutput.writeUTF("Adios.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		desconectar();
	}
}
