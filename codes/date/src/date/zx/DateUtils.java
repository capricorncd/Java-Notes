package date.zx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * compare date
	 * @param dateStr1
	 * @param dateStr2
	 * @param format
	 * @param type 
	 * @return boolean
	 * @throws ParseException
	 */
	public static boolean compareDate(String dateStr1, String dateStr2, String format, String type)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date1 = (Date) sdf.parse(dateStr1);
		Date date2 = (Date) sdf.parse(dateStr2);
		int result = date1.compareTo(date2);
		switch (type.toUpperCase()) {
		case "EQ":
			return result == 0;
		case "NEQ":
			return result != 0;
		case "GT":
			return result == 1;
		case "EGT":
			return result >= 0;
		case "LT":
			return result == -1;
		case "ELT":
			return result <= 0;
		}
		return false;
	}
	
	/**
	 * compareDateEGT
	 * @param dateStr1
	 * @param dateStr2
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static boolean compareDateEGT(String dateStr1, String dateStr2, String format)
			throws ParseException {
		return compareDate(dateStr1, dateStr2, format, "EGT");
	}
	
	public static boolean compareDateMillisecond(String dateStr1, String dateStr2, String format, String type)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date1 = (Date) sdf.parse(dateStr1);
		Date date2 = (Date) sdf.parse(dateStr2);
		long beginMsec = date1.getTime();
		long endMsec = date2.getTime();
		switch (type.toUpperCase()) {
		case "EQ":
			return beginMsec == endMsec;
		case "NEQ":
			return beginMsec != endMsec;
		case "GT":
			return beginMsec > endMsec;
		case "EGT":
			return beginMsec >= endMsec;
		case "LT":
			return beginMsec < endMsec;
		case "ELT":
			return beginMsec <= endMsec;
		}
		return false;
	}
}
