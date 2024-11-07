package Streams;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;


import static java.time.temporal.ChronoUnit.SECONDS;

public class Streams {
    private static void fakeError() throws IOException{
        Scanner sc = new Scanner(System.in);
        String filePath = "F:\\Java\\Программирования\\java-corse\\src\\Streams";
        switch (sc.nextLine()) {
            case "1":
                System.out.println("Возникла не предвиденная ошибка. Подробнее в файле.");
                File file = new File(filePath + "\\error1.txt");
                OutputStream outputStream = new FileOutputStream(file);
                outputStream.write(("Возникла ошибка в процессе работы с программой #1. " +
                        "\nОбратитесь к администраторам\n\nCode report:\n" +
                        "public static void main(String[] args) throws IOException {\n" +
                        "        Scanner sc = new Scanner(System.in);\n" +
                        "        String filePath = \"F:\\\\Java\\\\Программирования\\\\java-corse\\\\src\\\\Streams\";\n" +
                        "        switch (sc.nextLine()) {\n" +
                        "            case \"1\":\n" +
                        "                System.out.println(\"Возникла не предвиденная ошибка. Подробнее в файле.\");\n" +
                        "                File file = new File(filePath + \"\\\\error1.txt\");\n" +
                        "                OutputStream outputStream = new FileOutputStream(file);\n" +
                        "                outputStream.write((\"Возникла ошибка в процессе работы с программой #1. \" +\n" +
                        "                        \"\\nОбратитесь к администраторам\\n\" +\n" +
                        "                        \"\").getBytes());\n" +
                        "                outputStream.close();\n" +
                        "                break;\n" +
                        "            default:\n" +
                        "                System.out.println(\" | Неизвестный случай\");\n" +
                        "        }\n" +
                        "    }").getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                break;
            default:
                System.out.println(" | Неизвестный случай");
        }
    }
    private static void copy()  throws IOException {
        File file = new File("F:\\Java\\Программирования\\java-corse\\src\\Streams\\_input.txt");
        List<Byte> byteList = new ArrayList<>();

        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            int i;
            while ((i = inputStream.read()) != -1){
                byteList.add((byte) i);
                System.out.print(" " + i);
            }
            System.out.println();
            int sizeByteList = byteList.size();

            byte [] byteArray = new byte[sizeByteList];
            Iterator<Byte> iterator = byteList.iterator();
            int it = 0;
            while (iterator.hasNext()){
                byteArray[it] = iterator.next();
                it++;
            }

            String path = "F:\\Java\\Программирования\\java-corse\\src\\Streams\\output.txt";
            OutputStream outputStream = new FileOutputStream(path);
            outputStream.write(byteArray);
            outputStream.close();

        } else {
            System.out.println("Файл не обнаружен.");
        }
    }
    private static void buffer() throws IOException {
        File file = new File("F:\\Java\\Программирования\\java-corse\\src\\Streams\\file.txt");
        List<Byte> byteList = new ArrayList<Byte>();
        if (file.exists()){
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            int i;
            while ((i = inputStream.read()) != -1){
                byteList.add((byte) i);
            }
        } else {
            System.out.println("Создаю файл...");
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            outputStream.write("БУ! ИСПУГАЛСЯ НЕ БОЙСЯ!!".getBytes());
            outputStream.close();
        }

        byte [] bArray = new byte[byteList.size()];
        Iterator<Byte> byteIterator = byteList.iterator();
        int iter = 0;
        while (byteIterator.hasNext()){
            bArray[iter] = byteIterator.next();
            iter++;
        }

        String byteString = new String(bArray, StandardCharsets.UTF_8);
        System.out.println(byteString);
    }
    private static void fileConfig() throws IOException {
        File file = new File("F:\\Java\\Программирования\\java-corse\\src\\Streams\\files\\config.txt");
        if (file.exists()) {
            System.out.println("Файл конфигурации есть");
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            List<Byte> byteList = new ArrayList<>();
            int i;
            while ((i = inputStream.read()) != -1){
                byteList.add((byte) i);
            }
            inputStream.close();
            byte [] byteArray = new byte[byteList.size()];

            for (int it = 0; it < byteList.size(); it++) {
                byteArray[it] = byteList.get(it);
            }

            Map<String,String> map = new HashMap<>();

            String config = new String(byteArray, StandardCharsets.UTF_8);

            String [] str = new String[config.split("\n").length] ;
            str = config.split("\n");
            for (int j = 0; j < str.length; j++) {
                String [] tempStringArray = new String[2];
                tempStringArray = str[j].split("=");
                map.put(tempStringArray[0],tempStringArray[1]);
            }

            map.forEach((key, value) -> System.out.println(" k: "+ key + ": " + value));

            String path = "F:\\Java\\Программирования\\java-corse\\src\\Streams\\files\\report.txt";
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
            outputStream.write("Отчёт по настройкам конфигурации".getBytes());
            for (Map.Entry<String,String> item : map.entrySet()) {
                String str1 = String.format("%n Ключ: %s: %s ",item.getKey().trim(),item.getValue().trim());
                outputStream.write(str1.getBytes());
            }
            outputStream.close();

        } else {
            System.out.println(" Ошибка | не могу найти файл конфигурации!");
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //Создаём HttpClient
        HttpClient httpClient = HttpClient.newBuilder().build();

        String requestBody = """
                {
                  "loginList": [
                    "trina"
                  ]
                }""";

        String username = "api-login-61544";
        String password = "dba0190aee8149";

        String auth = username + ":" + password;
        String data = Base64.getEncoder().encodeToString(auth.getBytes());

        //Запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://partner-api.1c.ru/api/rest/public/subscription/checkItsByLogin"))
                .timeout(Duration.of(15,SECONDS))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + data)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        //Ответ
        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());


    }

}
