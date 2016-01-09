package networks;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;

import service.GetGoodsInfoProcesser;
import service.LoginProcesser;
import service.RegesterProcesser;


public class Mediator extends BaseDao{
	String cmd;
	String jsonStr;
	IProcess p;
	public Mediator(String cmd,String jsonStr){
		this.cmd=cmd;
		 
		this.jsonStr=jsonStr;
		switch(cmd){
		case "LoginProcesser":
			p=new LoginProcesser();
			break;
		case "RegesterProcesser":
			p=new RegesterProcesser();
			break;
		case "GetGoodsInfoProcesser":
			p=new GetGoodsInfoProcesser();
			break;
			}
	}

	public  JSONArray process(){
		JSONArray jsa = null;
		try {
			  jsa=new JSONArray(jsonStr);
			 
		} catch (JSONException e) {
			 
			e.printStackTrace();
		}	 
		
		return p.processer(super.toMap(jsa.toString()));		
	}
}
