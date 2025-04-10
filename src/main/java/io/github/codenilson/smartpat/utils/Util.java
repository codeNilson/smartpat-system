package io.github.codenilson.smartpat.utils;

public class Util {
    public static String cleanString(String str) {
        if (str == null)
            return null;
        return str.trim().toLowerCase();
    }
}
