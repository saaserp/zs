package service;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;
/***
 * 
 * @author anonymous
 *注册成功后，会给出[{"result":true,"id":5,"info":"注册成功"}]
 *失败后，只给[{"result":false,"info":"失败原因"}]
 */
public class RegesterProcesser extends BaseDao implements IProcess{
	
	boolean isPhoneExits(String phone){
		Map<String, String> m=super.quryBySql1("select count(*) as count from user where phone='"+phone+"'");
		if(m.get("count").equals("0")){
			//查无此人
			return false;
		}
		else
			return true;
	}
	int regist(String phone,String nickname,String password){
		String sql="insert into user(phone,nickname,password) values('"+phone+"','"+nickname+"','"+password+"')";
		return super.updateBySqlandGetRowId(sql);
	}
	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		//if phone contains
		//if phone is not contains ,then let it roll in
		//tell him the result,true or false
		JSONObject jo=new JSONObject();
		try {
			if(!isPhoneExits(map.get("id"))){
				
				int result=regist(map.get("id"),"",map.get("password"));
				if(result==-1){
					//注册失败
					jo.put("info", "服务器繁忙，清稍候再注册");
					jo.put("result", false);
				}else{
					//注册成功
					jo.put("info", "注册成功");
					jo.put("result", true);
					jo.put("id", result);//把注册记录的id返给用户
				}
				
				
			}else
			{
				jo.put("result", false);
				jo.put("info", "用户已存在");
				jo.put("resultCode",1);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray ja=new JSONArray();
		ja.put(jo);
		
		return ja;
	}

}
