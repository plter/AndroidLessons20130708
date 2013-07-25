package cn.eoe.echoserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class EchoServer {

	public static void main(String[] args) {
				
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.setHandler(new EchoServerHandler());
//		acceptor.getFilterChain().addLast("StringFilter", new StringFilter());
		try {
			acceptor.bind(new InetSocketAddress(8000));
			System.out.println("服务器已经启动");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
