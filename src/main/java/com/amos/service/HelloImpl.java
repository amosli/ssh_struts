package com.amos.service;

import java.util.Date;

public class HelloImpl implements IHello {
	public String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HelloImpl(){
		System.out.println("��ʼ��HelloImpl....");
	}
	public String sayHi() {
		System.out.println("hi,��Һã�");
		return msg + "����ʱ��Ϊ:" + new Date();

	}

}
