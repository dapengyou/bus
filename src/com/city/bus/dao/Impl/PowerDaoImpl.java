package com.city.bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bus.dao.IPowerDao;
import com.city.bus.factory.ConnectionFactory;

import com.city.bus.value.powerValue;

public class PowerDaoImpl implements IPowerDao{

	@Override
	public void create(powerValue pv) throws Exception {
		String sql = "insert into powertable(username,password,power) values(?,?,?)";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pv.getUsername());
			ps.setString(2, pv.getPassword());
			ps.setString(3, pv.getPower());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
 		
	}

	@Override
	public void update(powerValue pv) throws Exception {
		String sql = "update powertable set password=?,power=? where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(3, pv.getUsername());
			ps.setString(2, pv.getPassword());
			ps.setString(1, pv.getPower());
			ps.executeUpdate();
			
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
	}

	@Override
	public void delete(powerValue pv) throws Exception {
		String sql = "delete from powertable where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pv.getUsername());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public powerValue getpowerValue(String username) throws Exception {
		powerValue pv = null;
		String sql = "select * from powertable where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				pv = new powerValue();
				String user = rs.getString("username");
				pv.setUsername(user);
				
				String pass = rs.getString("password");
				
				pv.setPassword(pass);
				pv.setPower(rs.getString("power"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		return pv;
	
	}

	@Override
	public List<powerValue> getList() throws Exception {
		List<powerValue> empList = new ArrayList();
		String sql = "select * from powertable";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				powerValue pv = new powerValue();
				String user =rs.getString("username");
				pv.setUsername(user);
				String pass = rs.getString("password");
				pv.setPassword(pass);
				pv.setPower(rs.getString("power"));
				empList.add(pv);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		return empList;
	}

}
