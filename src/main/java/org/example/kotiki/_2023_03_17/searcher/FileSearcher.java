package org.example.kotiki._2023_03_17.searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    private static void getFiles(File rootFile, List<File> fileList) {
        if(rootFile.isDirectory()) {
            System.out.println("searching......" + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if(directoryFiles != null) {
                for (File file : directoryFiles) {
                    if(file.isDirectory()) {
                        getFiles(file, fileList);
                    } else {
                        if(file.getName().startsWith("ENUtxt") && file.getName().toLowerCase().endsWith(".pdf") ) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();
        getFiles(new File("D:\\"), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }
}