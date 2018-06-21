
public class ChatRoom1 {
	public static void main(String[] args) {
		ServerThread st = new ServerThread(10001);
		ClientThread ct = new ClientThread(10000);
		st.start();
		ct.start();
	}
}
