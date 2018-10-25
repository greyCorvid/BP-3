package ReadWriteCharsets;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

//**Чтение и запись файлов в разных кодировках**
//
//1
//Заведите в программе переменную text
// и присвойте ей какой-нибудь русский текст длиной в одно предложение.
//
// 2
// Запишите текст в файлы
// text_utf8.txt, text_win1251.txt, text_koi8r.txt
// в соответствующих кодировках.
//
// 3
// Прочитать каждый файл побайтово
// (Files.readAllBytes()) и вывести байты в файлы,
// соответственно, text_utf8.bin и т.п.
// Байты выводятся текстом через пробел, т.е.,
// например, 128 210 30.
// На сайте hexed.it вы можете проверить содержимое файлов
// и сравнить с тем, что получилось у вас.
//
// 4
// Для файла в кодировке koi8r сделать следующее.
// Прочитать все его байты.
// Если какой-то байт < 0, то добавить к его значению 128.
// Записать полученные байты в новый файл text_koi7r.txt.
// Записывайте байты в виде байт,
// а не в виде текста, как требовала прошлая задача.
// Откройте полученный файл в текстовом редакторе (можно через IDEA)
// и посмотрите, что получилось.
public class ReadWrite4 {
    public static void main(String[] args) {
        String text = "Ржится рожь, овёс овсится, чечевица чечевится";

        String utf = "text_utf8";
        String win = "text_win1251";
        String koi = "text_koi8r";
        writeText(text, utf, "utf-8");
        writeText(text, win, "windows-1251");
        writeText(text, koi, "KOI8-R");

        writeBytes(utf);
        writeBytes(win);
        writeBytes(koi);

        writeKoi7(koi);
    }

    private static void writeText(String text, String fileName, String charset) {
        try(Writer out = new OutputStreamWriter(new FileOutputStream("./files/ReadWriteCharsets/" + fileName + ".txt"), charset)) {
            out.write(text);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private static void writeBytes(String fileName) {
        try {
            byte[] allBytes = Files.readAllBytes(Paths.get("./files/ReadWriteCharsets", fileName + ".txt"));
                try(Writer out = new OutputStreamWriter(new FileOutputStream("./files/ReadWriteCharsets/" + fileName + ".bin"), "utf-8")) {
                    for (byte allByte : allBytes) {
                        //избавляемся от доп кода
                        int bb = allByte < 0?256 + allByte : allByte;
                        //Ещё способ out.write(Integer.toString(bb, 16));
                        //и на сайте hexed.it именно это и выведено
                        out.write(allByte + " " + bb + " " + Integer.toString(bb, 16));
                        out.write(" ");
                        System.out.println(allByte + " " + bb + " " + Integer.toString(bb, 16));
                    }
                } catch (Exception e) {
                    System.out.println("error");
                    System.out.println(e + "\n");
                }
            System.out.println();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e + "\n");
        }
    }

    private static void writeKoi7(String fileName) {
        try {
            byte[] allBytes = Files.readAllBytes(Paths.get("./files/ReadWriteCharsets", fileName + ".txt"));
            try(Writer out = new OutputStreamWriter(new FileOutputStream("./files/ReadWriteCharsets/text_koi7r.txt"))) {
                for (byte allByte : allBytes) {
                    int b = allByte < 0?allByte + 128: allByte;
                    out.write(b);
                    System.out.println(allByte + " " + b);
                }
            } catch (Exception e) {
                System.out.println("error");
                System.out.println(e + "\n");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e + "\n");
        }

    }
}
