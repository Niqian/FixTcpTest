package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
public static void main(String[] args) {
	Socket socket=null;
	PrintWriter out=null; 
	BufferedReader in=null;
	try {
		socket =new Socket("127.0.0.1",18001);
		out=new PrintWriter(socket.getOutputStream());
		out.println("00000009HeartBeat");
		out.flush();
		System.out.println("send to server success!");
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(in.readLine());
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally {
		try {
			if (in != null) {
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (socket != null) {
				socket.close();
				socket = null;
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		

	}
	
	

}
}
