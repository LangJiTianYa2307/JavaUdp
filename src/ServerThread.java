import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerThread extends Thread{
	private int port;
	public ServerThread(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BufferedReader br = null;
		DatagramSocket ds = null;
		try {
			byte [] bs = new byte[1024];
			//指定端口号
			ds = new DatagramSocket(this.port);
			DatagramPacket dpReceive = new DatagramPacket(bs, 0, bs.length, InetAddress.getLocalHost(), this.port);
			while(true) {
				//接收数据
				ds.receive(dpReceive);
				String dataReceive = new String(dpReceive.getData(), 0, dpReceive.getLength());
				if("exit".equals(dataReceive)) {
					break;
				}
				System.out.println("收到的数据: " + dataReceive);
				
			}
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
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
