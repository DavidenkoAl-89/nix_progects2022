package com.nixsolutions.ppp.exception;

import com.nixsolutions.ppp.exceptions.Saver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class SaverImpl implements Saver {
    @Override
    public void save(String text, String fileAbsolutePath) {
        File file = new File(fileAbsolutePath);
        try {
            if (!file.exists()) {
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(text);
                }
            } else {
                throw new FileAlreadyExistsException("File already exist");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



