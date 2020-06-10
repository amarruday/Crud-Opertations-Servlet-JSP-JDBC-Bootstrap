package com.ims.utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DateUtility {
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String TimeStampToDate(Timestamp ts) {
		int day = ts.getDate();
		int month = ts.getMonth();
		month += 1;
		int year = ts.getYear() + 1900;
		String date = day +"/" + month + "/" + year;
		return date;
	}
}
