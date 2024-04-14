package com.sfjbv.formatter;

import com.sfjbv.form.MobileNumber;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MobileNumberFormatter implements Formatter<MobileNumber> {
    @Override
    public MobileNumber parse(String text, Locale locale) throws ParseException {
        MobileNumber mobileNumber = new MobileNumber();
        if (text.length() == 11) {
            mobileNumber.setCountryCode(text.substring(0, 1));
            mobileNumber.setNumber(text.substring(1, 11));
        } else if (text.length() == 12) {
            mobileNumber.setCountryCode(text.substring(0, 2));
            mobileNumber.setNumber(text.substring(2, 12));
        }
        return mobileNumber;
    }

    @Override
    public String print(MobileNumber object, Locale locale) {
        return object.getCountryCode() + object.getNumber();
    }
}
