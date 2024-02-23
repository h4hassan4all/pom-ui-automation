package utils;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Utils {
    public static void main(String[] args) {
        System.out.println(getRandomPackage());
    }

    public static String getElementFromPropertiesFile(String key, String filename){
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/" + filename + ".properties");
            property.load(file);
        } catch (IOException exception) {
            System.out.println("Something gone wrong in Utils. getElementFromPropertiesFile " + exception.getMessage());
        }
        return property.getProperty(key);
    }
    public static String getRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 1; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            if(i==1){
                sb.append(CHARACTERS.toUpperCase().charAt(index));
            }
            sb.append(CHARACTERS.toLowerCase().charAt(index));
        }

        return sb.toString();
    }
    public static int getRandomNumber ( int lowerBoundary, int upperBoundary) {

        //Generate random int value from lowerBoundary (e.g. 50 ) to upperBoundary (e.g. 100)
        int random_int = (int)Math.floor(Math.random()*(upperBoundary-lowerBoundary+1)+lowerBoundary);
        return random_int;
    }
    public static String generateRandomAmericanPhoneNumber(int count) {
        Random rand = new Random();
        String phoneNumber="";
        for (int i = 0; i < count; i++) {
            // Generate the area code (3 digits)
            int areaCode = rand.nextInt(800) + 200; // Random area code between 200 and 999

            // Generate the central office code (3 digits)
            int centralOfficeCode = rand.nextInt(800) + 200; // Random central office code between 200 and 999

            // Generate the line number (4 digits)
            int lineNumber = rand.nextInt(9000) + 1000; // Random line number between 1000 and 9999

            // Format and print the phone number as (XXX) XXX-XXXX
            phoneNumber = String.format("(%03d) %03d-%04d", areaCode, centralOfficeCode, lineNumber);
        }
        return "+1"+phoneNumber;
    }
    public static String getRandomPackage(){
            String[] stringsArray = {"STANDARD", "PREMIUM", "GOLD"};
            Random random = new Random();
            int randomIndex = random.nextInt(stringsArray.length);
            return stringsArray[randomIndex];
    }
    public static Boolean getRandomBoolean(){
        Random rd = new Random(); // creating Random object
        return rd.nextBoolean(); // displaying a random boolean
    }
    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return formatDate(currentDate);
    }
    public static String addDaysToCurrentDate(int daysToAdd) {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(daysToAdd);
        return formatDate(newDate);
    }
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
