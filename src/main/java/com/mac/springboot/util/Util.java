package com.mac.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date parseDate(String dateInString) {
		if (dateInString == null)
			return null;

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {

			return formatter.parse(dateInString);

		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
