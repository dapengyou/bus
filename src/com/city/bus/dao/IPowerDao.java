package com.city.bus.dao;

import java.util.List;

import com.city.bus.value.powerValue;

public interface IPowerDao {
	//创建
	public void create(powerValue pv) throws Exception;
	//更新
	public void update(powerValue pv) throws Exception;
	//删除
	public void delete(powerValue pv) throws Exception;
	//获得指定
	public powerValue getpowerValue(String username) throws Exception;
	//获取列表
	public List<powerValue> getList() throws Exception;
}
