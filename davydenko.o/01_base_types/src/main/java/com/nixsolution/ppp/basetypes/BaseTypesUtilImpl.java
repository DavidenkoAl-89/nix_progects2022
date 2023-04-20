package com.nixsolution.ppp.basetypes;

import com.nixsolutions.ppp.basetypes.BaseTypesUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;


public class BaseTypesUtilImpl implements BaseTypesUtil {
    @Override
    public String toggleScientificNotation(String str) {
        String regex = "^-?[0-9.]+$";
        if (str == null || str.equals("")) {
            return "String param is null.";
        } else if (str.matches(regex)) {
            BigDecimal bigDecimal = new BigDecimal(str);
            DecimalFormat decimalFormat = new DecimalFormat("0.00E00");
            return decimalFormat.format(bigDecimal.doubleValue());
        } else {
            return new BigDecimal(str).toPlainString();
        }
    }
    @Override
    public int[] sort(int[] ints) {
        int[] newInts = Arrays.copyOf(ints, ints.length);
        for (int i = newInts.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (newInts[j] > newInts[j + 1]) {
                    int tmp = newInts[j];
                    newInts[j] = newInts[j + 1];
                    newInts[j + 1] = tmp;
                }
            }
        }
        return newInts;
    }
    @Override
    public float arithmeticMean(int[] ints) {
        float average = 0;
        if (ints.length > 0) {
            float sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            average = sum / ints.length;
        }
        return average;
    }
    @Override
    public String format(double n, String language) {
        Locale fmtLocale = Locale.forLanguageTag(language);
        NumberFormat formatter = NumberFormat.getInstance(fmtLocale);
        return formatter.format(n);
    }
    @Override
    public String plus(String value1, String value2) {
        BigDecimal firstValue = new BigDecimal(value1);
        BigDecimal secondValue = new BigDecimal(value2);
        BigDecimal result = firstValue.add(secondValue);
        return String.valueOf(result);
    }
    @Override
    public String minus(String value1, String value2) {
        BigDecimal firstValue = new BigDecimal(value1);
        BigDecimal secondValue = new BigDecimal(value2);
        BigDecimal result = firstValue.subtract(secondValue);
        return String.valueOf(result);
    }
    @Override
    public String mul(String value1, String value2) {
        BigDecimal firstValue = new BigDecimal(value1);
        BigDecimal secondValue = new BigDecimal(value2);
        BigDecimal result = firstValue.multiply(secondValue);
        return String.valueOf(result);
    }
    @Override
    public String div(String value1, String value2) {
        BigDecimal firstValue = new BigDecimal(value1);
        BigDecimal secondValue = new BigDecimal(value2);
        BigDecimal result = firstValue.divide(secondValue, 25, RoundingMode.CEILING);
        return String.valueOf(result);
    }
}

