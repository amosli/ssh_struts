package com.amos.service;

import java.util.Date;

public class HelloImpl implements IHello {
	public String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HelloImpl(){
		System.out.println("初始化HelloImpl....");
	}
	public String sayHi() {
		System.out.println("hi,大家好！");
		return msg + "现在时间为:" + new Date();

	}

}
