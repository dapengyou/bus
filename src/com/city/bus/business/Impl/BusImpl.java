package com.city.bus.business.Impl;

import java.util.List;

import com.city.bus.business.IBus;
import com.city.bus.dao.IBusDao;
import com.city.bus.dao.IPowerDao;
import com.city.bus.factory.DaoFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.powerValue;

public class BusImpl implements IBus{

	@Override
	public void add(String stationId, String stationA, String stationB,
			String startTime, String endTime) throws Exception {
		busValue bv = new  busValue();
		bv.setStationId(stationId);
		bv.setStationA(stationA);
		bv.setStationB(stationB);
		bv.setStartTime(startTime);
		bv.setEndTime(endTime);
		IBusDao ibd = DaoFactory.getBusDao();
		ibd.create(bv);
		
	}

	@Override
	public void modify(String stationId, String stationA, String stationB,
			String startTime, String endTime) throws Exception {
		IBusDao ibd = DaoFactory.getBusDao();
		busValue bv = ibd.get(stationId);
		bv.setStationId(stationId);
		bv.setStationA(stationA);
		bv.setStationB(stationB);
		bv.setStartTime(startTime);
		bv.setEndTime(endTime);
		ibd.update(bv);
		
	}

	@Override
	public void delete(String stationId) throws Exception {
		busValue bv = new busValue();
		bv.setStationId(stationId);
		IBusDao ibd = DaoFactory.getBusDao();
		ibd.delete(bv);
		
	}

	@Override
	public List<busValue> getList() throws Exception {
		IBusDao ibd = DaoFactory.getBusDao();
		return ibd.getList();
		
	}

	@Override
	public busValue getBusValue(String stationId) throws Exception {
		IBusDao ibd = DaoFactory.getBusDao();
		
		return ibd.get(stationId);
	}

}
