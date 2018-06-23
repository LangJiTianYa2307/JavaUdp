import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServerThread extends Thread{
	private int portOfServer;
	private int portOfClient;
	public ServerThread(int portOfServer, int portOfClient) {
		this.portOfServer = portOfServer;
		this.portOfClient = portOfClient;
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
			ds = new DatagramSocket(this.portOfServer);
			DatagramPacket dpReceive = new DatagramPacket(bs, 0, bs.length, InetAddress.getLocalHost(), this.portOfServer);
			DatagramPacket dpSend = new DatagramPacket("exit".getBytes(), 0, "exit".getBytes().length, InetAddress.getLocalHost(), this.portOfClient);
			while(true) {
				//接收数据
				ds.receive(dpReceive);
				String dataReceive = new String(dpReceive.getData(), 0, dpReceive.getData().length);
				if("exit".equals(dataReceive.substring(0, 4))) {
					ds.send(dpSend);
					break;
				}
				System.out.println("收到的数据: " + dataReceive);
				dataReceive = null;
				
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
