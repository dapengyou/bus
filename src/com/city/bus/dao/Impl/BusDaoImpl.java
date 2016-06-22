package com.city.bus.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bus.dao.IBusDao;
import com.city.bus.factory.ConnectionFactory;
import com.city.bus.value.busValue;
import com.city.bus.value.powerValue;

public class BusDaoImpl implements IBusDao{

	@Override
	public void create(busValue bv) throws Exception {
		String sql = "insert into stationline(stationId,stationA,stationB,startTime,endTime) values(?,?,?,?,?)";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, bv.getStationId());
			ps.setString(2, bv.getStationA());
			ps.setString(3, bv.getStationB());
			ps.setString(4, bv.getStartTime());
			ps.setString(5, bv.getEndTime());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void update(busValue bv) throws Exception {
		String sql = "update stationline set stationA=?,stationB=?,startTime=?,endTime=? where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(5, bv.getStationId());
			ps.setString(1, bv.getStationA());
			ps.setString(2, bv.getStationB());
			ps.setString(3, bv.getStartTime());
			ps.setString(4, bv.getEndTime());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public void delete(busValue bv) throws Exception {
		String sql = "delete from stationline where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, bv.getStationId());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		
	}

	@Override
	public busValue get(String stationId) throws Exception {
		busValue bv = null;
		String sql = "select * from stationline where stationId=?";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, stationId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				bv = new busValue();
				bv.setStationId(rs.getString("stationId"));
				bv.setStationA(rs.getString("stationA"));
				bv.setStationB(rs.getString("stationB"));
				bv.setStartTime(rs.getString("startTime"));
				bv.setEndTime(rs.getString("endTime"));
				
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("信息Dao添加错误"+e.getMessage());
		}finally{
			cn.close();
		}
		return bv;
	}

	@Override
	public List<busValue> getList() throws Exception {
		List<busValue> empList = new ArrayList();
		String sql = "select * from stationline";
		Connection cn = null;
		try {
			cn = ConnectionFactory.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				busValue bv = new busValue();
				
				bv.setStationId(rs.getString("stationId"));
				bv.setStationA(rs.getString("stationA"));
				bv.setStationB(rs.getString("stationB"));
				bv.setStartTime(rs.getString("startTime"));
				bv.setEndTime(rs.getString("endTime"));
				empList.add(bv);
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
