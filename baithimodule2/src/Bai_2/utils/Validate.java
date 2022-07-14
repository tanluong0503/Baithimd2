package Bai_2.utils;

import java.util.regex.Pattern;

public class Validate {
    public static final String FULLNAME = "^([A-Z]+[a-z]+[ ]?)+$";
    public static final String GENDER = "^(Nam|Nữ|Khác)$";
    public static final String ADDRESS = "^(([A-Z]|[a-z]|[0-9])+[,]?[ ]?)+$";

    public static boolean fullNameValid(String name) {
        return Pattern.compile(FULLNAME).matcher(name).matches();
    }

    public static boolean addressValid(String name) {
        return Pattern.compile(ADDRESS).matcher(name).matches();
    }

    public static boolean genderValid(String name) {
        return Pattern.compile(GENDER).matcher(name).matches();
    }
}
