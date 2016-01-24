package service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;

public class UpdateGoodsInfoProcesser extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		String sql0="select count(*) as count from goods where goods_ecode='"+map.get("ercode")+"'";
		String sql1;
		if(super.quryBySql1(sql0).get("count").equals("0")){
			sql1="insert into goods(goods_ecode,goodsname,price,pic,classid,shopid,last_refeash_user) value('"+
					map.get("ercode")+"','"+
					map.get("goodsname")+"','"+
					map.get("price")+"','"+
					map.get("pic1")+"','"+map.get("classid")+"','"+
					map.get("shopid")+"','"+
					map.get("userid")+"')";
		}
		else
		{	String s="select goodsid from goods where goods_ecode='"+map.get("ercode")+"' order by last_refeash_time desc";
			String id;
			if((id=super.quryBySql1(s).get("goodsid"))!=null){
				sql1="update goods set goods_ecode='"+map.get("ercode")+"',goodsname='"+map.get("goodsname")+"',price='"+map.get("price")+"',pic='"+map.get("pic")+"',classid='"+map.get("classid")+"',shopid='"+map.get("shopid")+"',last_refeash_user='"+map.get("userid")+"'" +
						" where goodsid="+id;
				
			}else
				return null;
			
			
		}
		Map<String,String> map0=new HashMap<String,String>();
		map0.put("result",super.updateBySql(sql1)==1 ? "true":"false");
		return super.toJSONArray(map0);
		 
		
	}

}
