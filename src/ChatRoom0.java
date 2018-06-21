
public class ChatRoom0 {
	public static void main(String[] args) {
		ServerThread st = new ServerThread(10000);
		ClientThread ct = new ClientThread(10001);
		st.start();
		ct.start();
	}
}
