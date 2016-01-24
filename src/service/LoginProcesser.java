package service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;

public class LoginProcesser extends BaseDao implements IProcess{
	//  int resultCode=0;//0 is sucess,1 has no sign in ,3 is password error,4 is net work error,5 is server errer

	int resultCode=0;
	Map<String,String> login(String id,String password){
		String sql="select * from user where uid='"+id+"' or phone="+id+" and password='"+password+"'";
		List<Map<String, String>> list=super.quryBySql2(sql);
		if(list!=null)
			return list.get(0);
		else
			return null;
	}
	boolean isIdExist(String id){
		String sql="select count(*) as count from user where uid='"+id+"' or phone="+id;
		Map<String,String> map=super.quryBySql1(sql );
		if(map.get("count").equals("0"))
			return false;

		return true;

	}
	@Override
	public JSONArray processer(Map<String, String> jsonStr)   {
		// TODO Auto-generated method stub
		JSONArray jsa=new JSONArray();
		JSONObject jo=new JSONObject();
		if(!isIdExist(jsonStr.get("id").toString())){
			try {
				jo.put("result", false);
				jo.put("info", "用戶不存在");
				jo.put("resultCode",1);
				jsa.put(jo);
				
				return jsa;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		Map<String ,String> map=login(
				jsonStr.get("id").toString(), 
				jsonStr.get("password").toString()
				);
		
		boolean result=map==null?false:true;
		try {
			jo.put("result",result);
			jo.put("info", "登录成功");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsa.put(jo);
		if(result==true){
			//login is ok
			jo=super.toJSON(map);
			jsa.put(jo);
		}
		else{
			//login faild
			try {
				jo.put("info", "登录密码错误");
				jo.put("resultCode", 3);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return jsa;







	}
}
