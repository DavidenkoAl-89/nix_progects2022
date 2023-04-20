package com.nixsolution.ppp.logging;

import com.nixsolutions.ppp.exceptions.OneMessageFileLogger;
import com.nixsolutions.ppp.exceptions.Saver;
import java.io.IOException;

public class OneMessageFileLoggerImpl implements OneMessageFileLogger {
    String fileAbsolutePath;
    Saver saver;
    public OneMessageFileLoggerImpl() {
        this.saver = new SaverImpl();
    }
    public OneMessageFileLoggerImpl(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }
    public OneMessageFileLoggerImpl(String fileAbsolutePath, Saver saver) {
        this.fileAbsolutePath = fileAbsolutePath;
        this.saver = saver;
    }
    @Override
    public void log(String message) throws Exception {
        if (!message.startsWith(MESSAGE_STARTS_WITH)) {
            throw new MessageIsNotFormattedException(message);
        }
        try {
            saver.save(message, fileAbsolutePath);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}


