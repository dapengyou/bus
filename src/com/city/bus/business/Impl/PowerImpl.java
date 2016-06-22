package com.city.bus.business.Impl;

import java.util.List;

import com.city.bus.business.IPower;
import com.city.bus.dao.IPowerDao;
import com.city.bus.dao.IUserDao;
import com.city.bus.factory.DaoFactory;
import com.city.bus.value.powerValue;
import com.city.bus.value.userValue;

public class PowerImpl implements IPower{

	@Override
	public void add(String username, String password, String power)
			throws Exception {
		powerValue pv = new  powerValue();
		pv.setUsername(username);
		pv.setPassword(password);
		pv.setPower(power);
		IPowerDao ipd = DaoFactory.getPowerDao();
		ipd.create(pv);
		
		
	}

	@Override
	public void modify(String username, String password, String power)
			throws Exception {
		powerValue pv = new powerValue();
		pv.setUsername(username);
		pv.setPassword(password);
		pv.setPower(power);
		IPowerDao ipd = DaoFactory.getPowerDao();
		ipd.update(pv);
		
	}

	@Override
	public void delete(String username) throws Exception {
		powerValue pv = new powerValue();
		pv.setUsername(username);
		IPowerDao ipd = DaoFactory.getPowerDao();
		ipd.delete(pv);
		
	}

	@Override
	public List<powerValue> getList() throws Exception {
		IPowerDao ipd = DaoFactory.getPowerDao();
		return ipd.getList();
	}

	@Override
	public powerValue getpowerValue(String username) throws Exception {
		IPowerDao ipd = DaoFactory.getPowerDao();
		return ipd.getpowerValue(username);
	}

}
