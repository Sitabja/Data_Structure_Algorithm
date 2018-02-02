package mapsql.sql.condition;

import java.util.Map;

import mapsql.sql.core.Field;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.TableDescription;
import mapsql.sql.field.CHARACTER;

public class Like extends AbstractCondition {
	private String column;
	private String value;
	
	public Like(String column, String value) {
		this.column = column;
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean evaluate(TableDescription description, Map<String, String> data) throws SQLException {
		Field field = description.findField(column);
		String tableValue = (String) field.toValue(data.get(column));
		String inputValue = (String)field.toValue(value);
		
		//if there are no wildcard characters if will compare the entire string
		if(inputValue.indexOf('%') == -1){
			return comparator.compare(inputValue, tableValue) == 0;
		} 
		//if there are two wildcard at the start and at the end
		if(inputValue.indexOf('%') != inputValue.lastIndexOf('%')){
			//if the substring is greater than the actualt string
			if(inputValue.length() - 2 > ((String)field.toValue(value)).length()){
				return false;
			}
			return tableValue.contains(inputValue.substring(1,inputValue.length()-1));
		}
		//if the substring is greater than the actualt string
		if(inputValue.length() - 1 > (tableValue).length()){
			return false;
		}
		//if the wildcard is at the start
		if(inputValue.indexOf('%') == 0){
			String endSubString = tableValue.substring(tableValue.length() - inputValue.length() +1);
			return comparator.compare(inputValue.substring(1), endSubString) == 0;
		}
		String startSubString = tableValue.substring(0 , inputValue.length()- 1 );
		// if the wild card is at the end
		return comparator.compare(inputValue.substring(0,inputValue.length() - 1), startSubString) == 0;
	}
}
