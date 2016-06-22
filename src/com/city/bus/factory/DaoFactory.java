package com.city.bus.factory;

import com.city.bus.dao.*;
import com.city.bus.dao.Impl.*;

public class DaoFactory {

	public static IBusDao getBusDao(){
		return new BusDaoImpl();
	}
	public static IUserDao getUserDao(){
		return new UserDaoImpl();
	}
	public static IPowerDao getPowerDao(){
		return new PowerDaoImpl();
	}
	public static IStationDao getStationDao(){
		return new StationDaoImpl();
	}
	
}
