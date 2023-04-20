package com.nixsolutions.ppp.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        File folderFile = new File("src");
        Path path = Path.of("src");
        String folder = "src";
        IOUtils ioUtils = new IOUtilsImpl();
        NIOUtils nioUtils = new NIOUtilsImpl();
         System.out.println(ioUtils.gzip("src/test", folder));

         System.out.println(ioUtils.searchText("src/main/java/com/nixsolutions/ppp/io/file4.txt","hh"));

        System.out.println(Arrays.toString(ioUtils.search(folderFile, "ext")));
        System.out.println(nioUtils.searchText(Paths.get("/home/NIX/davydenko-o/davydenko.o/12_io/src/main/java/com/nixsolutions/ppp/io/test.txt"), 4));
    }
}
