package com.accesshq.utils;

import org.openqa.selenium.NotFoundException;

import java.text.NumberFormat;
import java.text.ParseException;

public class StringParser {
    public static Long KmsToLong(String kms) {
        kms = kms.split(" ")[0];
        try {
            return NumberFormat.getNumberInstance().parse(kms).longValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new NotFoundException();
    }
}
