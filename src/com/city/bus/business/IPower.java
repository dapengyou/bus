package com.city.bus.business;

import java.util.List;

import com.city.bus.value.busValue;
import com.city.bus.value.powerValue;

public interface IPower {
	public void add(String username,String password,String power) throws Exception;
	public void modify(String username,String password,String power) throws Exception;
	public void delete(String username) throws Exception;
	
	//取得列表
		public List<powerValue> getList() throws Exception;

		//取得指定
		public powerValue getpowerValue(String username) throws Exception;
}
