package netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			String body = null;

			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				String currenttime = null;
				if ("QUERY TIME ORDER".equals(body)) {
					currenttime = new Date(System.currentTimeMillis()).toString();
				} else {
					currenttime = "BAD ORDER";
				}
				out = new PrintWriter(this.socket.getOutputStream());
				out.println(currenttime);
				out.flush();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if (this.socket != null) {
					this.socket.close();
					this.socket = null;
				}

			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}

	}

}
