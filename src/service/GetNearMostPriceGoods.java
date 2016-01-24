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

public class GetNearMostPriceGoods extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
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
		  sql="select * from goods,shop,unit,class where goods.shopid=shop.shopid and class.classid=goods.classid and class.unitid=unit.unitid and shop.shopid="+p.getId();
		 
		  	tmp=toJSON(super.quryBySql2(sql));
		  	if(tmp!=null){
		  	if(tmp.length()!=0){
		  		 for(int j=0;j<tmp.length();j++){
		  			 try {
		  				double distance=i.getDistance(p);
		  				 double rule[]={100,200,300,500,1000,2000,4000,50000,60000,70000,100000};
		  				 for(double r:rule){
		  					 if(distance<r){
		  						 distance=r;
		  						 break;
		  					 }
		  				 }
						t_jo=tmp.getJSONObject(j);
						t_jo.put("distance",distance );
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
