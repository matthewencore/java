package org.example.Exceptions;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.text.ChoiceFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;


public class Practice {
    public static void main(String[] args) throws FileNotFoundException, FileAlreadyExistsException {

        File file = new File("./files/win1251.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("Ошибка, файл не был найден");
        }

        File createFile = new File("./files/utf8.txt");
        if (createFile.exists()){
            throw new FileAlreadyExistsException("Файл уже существует, перезапись данных небезопасна");
        }

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file),"windows-1251"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("createFile"),StandardCharsets.UTF_8))) {
            String line;
            while ((line = bf.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
