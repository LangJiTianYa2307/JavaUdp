import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerAdvance {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10001);
			byte [] bs = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bs, 0, bs.length);
			while(true) {
				ds.receive(dp);
				String data = new String(dp.getData(), 0, dp.getLength());
				if("exit".equals(data)) {
					break;
				}
				System.out.println("服务器接收的数据:" + data);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
	}
}
