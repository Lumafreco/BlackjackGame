package Presentacion;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class JugadorCliente extends Thread{
		
	public static void main(String[] args) {
		
        List<Thread> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clients.add(new JugadorHilo(i));
        }
        for (Thread thread : clients) {
            thread.start();
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



