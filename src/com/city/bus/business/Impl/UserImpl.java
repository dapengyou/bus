package com.city.bus.business.Impl;

import java.io.InputStream;
import java.util.List;

import com.city.bus.business.IUser;
import com.city.bus.dao.IBusDao;
import com.city.bus.dao.IUserDao;
import com.city.bus.factory.DaoFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.userValue;

public class UserImpl implements IUser{



	@Override
	public void delete(String username) throws Exception {
		userValue uv = new userValue();
		uv.setUsername(username);
		IUserDao iud = DaoFactory.getUserDao();
		iud.delete(uv);
		
	}

	@Override
	public List<userValue> getList() throws Exception {
		IUserDao iud = DaoFactory.getUserDao();
		return iud.getList();
	}

	@Override
	public userValue getuserValue(String username) throws Exception {
		IUserDao iud = DaoFactory.getUserDao();
		return iud.get(username);
	}

	@Override
	public boolean check(String username, String password) throws Exception {
		boolean  check = false;
		IUserDao iud = DaoFactory.getUserDao();
		userValue uv = iud.get(username);
		
		if(uv!= null){
			if(uv.getPassword().equals(password))
				check=true;
		}
	
		return check;
	
	}

	@Override
	public void add(String username, String password, String power, int age,
			String sex)
			throws Exception {
		userValue uv = new  userValue();
		uv.setUsername(username);
		uv.setPassword(password);
		uv.setPower(power);
		uv.setAge(age);
		uv.setSex(sex);
		
		IUserDao iud = DaoFactory.getUserDao();
		iud.create(uv);
		
	}

	@Override
	public void modify(String username, String password, String power, int age,
			String sex)
			throws Exception {
		IUserDao iud = DaoFactory.getUserDao();
		userValue uv = iud.get(username);
		uv.setUsername(username);
		uv.setPassword(password);
		uv.setAge(age);
		uv.setSex(sex);
		
		iud.update(uv);
		
	}


}
