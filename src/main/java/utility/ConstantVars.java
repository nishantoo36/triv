package utility;

public class ConstantVars {
    public static String featureName;
    public static String screenshotPath = System.getProperty("user.dir").replaceAll("/triv", "") + "/screenshots/";
    public static String randomEmail = DataGenerator.emailGenerator();
}
