package service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;

public class UpdateUserInfoProcesser  extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		String sql="update user set "+map.get("key")+"='"+map.get("value")+"' where uid="+map.get("userid");
		Map<String,String>mp=new HashMap<String,String>();
		
		if(super.updateBySql(sql)==1){
			mp.put("result", "true");
		}else
			mp.put("result", "false");
		return super.toJSONArray(mp);
	}

}
