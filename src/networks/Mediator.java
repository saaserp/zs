package networks;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;

import service.LoginProcesser;


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
