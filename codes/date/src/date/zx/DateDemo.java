package date.zx;

import java.text.ParseException;

/**
 * 
 * @author capricorncd
 *
 */
public class DateDemo {

	public static void main(String[] args) throws ParseException {
		String dateStr1 = "2019-10-05";
		String dateStr2 = "2019-10-05 15:00:02";
		System.out.println(DateUtils.compareDateEGT(dateStr1, dateStr2.substring(0, 10), "yyyy-MM-dd"));
		System.out.println(DateUtils.compareDateMillisecond(dateStr1, dateStr2.substring(0, 10), "yyyy-MM-dd", "EGT"));
	}
	
}
