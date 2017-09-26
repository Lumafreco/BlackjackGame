package Presentacion;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class JugadorCliente{
	private Socket socket;
	private static String serverAddress;
	private static int serverPort;
	private BufferedReader input = null;
	private PrintWriter output = null;
	
	public JugadorCliente(String serverAddres, int serverPort ){
		System.out.println("Estableciendo conexion. Espere por favor....");
		try {
			socket = new Socket(serverAddress,serverPort);
			System.out.println("Conectado: "+socket);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = "";
		while(!line.equalsIgnoreCase("SALIR")){
			try{
				System.out.println("Cliente: ");
				line = input.readLine();
				output.println(line);
				output.flush();
			}catch(IOException ioe){
				System.out.println("Error al enviar: "+ioe.getMessage());
			}
		}
		
	}//Fin Constructor
	
	public void stop(){
		try {
			if (input != null) {
				input.close();
			}
			if(output != null){
				output.close();
			}
			if(socket != null){
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("Error cerrando.....");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ingrese direccion y el puerto por el cual esta escuchando el servidor.");
		System.out.println("Ex. 127.0.0.1 6000"+"\n");
		serverAddress = args[0];
		serverPort = Integer.parseInt(args[1]);
		JugadorCliente cliente = new JugadorCliente(serverAddress, serverPort);
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



