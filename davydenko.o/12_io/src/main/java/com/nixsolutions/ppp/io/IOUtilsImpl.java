package com.nixsolutions.ppp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

public class IOUtilsImpl implements IOUtils {
    @Override
    public String gzip(String fileName, String folder) throws IllegalArgumentException {
        String gzipFile = fileName + ".gzip";
        File checkFile = new File(fileName);
        File fileFolder = new File(folder);
        if (!checkFile.exists() || !fileFolder.exists()) {
            throw new IllegalArgumentException("not exist");
        }
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(gzipFile);
             GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return gzipFile;
    }
    @Override
    public Integer searchText(String fileName, String mark) throws IllegalArgumentException {
        if (fileName.isEmpty()) {
            throw new IllegalArgumentException("no such file");
        }
        int countLine = 0;
        String string;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((string = br.readLine()) != null) {
                if (string.contains(mark)) {
                    countLine++;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return countLine;
    }

    @Override
    public String[] search(File folder, String ext) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        if (!folder.exists()) {
            throw new IllegalArgumentException("folder not exist");
        }
        findFiles(folder, ext, sb);
        String[] result = sb.toString().split(",");
        return result;
    }

    private static void findFiles(File fileFrom, String ext, StringBuilder sb) {
        for (File file : Objects.requireNonNull(fileFrom.listFiles())) {
            if (file.isDirectory()) {
                findFiles(file, ext, sb);
            }
            if (ext.isEmpty() || file.getName().endsWith(ext)) {
                sb.append(file.getAbsolutePath()).append(",");
            }
        }
    }
}
