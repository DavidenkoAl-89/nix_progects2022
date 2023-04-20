package com.nixsolutions.ppp.strings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringUtilsImpl strings = new StringUtilsImpl();
        System.out.println("From cemalCase :  " + strings.fromCamelCase(" hWF"));
        System.out.println("To cemalCase : " + strings.toCamelCase(" hWF"));
        System.out.println("Alphabet: " + strings.alphabet());
        System.out.println("From IP to bytes: " + Arrays.toString(strings.ip2Bytes("  127.0.0.255 ")));

        System.out.println("From String to IP: " + strings.convertIp(""));
        System.out.println("URL : " +
                Arrays.toString(strings.uri2Array("ftp://1.2.3.4:25/pass0/pass1/pass2?a=1&b=2#anchor")));

    }
}
