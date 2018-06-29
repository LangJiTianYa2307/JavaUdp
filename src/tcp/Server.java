package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		BufferedReader br = null;
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("服务器已经启动");
			Socket socket = serverSocket.accept();
			//获取输入流,接收客服断的数据
			InputStream in =socket.getInputStream();
			//获取输出流,向服务器发送的数据
			br = new BufferedReader(new InputStreamReader(in));
			String readData = null;
			while((readData = br.readLine())!= null){
				System.out.println("服务接收到的数据是:	" + readData);
				System.out.println("客户端的ip地址是 " + socket.getInetAddress().getHostAddress());
			}
			OutputStream output = socket.getOutputStream();
			PrintWriter pw = new  PrintWriter(new OutputStreamWriter(output));
			pw.print("服务器已经到你的数据");
			pw.flush();
			socket.shutdownOutput();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
