package com.city.bus.business.Impl;

import java.util.List;

import com.city.bus.business.IStation;
import com.city.bus.dao.IBusDao;
import com.city.bus.dao.IStationDao;
import com.city.bus.factory.DaoFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.stationValue;

public class StationImpl implements IStation{

	@Override
	public void add(String stationId, String station, String startTime,
			String endTime) throws Exception {
		stationValue sv = new  stationValue();
		sv.setStationId(stationId);
		sv.setStation(station);
		sv.setStartTime(startTime);
		sv.setEndTime(endTime);
		IStationDao ibd = DaoFactory.getStationDao();
		ibd.create(sv);
		
	}

	@Override
	public void modify(String stationId, String station, String startTime,
			String endTime) throws Exception {
		IStationDao ibd = DaoFactory.getStationDao();
		stationValue sv = ibd.get(stationId);
		sv.setStationId(stationId);
		sv.setStation(station);
		sv.setStartTime(startTime);
		sv.setEndTime(endTime);
		ibd.update(sv);
		
	}

	@Override
	public void delete(String stationId) throws Exception {
		stationValue sv = new stationValue();
		sv.setStationId(stationId);
		IStationDao ibd = DaoFactory.getStationDao();
		ibd.delete(sv);
		
	}

	@Override
	public List<stationValue> getList() throws Exception {
		IStationDao ibd = DaoFactory.getStationDao();
		return ibd.getList();
	}

	@Override
	public stationValue getstationValue(String stationId) throws Exception {
		IStationDao ibd = DaoFactory.getStationDao();
		return ibd.get(stationId);
	}

}
