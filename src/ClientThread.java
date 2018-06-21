import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientThread extends Thread{
    private int prot;
    
	public ClientThread(int port) {
		this.prot = port;
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
				DatagramPacket dpSend = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, InetAddress.getLocalHost(), this.prot);
				ds.send(dpSend);
				if("exit".equals(data)) {
					System.out.println("-------------");
					break;
				}
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
