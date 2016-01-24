package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import base.BaseDao;
import base.IProcess;
import base.MyPoint;

public class GetSimiarGoodsInNearShopProcesser extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		 
		
		//String sql="select goodsid as goodsID,goodsname as goodsName,price,unitname as unit,shop.shopid  as shopid,shopname as shopName,goods.pic from goods,shop,unit,class where goods.shopid=shop.shopid and goods.classid=class.classid and class.unitid=unit.unitid and  goods.goodsname like '%"+map.get("goodsName")+"%' and shop.shopid!='"+map.get("currentShopID")+"'";
		 	 
		// TODO Auto-generated method stub
				double x=Double.parseDouble(map.get("x"));
				double y=Double.parseDouble(map.get("y"));
				
				MyPoint i=new MyPoint(0,x,y);
				List<MyPoint>around=new ArrayList<MyPoint>();
				String sql_all_shops="select shopid,longitude,latitude from shop";
				List<Map<String,String>>list=super.quryBySql2(sql_all_shops);
				for(Map<String,String>m:list){
					around.add(new MyPoint(Integer.parseInt(m.get("shopid")),Double.parseDouble(m.get("longitude")),Double.parseDouble(m.get("latitude"))));
				}
				List<MyPoint>arr=i.getNearPoint(around, around.size());
				JSONArray result = new JSONArray();
				JSONArray tmp = new JSONArray();
				JSONObject t_jo=new JSONObject();
				String sql;
				for(MyPoint p:arr){
				  sql="select * from goods,shop,unit,class where goods.shopid=shop.shopid and class.classid=goods.classid and class.unitid=unit.unitid and shop.shopid="+p.getId();//and goods.goodsname like '%"+map.get("goodsname")+"%'";
				 
				  	tmp=toJSON(super.quryBySql2(sql));
				  	if(tmp!=null){
				  	if(tmp.length()!=0){
				  		 for(int j=0;j<tmp.length();j++){
				  			 try {
				  				
								t_jo=tmp.getJSONObject(j);
								t_jo.put("distance", i.getDistance(p));
								result.put(t_jo);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  		 }
				  	}
				  	}
				}
				
				return result;
				
		
	}

}
