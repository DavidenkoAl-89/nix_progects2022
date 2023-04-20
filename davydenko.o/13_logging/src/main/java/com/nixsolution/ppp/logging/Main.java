package com.nixsolution.ppp.logging;



import static com.nixsolutions.ppp.exceptions.OneMessageFileLogger.MESSAGE_STARTS_WITH;

public class Main {
    public static void main(String[] args) {

        String validMassage = MESSAGE_STARTS_WITH + "valid massage!";
        String notValidMassage = "Not valid massage!";
        String fileAbsolutePath = "/home/NIX/davydenko-o/davydenko.o/13_logging/src/main/java/File.txt";
        SaverImpl saver = new SaverImpl();
        OneMessageFileLoggerImpl oneMessageFileLogger =  new OneMessageFileLoggerImpl(fileAbsolutePath);
        saver.save(validMassage,fileAbsolutePath);
    }
}


