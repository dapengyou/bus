package com.city.bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bus.dao.IUserDao;
import com.city.bus.factory.ConnectionFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.userValue;

public class UserDaoImpl implements IUserDao{

	@Override
	public void create(userValue uv) throws Exception {
		String sql = "insert into usertable(username,password,power,age,sex) values(?,?,?,?,?)";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, uv.getUsername());
			ps.setString(2, uv.getPassword());
			ps.setString(3, uv.getPower());
			ps.setInt(4, uv.getAge());
			ps.setString(5, uv.getSex());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
		
	}

	@Override
	public void update(userValue uv) throws Exception {
		String sql = "update usertable set password=?,power=?,age=?,sex=?where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(5,uv.getUsername());
			ps.setString(1, uv.getPassword());
			ps.setString(2, uv.getPower());
			ps.setInt(3,uv.getAge());
			ps.setString(4,uv.getSex());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void delete(userValue uv) throws Exception {
		String sql = "delete from usertable where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, uv.getUsername());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public userValue get(String username) throws Exception {
		userValue uv = null;
		String sql = "select * from usertable where username=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				uv = new userValue();
				uv.setUsername(rs.getString("username"));
				uv.setPassword(rs.getString("password"));
				uv.setPower(rs.getString("power"));
				uv.setAge(rs.getInt("age"));
				uv.setSex(rs.getString("sex"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		return uv;
	}

	@Override
	public List<userValue> getList() throws Exception {
		List<userValue> empList = new ArrayList();
		String sql = "select * from usertable";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userValue uv = new userValue();
				uv.setUsername(rs.getString("username"));
				uv.setPassword(rs.getString("password"));
				uv.setPower(rs.getString("power"));
				uv.setAge(rs.getInt("age"));
				uv.setSex(rs.getString("sex"));
				
				empList.add(uv);
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
