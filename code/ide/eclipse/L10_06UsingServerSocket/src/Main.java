import java.io.IOException;
import java.net.ServerSocket;


public class Main {

	public static void main(String[] args) {


		try {
			ServerSocket server = new ServerSocket(8000);

			System.out.println("服务器已启动");
			while(true){
				new ChatThread(server.accept()).start();
//				new EchoThread(server.accept()).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
