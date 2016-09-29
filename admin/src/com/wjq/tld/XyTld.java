package com.wjq.tld;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XyTld {
	public static String dataformat(Date date,String pattern){
		String dateString = new SimpleDateFormat(pattern).format(date);
		return dateString;
	}
}
