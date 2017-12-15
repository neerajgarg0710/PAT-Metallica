package com.sapient.metallica.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetallicaUtil {

	public static Date parseDate(String strDate, String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
