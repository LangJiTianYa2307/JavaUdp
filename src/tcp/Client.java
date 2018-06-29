package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			Socket socket = new Socket("192.168.1.108",8888);
			//客户端获取输出
			OutputStream output = socket.getOutputStream();
			pw  = new PrintWriter(output);
			Scanner cin = new Scanner(System.in);
			pw.write(cin.nextLine());
			pw.flush();
			socket.shutdownOutput();
			//客户端获取输入
			InputStream in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));
			String readData = null;
			while((readData = br.readLine()) != null) {
				System.out.println("客服端读取到的数据为:  " + readData);
			}
			cin.close();
			socket.close();
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
		}
	}
}
