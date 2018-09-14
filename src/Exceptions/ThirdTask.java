package Exceptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//Дан список имён файлов List<String>,
// переименовать все файлы в списке,
// a.txt -> 0a.txt, b.txt ->1b.txt
//file.move
//file.rename
//Нужно написать подробную обработку ошибок
public class ThirdTask {
    public static void main(String[] args) {
        List<String> myFiles = new ArrayList<>();
        myFiles.add("a.txt");
        myFiles.add("b.txt");
//        myFiles.add("");
        renameFiles(myFiles);
    }

    private static void renameFiles(List<String> fileNames) {
        List<String> newFiles = new ArrayList<>();
        int i = 0;
        for (String fileName : fileNames) {
            try {
                new File currentFile =
            } catch (Exception e) {
                System.out.println("");
            }
            i++;
        }
    }
}
