package com.javaweb.repository.utils;

public class StringUtil {
	public static boolean isnotBlank(String value) {
		if(value!=null&&!value.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNumber(Object value) {
		try {
			Long number = Long.parseLong(value.toString());
		}catch(Exception e ) {
			return false;
		}
		return true;
	}
	
}
