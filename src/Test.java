import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import service.GetGoodsInfoProcesser;


public class Test {
	public static void main(String args[]) throws JSONException{
		//		LoginProcesser p = new LoginProcesser();
		//	      Map<String,String> map=new HashMap<String, String>();
		//			map.put("id", "2") ;
		//			map.put("password","2222");
		//			System.out.print(p.processer(map));

//		RegesterProcesser g=new RegesterProcesser();
//		Map<String,String> map=new HashMap<String, String>();
//		map.put("phone", "13407138971");	 
//		System.out.print(g.processer(map));
		
		
//		GetUserInfoProcesser u=new GetUserInfoProcesser();
//		Map<String,String> map=new HashMap<String, String>();
//		map.put("id", "1");	
//		System.out.print(u.processer(map));
		
		GetGoodsInfoProcesser i=new GetGoodsInfoProcesser();
		Map<String,String> map=new HashMap<String, String>();
		map.put("goods_ecode", "0001");	
		System.out.print(i.processer(map));
		
	}

}
