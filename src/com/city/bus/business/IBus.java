package com.city.bus.business;

import java.util.List;

import com.city.bus.value.busValue;

public interface IBus {
	public void add(String stationId,String stationA,String stationB,String startTime,String endTime) throws Exception;
	public void modify(String stationId,String stationA,String stationB,String startTime,String endTime) throws Exception;
	public void delete(String stationId) throws Exception;
	//取得列表
	public List<busValue> getList() throws Exception;

	//取得指定
	public busValue getBusValue(String stationId) throws Exception;
}
