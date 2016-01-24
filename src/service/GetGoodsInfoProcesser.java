package service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;

public class GetGoodsInfoProcesser extends BaseDao implements IProcess{
	boolean	isGoodsExist(Map<String, String> map){
		Map<String, String> m=super.quryBySql1("select count(*) as count from goods where goods_ecode='"+map.get("goods_ecode")+"'");

		if(m.get("count").equals("0")){
			//查无此货
			return false;
		}
		else{
			return true;

		}
	}
	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		Map<String,String>mm=new HashMap<String, String>();
		JSONArray ja=new JSONArray();

		if(!isGoodsExist(map)){
			//查无此货
			mm.put("result", false+"");
			mm.put("resultCode","1");
			mm.put("info","没有此商品信息");
			ja.put(super.toJSON(mm));
		}
		else{
			String sql="select * from goods,shop where shop.shopid=goods.shopid and goods_ecode='"+map.get("goods_ecode")+"' ";

			Map<String,String> mp=super.quryBySql1(sql);
			mm.put("result", true+"");
			mm.put("resultCode","0");
			ja.put(super.toJSON(mm));
			ja.put(super.toJSON(mp));
			

		}
		
		return ja;


	}

}
