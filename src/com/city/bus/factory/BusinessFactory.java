package com.city.bus.factory;

import com.city.bus.business.*;
import com.city.bus.business.Impl.*;

public class BusinessFactory {
	//取得信息业务对象
	public static IPower getPower(){
		return new PowerImpl();
	}
	public static IStation getStation(){
		return new StationImpl();
		
	}
	public static IUser getUser(){
		return new UserImpl();
	}
	public static IBus getBus(){
		return new BusImpl();
	}
}
