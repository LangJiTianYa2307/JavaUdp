import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientThread extends Thread{
    private int portOfServer;
    private int portOfClient;
    
	public ClientThread(int portOfServer,int portOfClient) {
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
			br = new BufferedReader(new InputStreamReader(System.in));
			ds = new DatagramSocket();
			while(true) {
				//发送数据
				String data = br.readLine();
				//默认使用的是本地的Ip地址
				DatagramPacket dpSendToServer = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, InetAddress.getLocalHost(), this.portOfClient);
				//服务器断开连接
				DatagramPacket dpSendToClient = new DatagramPacket("exit".getBytes(), 0, "exit".getBytes().length, InetAddress.getLocalHost(), this.portOfServer);
				
				if("exit".equals(data)) {
					//用于关闭客户端
					ds.send(dpSendToClient);
					break;
				}
				//发送数据到服务器
				ds.send(dpSendToServer);
//				System.out.println("发送的数据: " + data);
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
