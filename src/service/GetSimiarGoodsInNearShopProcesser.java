package service;

import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;

public class GetSimiarGoodsInNearShopProcesser extends BaseDao implements IProcess{

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		String goodsName=map.get("goodsName");
		String currentShopID=map.get("currentShopID");
		
		String sql="select   goodsid as goodsID,goodsname as goodsName,price,unitname as unit,shop.shopid as shopid from goods,shop,unit,class where goods.shopid=shop.shopid and goods.classid=class.classid and class.unitid=unit.unitid where goodsname like '%"+goodsName+"%' and shop.shopid!='"+currentShopID+"'";
		 
		 
		return toJSON(super.quryBySql2(sql));
		
	}

}
