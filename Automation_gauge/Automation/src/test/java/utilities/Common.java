package utilities;

import com.github.javafaker.Faker;
import gov.tams.common.CommonProperties;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author erlan.beisen
 * August, 8 2019
 * Browser actions
 */
public final class Common {

    private static Logger logger;
    private static Faker faker;
    private static Robot robot;

    private Common() {}

    static { init(); }

    private static void init () {
        logger = logger == null ? Logger.getLogger(Common.class) : logger;
        faker = faker == null ? new Faker(new Locale("en-US")) : faker;
    }

    /**
     * Stops Web Driver for seconds
     * @param seconds - seconds
     */
    public static void sleep ( int seconds ) {
        try {
            logger.info("Thread sleep for " + seconds + " seconds");
            Thread.sleep( 1000 * seconds );
        } catch ( InterruptedException e ) {
            logger.error(e.getMessage());
        }
    }

    /**
     * @author erlan.beisen
     * @param errorMessage - errorMessage
     */
    public static void failTest(String errorMessage ) {
        logger.error(errorMessage);
        Assert.fail(errorMessage);
    }

    /**
     * http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
     * @author erlan.beisen
     * @param dateFormat - dateFormat
     * @return Current date text
     */
    public static String getCurrentDate ( String dateFormat ) {
        Date date = Calendar.getInstance().getTime();
        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * @param dateFormat - dateFormat
     * @param days - days
     * @return - Today minus days
     */
    public static String getPastDate ( String dateFormat, int days ) {
        Date date = DateUtils.addDays(new Date(), -days);
        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * Ex.: changeDateFormat("8/1/2019, 4:01:43 PM", "M/d/yyyy, h:mm:ss a", "M/d/yyyy");
     * http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
     * @param date - date
     * @param oldFormat - oldFormat
     * @param newFormat - newFormat
     * @return - Formatted date text
     */
    public static String changeDateFormat ( String date, String oldFormat, String newFormat ) {
        String changedDateFormat;
        try {
            changedDateFormat = new SimpleDateFormat(newFormat).format(new SimpleDateFormat(oldFormat).parse(date));
        } catch ( ParseException e ) {
            String errorMessage = "Could not change date format from " + oldFormat + " to " + newFormat + " for " + date;
            logger.error(errorMessage);
            changedDateFormat = errorMessage;
        }
        logger.info(date + " date format is changed from " + oldFormat + " to " + newFormat);
        return changedDateFormat;
    }

    public static String getRandomText ( int size, boolean isCharacter, boolean isNumber, boolean isSymbols ) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "~!@#$%^&*()_+{}[]|\\\"':;/?.>,<`";
        String numbers = "0123456789";

        if ( isCharacter ) stringBuilder1.append(characters);
        if ( isSymbols ) stringBuilder1.append(symbols);
        if ( isNumber ) stringBuilder1.append(numbers);

        if ( size < 0 || size > stringBuilder1.length() ) {
            String errorMessage = "Invalid size " + size + " for Random Text Generator\nSize should be > 0 && <= " + stringBuilder1.length();
            logger.error(errorMessage);
            failTest(errorMessage);
        }
        for ( int index = 0; index < size; index++ ) {
            int randomIndex = getRandomInt(0, stringBuilder1.length() - 1);
            stringBuilder.append(stringBuilder1.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

    public static int getRandomInt ( int min, int max ) {
        return (int)(Math.random() * (( max - min ) + 1 )) + min;
    }

    public static long getRandomLong ( long min, long max ) {
        return (long)(Math.random() * (( max - min ) + 1 )) + min;
    }

    public static double getRandomDouble ( double min, double max ) { return (Math.random() * (( max - min ) + 1 )) + min; }

    public static String formatDouble2D ( double number ) {
        return String.format("%.2f", number);
    }

    public static void keyboardKey ( int keyEvent ) {
        try {
            robot = robot == null ? new Robot() : robot;
        } catch (AWTException e) {
            logger.error(e.getMessage());
        }
        robot.keyPress(keyEvent);
        robot.keyRelease(keyEvent);
    }

    public static String getRandomFirstName () {
        return faker.name().firstName();
    }

    public static String getRandomLastName () {
        return faker.name().lastName();
    }

    public static String getRandomPhoneNumber () {
        return faker.phoneNumber().toString();
    }

    public static String getRandomAddress () {
        return faker.address().toString();
    }

    public static String getRandomCompany () {
        return faker.company().toString();
    }

    public static String getRandomState () {
        return faker.address().state();
    }

    public static String getRandomCity () {
        return faker.address().city();
    }

    public static String getRandomText ( int numberOfCharacters ) {
        if ( numberOfCharacters <= 0 ) {
            failTest("number of characters for random text can not be <= 0");
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isAddParagraph = true;
        while ( isAddParagraph ) {
            int randomTextLength = stringBuilder.append(faker.lorem().paragraph()).length();
            isAddParagraph = randomTextLength < numberOfCharacters;
        }
        return stringBuilder.substring(0, numberOfCharacters).replaceAll("\\s+", " ").trim();
    }

    public static String getUsCurrency ( double dollarAmount ) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(dollarAmount);
    }

    public static String getAbsoluteFilePath ( String relativeFilePath ) {
        relativeFilePath = relativeFilePath.startsWith("/") ? relativeFilePath : "/" + relativeFilePath;
        return CommonProperties.USER_DIR + relativeFilePath;
    }

    public static String getFileName ( String relativeFilePath ) {
        return Paths.get(getAbsoluteFilePath(relativeFilePath)).getFileName().toString();
    }
}