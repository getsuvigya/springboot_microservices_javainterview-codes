package com.elutra.aai.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum ColumnEnums {
	PERSONNEL_NUMBER("personnelNumber"){

		@Override
		public List<String> convertValues(List<String> values) {
			// TODO Auto-generated method stub
			return values;
		}

	},
	FIRST_NAME("firstName"){

		@Override
		public List<String> convertValues(List<String> values) {
			// TODO Auto-generated method stub
			return values;
		}
		
		
	},
	LAST_NAME("lastName"){

		@Override
		public List<String> convertValues(List<String> values) {
			// TODO Auto-generated method stub
			return values;
		}
		
	},
	DATE_OF_BIRTH("dob"){
		@Override
		public List<Date> convertValues(List<String> values) throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			List<Date> dates = new ArrayList<Date>();
			for(String value : values){
				dates.add(dateFormat.parse(value));
			}
			return dates;
		}
	},
	EMAIL("email"){
		@Override
		public List<String> convertValues(List<String> values) {
			// TODO Auto-generated method stub
			return values;
		}
	},
	GENDER("gender"){
		@Override
		public List<String> convertValues(List<String> values) {
			// TODO Auto-generated method stub
			return values;
		}
	};
	ColumnEnums(String name){
		columnName = name;
	}
	public abstract List<? extends Object> convertValues(List<String> values) throws ParseException;
	private final String columnName;
	public String getColumnName(){
		return this.columnName;
	}
	
}
