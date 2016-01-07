package base;

 

import java.sql.ResultSet;

import org.json.JSONObject;



public interface IRowMapper {
	public Model mappingRow(ResultSet rs);

	public JSONObject mappingRow(Model md);
}
