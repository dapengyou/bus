package com.city.bus.dao;

import java.util.List;

import com.city.bus.value.userValue;

public interface IUserDao {
	//创建
		public void create(userValue uv) throws Exception;
		//更新
		public void update(userValue uv) throws Exception;
		//删除
		public void delete(userValue uv) throws Exception;
		//获得指定
		public userValue get(String username) throws Exception;
		//获取列表
		public List<userValue> getList() throws Exception;
}
