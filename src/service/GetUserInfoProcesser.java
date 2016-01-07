package service;

import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;

public class GetUserInfoProcesser extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		String sql="select * from user where phone='"+map.get("id")+"' or uid='"+map.get("id")+"'";
		return super.toJSONArray(super.quryBySql1(sql));
	}

}
