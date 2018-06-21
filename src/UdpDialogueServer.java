import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpDialogueServer {
	public static void main(String[] args) {
		BufferedReader br = null;
		DatagramSocket ds = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			byte [] bs = new byte[1024];
			//指定端口号
			ds = new DatagramSocket(10000);
			DatagramPacket dpReceive = new DatagramPacket(bs, 0, bs.length, InetAddress.getLocalHost(), 10000);
			while(true) {
				//接收数据
				ds.receive(dpReceive);
				String dataReceive = new String(dpReceive.getData(), 0, dpReceive.getLength());
				System.out.println("服务器接收到的数据: " + dataReceive);
				if("exit".equals(dataReceive)) {
					break;
				}
				//发送数据
				String data = br.readLine();
				DatagramPacket dpSend = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, InetAddress.getLocalHost(), 10000);
				ds.send(dpSend);
				System.out.println("服务器发送的数据: " + data);
				if("exit".equals(data)) {
					break;
				}
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
