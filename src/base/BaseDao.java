package base;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseDao {

	protected DbConnection dbConn;

	public BaseDao() {
		dbConn = new DbConnection();
	}

	public int updateBySqlandGetRowId(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			conn = dbConn.getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			id = -1;
			e.printStackTrace();
		}
		finally {
			// dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}
		return id;

	}

	public boolean execPre(String sql) {
		Connection conn = null;
		CallableStatement statement = null;
		// String sql = "{call stu_proc(?)}";
		boolean isok = false;
		try {
			conn = dbConn.getConnection();

			statement = conn.prepareCall(sql);

			statement.executeUpdate();
			isok = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			isok = false;
		}
		finally {
			dbConn.closeStatment(statement);
			dbConn.closeConnection(conn);
		}
		return isok;

	}

	public int updateBySql(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;

		}
		finally {
			dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}

	}
	public Map<String,String> quryBySql1(String sql){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String,String> map=new HashMap<String,String>();
		boolean flag=false;
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			try{
				rs = stmt.executeQuery(sql);
			}catch(SQLException e){
				rs=null;
			}
			if(rs==null)
				return null;

			if(rs.next()) {
				flag=true;

				ResultSetMetaData rsm =rs.getMetaData(); 
				int col = rsm.getColumnCount(); 
				String colName;
				for(int i=0;i<col;i++){
					colName= rsm.getColumnName(i+1);
					map.put(colName,rs.getString(colName));
				}



			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		if(flag==true)
			return map;
		else
			return null;
	}
	public List<Map<String,String>> quryBySql2(String sql){
		Connection conn = null;
		Statement stmt = null;
	 
		ResultSet rs = null;
		List<Map<String,String>> retList=new ArrayList<>();;
		boolean flag=false;
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			 
			if(rs==null)
				return null;
			
			while (rs.next()) {
				flag=true;
				Map<String,String> map=new HashMap<String, String>();
				ResultSetMetaData rsm =rs.getMetaData(); 
				int col = rsm.getColumnCount(); 
				String colName;
				for(int i=0;i<col;i++){
					colName= rsm.getColumnName(i+1);
					map.put(colName,rs.getString(colName));
				}
				retList.add(map);


			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		if(flag==true)
			return retList;
		else
			return null;
	}
	public Connection getConn(){
		return dbConn.getConnection();

	}
	public List<Model>queryByCS(CallableStatement c,IRowMapper mapper){
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		List<Model> retList = new ArrayList<Model>();
		try{
			conn = dbConn.getConnection();
			cstmt=c;



			cstmt.execute();

			cstmt.getMoreResults();
			rs =cstmt.getResultSet();
			while (rs.next()) {
				Model obj = mapper.mappingRow(rs);
				retList.add(obj);
			}
		}catch(Exception e){

		}
		finally {

			dbConn.closeConnection(conn);
		}
		return retList;

	}

	public List<Model> queryBySql(String sql, IRowMapper mapper) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Model> retList = new ArrayList<Model>();
		try {
			conn = dbConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Model obj = mapper.mappingRow(rs);
				retList.add(obj);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbConn.closeStatment(stmt);
			dbConn.closeConnection(conn);
		}
		return retList;

	}
	//Map=>json
	public JSONObject toJSON(Map<String,String> map){
		JSONObject json=new JSONObject();
		if(map==null)
			return json;
		Set<String> keys=map.keySet();

		for(String key:keys){
			try {
				json.put(key, map.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return json;
	}
	public JSONArray toJSONArray(Map<String,String> map){
		JSONArray jsonarr=new JSONArray();
		if(map==null)
			return jsonarr;

		jsonarr.put(this.toJSON(map));
		return jsonarr;

	}
	public JSONArray toJSON(List<Map<String,String>> mlist){
		if(mlist==null){
			return null;
		}
		JSONArray jarray=new JSONArray();
		for(Map<String, String> j:mlist){
			jarray.put(this.toJSON(j));
		}
		return jarray;
	}
	public Map<String,String> toMap(String jsonstring){
		Map<String,String> map=new HashMap<String, String>();
		try {
			JSONArray jsonarray=new JSONArray(jsonstring);
			JSONObject j=jsonarray.getJSONObject(0);
			@SuppressWarnings("unchecked")
			Iterator<String> it=j.keys();

			while (it.hasNext()) {  
				String key = it.next();  
				String value = j.getString(key);  
				map.put(key, value);

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;



	}	 
	 public static boolean isWindowsOS(){
		    boolean isWindowsOS = false;
		    String osName = System.getProperty("os.name");
		    if(osName.toLowerCase().indexOf("windows")>-1){
		     isWindowsOS = true;
		    }
		    return isWindowsOS;
		  }
	public static String getLocalIP(){
	    String sIP = "";
	    InetAddress ip = null; 
	    try {
	     //如果是Windows操作系统
	     if(isWindowsOS()){
	      ip = InetAddress.getLocalHost();
	     }
	     //如果是Linux操作系统
	     else{
	      boolean bFindIP = false;
	      Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
	        .getNetworkInterfaces();
	      while (netInterfaces.hasMoreElements()) {
	       if(bFindIP){
	        break;
	       }
	       NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
	       //----------特定情况，可以考虑用ni.getName判断
	       //遍历所有ip
	       Enumeration<InetAddress> ips = ni.getInetAddresses();
	       while (ips.hasMoreElements()) {
	        ip = (InetAddress) ips.nextElement();
	        if( ip.isSiteLocalAddress()  
	                   && !ip.isLoopbackAddress()   //127.开头的都是lookback地址
	                   && ip.getHostAddress().indexOf(":")==-1){
	            bFindIP = true;
	               break;  
	           }
	       }

	      }
	     }
	    }
	    catch (Exception e) {
	     e.printStackTrace();
	    }

	    if(null != ip){
	     sIP = ip.getHostAddress();
	    }
	    return sIP;
	  }
}