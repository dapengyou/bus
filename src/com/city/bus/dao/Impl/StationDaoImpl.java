package com.city.bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bus.dao.IStationDao;
import com.city.bus.factory.ConnectionFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.stationValue;

public class StationDaoImpl implements IStationDao{

	@Override
	public void create(stationValue sv) throws Exception {
		String sql = "insert into station(stationId,station,startTime,endTime) values(?,?,?,?)";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sv.getStationId());
			ps.setString(2, sv.getStation());
			ps.setString(3, sv.getStartTime());
			ps.setString(4, sv.getEndTime());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void update(stationValue sv) throws Exception {
		String sql = "update station set station=?,startTime=?,endTime=? where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(4, sv.getStationId());
			ps.setString(1, sv.getStation());
			ps.setString(2, sv.getStartTime());
			ps.setString(3, sv.getEndTime());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void delete(stationValue sv) throws Exception {
		String sql = "delete from station where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sv.getStationId());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public stationValue get(String stationId) throws Exception {
		stationValue sv = null;
		String sql = "select * from station where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, stationId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sv = new stationValue();
				sv.setStationId(rs.getString("stationId"));
				sv.setStation(rs.getString("station"));
				sv.setStartTime(rs.getString("startTime"));
				sv.setEndTime(rs.getString("endTime"));
				
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		return sv;
	}

	@Override
	public List<stationValue> getList() throws Exception {
		List<stationValue> empList = new ArrayList();
		String sql = "select * from station";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				stationValue sv = new stationValue();
				
				sv.setStationId(rs.getString("stationId"));
				sv.setStation(rs.getString("station"));
				sv.setStartTime(rs.getString("startTime"));
				sv.setEndTime(rs.getString("endTime"));
				empList.add(sv);
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
