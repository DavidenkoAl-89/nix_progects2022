package com.nixsolution.ppp.logging;

import com.nixsolutions.ppp.exceptions.Saver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;


public class SaverImpl implements Saver {
    private static final Logger LOG = LogManager.getLogger(SaverImpl.class);
    @Override
    public void save(String text, String fileAbsolutePath) {
        LOG.traceEntry();
        LOG.info("start of method execution");
        LOG.warn("exception, file can be absent");
        File file = new File(fileAbsolutePath);
        LOG.debug("create file {} ", file);
        try {
            if (!file.exists()) {
                LOG.info("File " + file + " created.");
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(text);
                    LOG.debug("writing to file");
                    LOG.info("File  " + file + " written successfully.");
                    LOG.traceExit();
                }
            } else {
                LOG.throwing(new FileAlreadyExistsException("The FileAlreadyExistsException, " + file + " already exist"));
            }
        } catch (IOException e) {
            LOG.catching(Level.ERROR, e);
            LOG.throwing(new RuntimeException(e));
        }
    }
}