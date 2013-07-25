package cn.eoe.echoserver;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class EchoServer {

	public static void main(String[] args) {
		
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
//		acceptor.getFilterChain().addLast("StringFilter", new StringFilter());
		acceptor.setHandler(new EchoServerHandler());
		try {
			acceptor.bind(new InetSocketAddress(8000));
			System.out.println("服务器已经启动");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
