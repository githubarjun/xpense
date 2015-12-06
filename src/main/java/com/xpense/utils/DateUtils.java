package com.xpense.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DD_MMM_YYYY = "dd-MMM-yyyy";

	public static Date toDate(String strDate,String format){
		if(strDate != null && !"".equals(strDate.trim())){
			if(format == null){
				format = DD_MMM_YYYY;
			}
			Date convertedDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			try {
				convertedDate = dateFormat.parse(strDate);
				return convertedDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String toString(Date date,String format){
		String convertedString = null;
		if(date != null){
			if(format == null){
				format = DD_MMM_YYYY;
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			convertedString = dateFormat.format(date);
		}
		return convertedString;
	}
}
