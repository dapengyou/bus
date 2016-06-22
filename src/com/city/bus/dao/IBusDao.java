package com.city.bus.dao;

import java.util.List;

import com.city.bus.value.busValue;

public interface IBusDao {
	//创建
		public void create(busValue bv) throws Exception;
		//更新
		public void update(busValue bv) throws Exception;
		//删除
		public void delete(busValue bv) throws Exception;
		//获得指定
		public busValue get(String stationId) throws Exception;
		//获取列表
		public List<busValue> getList() throws Exception;
}
