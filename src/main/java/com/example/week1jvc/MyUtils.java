package com.example.week1jvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    public static Character getLastNameCharacter(String fullName) {//nguyen thi mai => i
        String[] nameValues = fullName.split("");
        return nameValues[nameValues.length - 1].charAt(0);
    }

    public static Character getFirstCharacterOfName(String fullName) { //nguyen thi mai => M
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[nameParts.length - 1];
        return firstName.charAt(0);
    }


    public static float parseFloat(String input) {
        return Float.parseFloat(String.format("%.2f", Float.parseFloat(input)));
    }

    public static int parseInt(String input) {
        try {
            float floatValue = Float.parseFloat(input);
            return (int) floatValue;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Không thể chuyển đổi chuỗi thành số nguyên: " + input);
        }
    }


    public static Date parseDate(String input, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);   //truyền format vào để chuyển sang định dạng mong muốn
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(input);
    }

    public static String parseDatetoString(Date input, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.format(input);
    }

    public static void checkMathScore(float mathScore, int studentType) {
        if (studentType == 2 && mathScore <= 7) {
            throw new RuntimeException("Điểm toán của học sinh chuyên toán phải lớn hơn 7!");
        }
    }

    public static void checkLiteratureScore(float literatureScore, int studentType) {
        if (studentType == 3 && literatureScore <= 7) {
            throw new RuntimeException("Điểm văn của học sinh chuyên văn phải lớn hơn 7!");
        }
    }
}
