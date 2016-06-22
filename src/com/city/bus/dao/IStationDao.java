package com.city.bus.dao;

import java.util.List;

import com.city.bus.value.stationValue;

public interface IStationDao {
	//创建
			public void create(stationValue sv) throws Exception;
			//更新
			public void update(stationValue sv) throws Exception;
			//删除
			public void delete(stationValue sv) throws Exception;
			//获得指定
			public stationValue get(String stationId) throws Exception;
			//获取列表
			public List<stationValue> getList() throws Exception;
}
