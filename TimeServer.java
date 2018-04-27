package netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) {

		int port = 8080;
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket(port);
			Socket socket = null;
			while (true) {
				socket = serversocket.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
