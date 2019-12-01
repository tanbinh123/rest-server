package com.mac.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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

	public static String toJson(Object object) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(object);
	}

}
