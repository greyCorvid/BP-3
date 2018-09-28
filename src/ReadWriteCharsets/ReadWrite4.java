package ReadWriteCharsets;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

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

        write_text(text, "./src/ReadWriteCharsets/text_utf8.txt", "utf-8");
        write_text(text, "./src/ReadWriteCharsets/text_win1251.txt", "windows-1251");
        write_text(text, "./src/ReadWriteCharsets/text_koi8r.txt", "KOI8-R");
    }

    private static void write_text(String text, String filePath, String charset) {
        try(Writer out = new OutputStreamWriter(new FileOutputStream(filePath), charset)) {
            out.write(text);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
