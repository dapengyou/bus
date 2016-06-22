package com.city.bus.business;

import java.io.InputStream;
import java.util.List;

import com.city.bus.value.userValue;

public interface IUser {
	public void add(String username,String password,String power,int age,String sex) throws Exception;
	public void modify(String username,String password,String power,int age,String sex) throws Exception;
	public void delete(String username) throws Exception;
	public boolean check(String username,String password) throws Exception;
	//取得列表
		public List<userValue> getList() throws Exception;

		//取得指定
		public userValue getuserValue(String username) throws Exception;	
}
