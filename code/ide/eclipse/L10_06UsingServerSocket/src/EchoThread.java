import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class EchoThread extends Thread {
	
	
	public EchoThread(Socket socket) {
		this.socket=socket;
	}
	

	@Override
	public void run() {
		
		try {
			OutputStream os = socket.getOutputStream();
			
			while(true){
				os.write(String.format("Hello Client %d\n", i).getBytes("utf-8"));
				os.flush();
				i++;
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		super.run();
	}
	
	private int i = 0;
	private Socket socket;
}
