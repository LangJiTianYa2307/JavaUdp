import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(InetAddress.getLocalHost().getHostName());
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			System.out.println(InetAddress.getByName("hzl-ubuntu"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
