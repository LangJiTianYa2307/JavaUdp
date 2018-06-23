
public class ChatRoom1 {
	public static void main(String[] args) {
		ServerThread st = new ServerThread(10001,10000);
		ClientThread ct = new ClientThread(10001,10000);
		st.start();
		ct.start();
	}
}
