package Presentacion;
import java.net.*;
import java.util.List;
import java.io.*;

public class PlayerCliente{
	
	private Socket socket;
	private boolean conected;
	private static final int TWAIT_PLAYER = 250;
	private List<ObjectInputStream> input;
	private List<ObjectOutputStream> output;
	
	

	public PlayerCliente(Socket socket) {
		// TODO Auto-generated constructor stub
	}

	public boolean estaConectdo() {
		// TODO Auto-generated method stub
		return false;
	}
}






/*
public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	
	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Socket socket;
	
	byte[] mensaje_byte = new byte[256];
	String mensaje = "";
	try{
		
		socket = new Socket("127.0.0.1",6000);
		
		DataOutputStream out =
				new DataOutputStream(socket.getOutputStream());
		
		do{
			mensaje = in.readLine();
			out.writeUTF(mensaje);
		} while(!mensaje.startsWith("finnal"));
		}
	catch (Exception e){
		System.err.println(e.getMessage());
		System.exit(1);
	}
}

*/



