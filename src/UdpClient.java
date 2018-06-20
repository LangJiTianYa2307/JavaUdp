import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {
	public static void main(String[] args) {
		DatagramSocket ds =null;
		try {
			ds = new DatagramSocket();
			byte [] bs = "exit".getBytes();
			InetAddress ia = null;
			try {
				ia = InetAddress.getLocalHost();
				DatagramPacket dp = new  DatagramPacket(bs, 0, bs.length, ia, 10001);
				try {
					ds.send(dp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
		
	}
}
