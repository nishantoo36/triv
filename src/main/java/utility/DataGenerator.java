package utility;

import java.util.Date;
public class DataGenerator {

	public static int getRandomNumber() {
        int unique_id= (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        return unique_id;
	}
	
	public static String emailGenerator() {
		return "Test"+getRandomNumber() + "@mailinator.com";
	}
	
}
