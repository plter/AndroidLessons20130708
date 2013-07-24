package cn.eoe.usingrc;

import cn.eoe.remotecall.RCServer;

public class MyServer extends RCServer{

	public String hello(String name){
		return "Hello "+name;
	}
}
