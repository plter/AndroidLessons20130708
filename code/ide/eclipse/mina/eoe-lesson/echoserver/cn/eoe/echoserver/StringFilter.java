package cn.eoe.echoserver;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

public class StringFilter extends IoFilterAdapter {

	@Override
	public void messageReceived(NextFilter nextFilter, IoSession session,
			Object message) throws Exception {
		super.messageReceived(nextFilter, session, ((IoBuffer)message).getString(Charset.forName("utf-8").newDecoder()).trim());
	}
}
