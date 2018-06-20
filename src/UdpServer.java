import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//创建服务器端口
			ds = new DatagramSocket(10000);
			byte [] bs = new byte[1024];
			//定义数据包
			DatagramPacket dp = new DatagramPacket(bs, 0, bs.length);
			try {
				//接收数据
				ds.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			InetAddress ia= dp.getAddress();
			byte[] bs1 = dp.getData();
			String data = new String(bs1, 0, dp.getLength());
			System.out.println(ia.getLocalHost().getHostAddress()+"获得到的数据:"+data);
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		} finally {
			if(ds != null) {
				ds.close();
			}
		}
	}
}
