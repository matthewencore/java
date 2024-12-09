package org.example.JavaPython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaPythonClass {
    public static void main(String[] args) {
        // Задаем аргументы для передачи в скрипт
        String arg1 = "10";
        String arg2 = "20";

        try {
            // Создаем процесс для выполнения Python-скрипта
            ProcessBuilder pb = new ProcessBuilder("python", "F:\\Java\\Программирования\\java-course\\java_course\\src\\main\\java\\org\\example\\JavaPython\\script.py", arg1, arg2);
            Process process = pb.start();

            // Читаем вывод скрипта
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Результат из Python: " + line);
            }

            // Ждем завершения процесса и получаем код выхода
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
