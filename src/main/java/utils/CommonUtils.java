package utils;

import java.util.Date;

public class CommonUtils {
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIME = 20;
	public static final int EXPICIT_WAIT_TIME = 20;
	public String generateEmail() {
	Date d = new Date();
	return "prasad" + d.toString().replace(" ", "").replace(":", "") + "@gmail.com";
}
}
