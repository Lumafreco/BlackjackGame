package Presentacion;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class JugadorCliente extends Thread{
	private static Socket socket;
	private static String serverAddress;
	private static int serverPort;
	private static BufferedReader input;
	private static PrintWriter output;
	
	public JugadorCliente(String serverAddres, int serverPort ){
		
		try {
			socket = new Socket(serverAddress,serverPort);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		System.out.println("Ingrese direccion y el puerto por el cual esta escuchando el servidor.");
		System.out.println("Ex. 127.0.0.1 6000"+"\n");
		serverAddress = args[0];
		serverPort = Integer.parseInt(args[1]);
		JugadorCliente cliente = new JugadorCliente(serverAddress, serverPort);
		
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			try {
				String fromUser,fromServer;
				
				fromServer = input.readLine();
				System.out.println("Servidor: " +fromServer);
				
				fromUser = input.readLine(); //Lee lo que escriba el cliente en consola.
				output.println(fromUser);//Lo manda
				if(fromUser.equalsIgnoreCase("SALIR")){
					break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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



