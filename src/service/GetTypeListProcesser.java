package service;

import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;

public class GetTypeListProcesser extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		String sql="select * from class where fatherid=0";
		 
		return super.toJSON(super.quryBySql2(sql));
	}

}
