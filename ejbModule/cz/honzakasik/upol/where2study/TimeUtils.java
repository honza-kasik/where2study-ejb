package cz.honzakasik.upol.where2study;

import java.time.LocalTime;
import java.util.Calendar;

/**
 * Util class for handling time related tasks
 */
public class TimeUtils {
	
	/**
	 * Converts time string to {@link LocalTime} object
	 * @param time time in format hh:mm
	 * @return {@link LocalTime} object
	 */
	public static LocalTime timeStringToLocalTime(String time) {
		String[] values = time.split(":");
		return LocalTime.of(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
	}
	
	/**
	 * Converts day to number. Moday = 1....
	 * @param day string in czech language. E.g. "Pondělí"
	 * @return value from 1 to 7
	 */
	public static int czechStringToDayOfWeek(String day) {
		switch (day) {
			case "Pondělí":
				return 1;
			case "Úterý":
				return 2;
			case "Středa":
				return 3;
			case "Čtvrtek":
				return 4;
			case "Pátek":
				return 5;
			case "Sobota":
				return 6;
			case "Neděle":
				return 7;
			default:
				return -1;
		}
	}
	
	/**
	 * Get current day of week as integer
	 * @return day of week as integer
	 */
	public static int getDayOfWeekToday() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
	}

}
