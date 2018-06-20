import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClientAdvance {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		BufferedReader br = null;
		try {
			ds = new DatagramSocket();
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String data = br.readLine();
				if("exit".equals(data)) {
					break;
				}
				DatagramPacket dp = new DatagramPacket(data.getBytes(), 0, data.getBytes().length, InetAddress.getLocalHost(), 10004);
				ds.send(dp);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
	}
}
