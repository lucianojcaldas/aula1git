package trabalho3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static Socket socket;
	private static ServerSocket server;

	private static ObjectInputStream entrada;
	private static ObjectOutputStream saida;
	
	public static void main(String[] args) {

		try {

			server = new ServerSocket(51000);

			socket = server.accept();

			entrada = new ObjectInputStream(socket.getInputStream());

			Pessoa p = (Pessoa) entrada.readObject();
			
			System.out.println("Resultado:" + p.getNome() +" , "+ p.getIdade());
			
		    saida = new ObjectOutputStream(socket.getOutputStream());

		    saida.writeObject("servidor conectado...");
			
			socket.close();

		} catch (Exception e) {

		}
	}
}
