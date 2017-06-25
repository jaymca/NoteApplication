/**
 * 
 */
package com.note.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jay.prakash
 *
 */
public class DateUtil {
	
	public static Date convertStringToDate(String datein)
	{
		Date date = null;			
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        try
        {
            date = simpleDateFormat.parse(datein);
            System.out.println("date : "+simpleDateFormat.format(date));
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
		return date;	
	}
	
	public static String convertDateToString(Date date){
		Format formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		String s = formatter.format(date);
		return s;
	}

}
