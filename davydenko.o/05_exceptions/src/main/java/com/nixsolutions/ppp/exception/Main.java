package com.nixsolutions.ppp.exception;

import static com.nixsolutions.ppp.exceptions.OneMessageFileLogger.MESSAGE_STARTS_WITH;

public class Main {
    public static void main(String[] args) {
        String validMassage = MESSAGE_STARTS_WITH + "valid massage!";
        String notValidMassage = "Not valid massage!";
        String fileAbsolutePath = "src/main/java/File.txt";
        SaverImpl saver = new SaverImpl();
        OneMessageFileLoggerImpl oneMessageFileLogger =  new OneMessageFileLoggerImpl(fileAbsolutePath);
        try {
            oneMessageFileLogger.log(validMassage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


