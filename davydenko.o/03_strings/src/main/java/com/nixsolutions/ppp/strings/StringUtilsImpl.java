package com.nixsolutions.ppp.strings;

public class StringUtilsImpl implements StringUtils {
    @Override
    public byte[] ip2Bytes(String ip) {
        byte[] byteArray = new byte[4];
        String ipStr = ip.trim();
        String[] ipArray = ipStr.split("\\.");
        for (String s : ipArray) {
            if (ipArray.length != 4) {
                return null;
            }
            if (Character.isAlphabetic(s.charAt(0))
                    || Character.isAlphabetic(s.charAt(s.length() - 1))) {
                return null;
            }
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                return null;
            }
        }
        for (int i = 0; i < ipArray.length; i++) {
            byteArray[i] = (byte) (Integer.parseInt(ipArray[i]));
        }
        return byteArray;
    }
    @Override
    public String convertIp(String ip) {
        String ipStr = ip.trim();
        StringBuilder sb = new StringBuilder();
        String[] ipArray = ipStr.split("\\.");
        for (String s : ipArray) {
            if (ipArray.length != 4) {
                return null;
            }
            if (Character.isAlphabetic(s.charAt(0))
                    || Character.isAlphabetic(s.charAt(s.length() - 1))) {
                return null;
            }
            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
                return null;
            }
            sb.append(String.format("%03d.", Integer.parseInt(s)));
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Override
    public StringBuilder alphabet() {
        StringBuilder sb = new StringBuilder();
        char[] alphabetChars = new char[26];
        for (int i = 0; i < alphabetChars.length; i++) {
            char c;
            if (i % 2 == 0) {
                c = (char) (97 + i);
            } else {
                c = (char) (65 + i);
            }
            sb.append(c);
        }
        return sb;
    }
    @Override
    public String[] uri2Array(String uri) {
        String[] uriArray = new String[8];
        String newStrUri;
        String schemaDelimiter = "://";
        String loginDelimiter = "@";
        String passwordAndPortDelimiter = ":";
        String anchorDelimiter = "#";
        String queryDelimiter = "?";
        String pathDelimiter = "/";

        if (uri.contains(schemaDelimiter)) {
            int index = uri.indexOf(schemaDelimiter);
            uriArray[0] = uri.substring(0, uri.indexOf(schemaDelimiter));
            uri = uri.substring(index + 3);
        }
        if (uri.contains(loginDelimiter)) {
            newStrUri = uri.substring(0, uri.indexOf(loginDelimiter));
            if (newStrUri.contains(passwordAndPortDelimiter)) {
                int index = newStrUri.indexOf(passwordAndPortDelimiter);
                uriArray[1] = newStrUri.substring(0, index);
                if (uriArray[1].isEmpty()) {
                    uriArray[1] = null;
                }
                uriArray[2] = newStrUri.substring(index + 1);
                if (uriArray[2].isEmpty()) {
                    uriArray[2] = null;
                }
            } else {
                uriArray[1] = newStrUri;
            }
            uri = uri.substring(uri.indexOf(loginDelimiter) + 1);
        }
        if (uri.contains(anchorDelimiter)) {
            int index = uri.indexOf(anchorDelimiter) + 1;
            uriArray[7] = uri.substring(index);
            uri = uri.substring(0, index - 1);
            if (uriArray[7].isEmpty()) {
                uriArray[7] = null;
            }
        }
        if (uri.contains(queryDelimiter)) {
            int index = uri.indexOf(queryDelimiter) + 1;
            uriArray[6] = uri.substring(index);
            uri = uri.substring(0, index - 1);
            if (uriArray[6].isEmpty()) {
                uriArray[6] = null;
            }
        }
        if (uri.contains(pathDelimiter)) {
            int index = uri.indexOf(pathDelimiter) + 1;
            uriArray[5] = uri.substring(index);
            uri = uri.substring(0, index - 1);
            if (uriArray[5].isEmpty()) {
                uriArray[5] = null;
            }
        }
        if (uri.contains(passwordAndPortDelimiter)) {
            int index = uri.indexOf(passwordAndPortDelimiter) + 1;
            uriArray[4] = uri.substring(index);
            uri = uri.substring(0, index - 1);
            if (uriArray[4].isEmpty()) {
                uriArray[4] = null;
            }
        }
        if (uri.isEmpty()) {
            uriArray[3] = null;
        } else {
            uriArray[3] = uri;
        }
        return uriArray;
    }
    @Override
    public String toCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String trimStr = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(trimStr.charAt(0));
        for (int i = 1; i < trimStr.length(); i++) {
            if (Character.isLetter(trimStr.charAt(i))) {
                sb.append(Character.toLowerCase(trimStr.charAt(i)));
            } else {
                if (Character.isLetter(trimStr.charAt(i + 1))) {
                    sb.append(Character.toUpperCase(trimStr.charAt(i + 1)));
                    i++;
                }
            }
        }
        return sb.toString();
    }
    @Override
    public String fromCamelCase(String camelStr) {
        if (camelStr == null || camelStr.isEmpty()) {
            return "";
        }
        String regex = "(?=\\p{Upper})";
        StringBuilder sb = new StringBuilder();
        String[] camelArray = camelStr.trim().split(regex);
        for (int i = 0; i < camelArray.length; i++) {
            if (i == 0) {
                sb.append(camelArray[i]);
            }
            if (i > 0) {
                sb.append(camelArray[i].toLowerCase());
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}

