package com.accesshq.utils;

import java.text.NumberFormat;
import java.text.ParseException;

public class StringParser {

    public static Long KmsToLong(String kms) {
        Long result = null;
        try {
            result = NumberFormat.getNumberInstance().parse(kms).longValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}