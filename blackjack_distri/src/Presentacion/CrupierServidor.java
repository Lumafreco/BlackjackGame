package Presentacion;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 * 
 * @author Ricardo
 *	Esta clase maneja las conexiones de los jugadores y sus respectivos mensajes.
 *	Por cada jugador que se conecte al servidor, se creara un thread y se añade al jugador.
 *	
 */

public class CrupierServidor extends Thread{
	
	private InetAddress hostAddress;
	private List<JugadorCliente> jugadores;
	private static final int SERVERGAME_PORT =  6000;
	private static final int TWAIT_SERVER = 250;
	
	
	
	
	

	public static void main (String args[]){
		ServerSocket server_socket;
		Socket socket;
		boolean listening = true;
		int idServer = 0;
		
		
		System.out.println("Inicializando servidor...");
		try{
			server_socket = new ServerSocket(SERVERGAME_PORT);
			System.out.println("[OK]");
			socket = server_socket.accept();
			System.out.println("Nueva conexion entrante" +socket);
			((ServerHilo)new ServerHilo(socket,idServer)).start();
			idServer++;
			
		}catch(IOException ex){
			ex.printStackTrace();
			Logger.getLogger(CrupierServidor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}	
}




























/*
 * 	public CrupierServidor(){
			
		jugadores =  new ArrayList<JugadorCliente>();
		//Obtener direccion del servidor
		try {
			hostAddress = InetAddress.getLocalHost(); //Se obtiene la direccion local del servidor.
			System.out.println("La direccion local del servidor es: "+hostAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("ERROR: No se peude obtener la direccion host!");
			return;
		}
		
		//Creacion del socket
		try {
			serverSocket = new ServerSocket(SERVERGAME_PORT,0,hostAddress);
			System.out.println("Socket "+serverSocket+" creado correctamente.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR: Socket ocupado o inhabilitado.");
		}
	
	}//Fin CrupierServidor()
 */











/*
 * 		System.out.println("Servidor en ejeccucion.......");
		
		//Loop infinito hasta que el servidor se apague.
		while(true){
			
			//Verificar que jugadores estan conectados.
			for(int i=0;i<jugadores.size();i++){
				if(!jugadores.get(i).estaConectdo()){
					jugadores.remove(i);
					System.out.println("El jugador "+jugadores.get(i)+" ha sido desconectado del servidor.");					
				}
			}
			
			//Obtener un jugador que este intentando conectarse al servidor.
			try {
				socket = serverSocket.accept();
				System.out.println("El jugador "+socket+" se ha conectado.");
				jugadores.add(new PlayerCliente(socket)); //Se añade a lista de jugadores del servidor.
				
				
			} catch (IOException e) {
				System.out.println("No se pudo obtener un jugado.");
				e.printStackTrace();
			}
			
			
			try {
				Thread.sleep(TWAIT_SERVER);
			} catch (InterruptedException e) {
				System.out.println("El servidor ha sido desconectado.");
				e.printStackTrace();
			}

		}//Fin While(true)
 */











/*
public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	
	ServerSocket socket;
	boolean finnal = false;
	
	try{
		socket = new ServerSocket(6000);
		Socket socket_cli = socket.accept();
		
		
		DataInputStream in =
				new DataInputStream(socket_cli.getInputStream());
		
		do{
			String mensaje ="";
			mensaje = in.readUTF();
			System.out.println(mensaje);
			} while(1>0);
		}
	catch (Exception e){
		
		System.err.println(e.getMessage());
		System.exit(1);
	}
}
*/
