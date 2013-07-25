package cn.eoe.echoserver;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.plter.lib.java.lang.Array;
import com.plter.lib.java.lang.ArrayLoopCallback;

public class EchoServerHandler extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		
		final String str = ((IoBuffer)message).getString(Charset.forName("utf-8").newDecoder()).trim()+"\n";
		
		sessions.each(new ArrayLoopCallback<IoSession>() {
			
			@Override
			public void onRead(IoSession current) {
				try {
					current.write(IoBuffer.wrap(str.getBytes("utf-8")));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
		
		super.messageReceived(session, message);
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		
		sessions.remove(session);
		
		super.sessionClosed(session);
	}
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		
		sessions.push(session);
		
		super.sessionCreated(session);
	}
	
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}
	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}
	
	private static Array<IoSession> sessions = new Array<IoSession>();
}
