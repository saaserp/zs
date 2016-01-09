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
		
		String sql="select goodsid as goodsID," +
				"goodsname as goodsName," +
				"price,unit from ";
		
		
		return null;
	}

}
