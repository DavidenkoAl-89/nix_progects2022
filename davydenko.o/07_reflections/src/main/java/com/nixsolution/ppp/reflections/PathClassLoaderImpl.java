package com.nixsolution.ppp.reflections;

import com.nixsolutions.ppp.reflection.PathClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class PathClassLoaderImpl extends ClassLoader implements PathClassLoader {
    private Path path;
    @Override
    public Path getPath() {
        return path;
    }
    @Override
    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassFromFile(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defineClass(null, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName) throws IOException, ClassNotFoundException {
        int readByte;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (InputStream inputStream = new FileInputStream(path.toAbsolutePath().toString() + File.separatorChar + fileName.split("\\.")[0] + ".class");
             byteStream) {
            while ((readByte = inputStream.read()) != -1) {
                byteStream.write(readByte);
            }
        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException("Couldn't find class " + fileName, e);
        }
        return byteStream.toByteArray();
    }
}