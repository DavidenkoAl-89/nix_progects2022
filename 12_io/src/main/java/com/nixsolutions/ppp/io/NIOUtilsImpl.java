package com.nixsolutions.ppp.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class NIOUtilsImpl implements NIOUtils {
    @Override
    public String searchText(Path file, int offset) throws IllegalArgumentException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.toFile(), "r")) {
            randomAccessFile.seek(offset);
            int position = offset;
            while (true) {
             String string = readBytes(randomAccessFile);
                if (string.matches("-?\\d+")) {
                    int skipBytes = Integer.parseInt(string);
                    position = position + skipBytes;
                    randomAccessFile.seek(position);
                } else {
                    return string;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String readBytes(RandomAccessFile randomAccessFile) {
        StringBuilder stringBuilder = new StringBuilder();
        int byteFromString;
        while (true) {
            try {
                byteFromString = randomAccessFile.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (byteFromString == 32 || byteFromString == -1) {
                break;
            } else
                stringBuilder.append((char) byteFromString);
        }
        return stringBuilder.toString();
    }
    @Override
    public String[] search(Path folder, String ext) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        Path configFilePath = FileSystems.getDefault().getPath(String.valueOf(folder));
        List<Path> fileWithName;
        try {
            fileWithName = Files.walk(configFilePath)
                    .filter(s -> s.toString().endsWith(ext))
                    .map(Path::toAbsolutePath)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sb.append(fileWithName).append(",");
        String[] result = sb.toString().split(",");
        return result;
    }
}