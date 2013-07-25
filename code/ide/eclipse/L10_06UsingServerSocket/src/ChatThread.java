import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import com.plter.lib.java.lang.Array;
import com.plter.lib.java.lang.ArrayLoopCallback;


public class ChatThread extends Thread {

	
	public ChatThread(Socket socket) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		
		chatThreads.push(this);
		
		try {
			outputStream=socket.getOutputStream();
			inputStream=socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			String line = null;
			while((line=br.readLine())!=null){
				sendToAll(line,this);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		chatThreads.remove(this);
		
		super.run();
	}
	
	
	public void writeLine(String line){
		line+="\n";
		try {
			outputStream.write(line.getBytes("utf-8"));
			outputStream.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
			chatThreads.remove(this);
			interrupt();
		}
	}
	
	
	public static void sendToAll(final String line,final ChatThread except){
		chatThreads.each(new ArrayLoopCallback<ChatThread>() {
			
			@Override
			public void onRead(ChatThread current) {
				if (current!=except) {
					current.writeLine(line);
				}
			}
		});
	}
	
	
//	private void tmp() {
//		synchronized (chatThreads) {
//			for (ChatThread thread : chatThreads) {
//				
//			}
//		}
//	}
	
	private OutputStream outputStream;
	private InputStream inputStream;
	private Socket socket;
	private static Array<ChatThread> chatThreads = new Array<ChatThread>();
//	private static final List<ChatThread> chatThreads = Collections.synchronizedList(new ArrayList<ChatThread>());
}
