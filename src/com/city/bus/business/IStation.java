package com.city.bus.business;

import java.util.List;

import com.city.bus.value.stationValue;
public interface IStation {
	public void add(String stationId,String station,String startTime,String endTime) throws Exception;
	public void modify(String stationId,String station,String startTime,String endTime) throws Exception;
	public void delete(String stationId) throws Exception;
	//取得列表
	public List<stationValue> getList() throws Exception;

	//取得指定
	public stationValue getstationValue(String stationId) throws Exception;
}
