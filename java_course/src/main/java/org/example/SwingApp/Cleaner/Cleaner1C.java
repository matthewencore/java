package org.example.SwingApp.Cleaner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

enum TypeFile {
    PFL(".pfl"),
    DIR("Directory");
    String choise;

    TypeFile(String choise) {
        this.choise = choise;
    }

    public String getChoise() {
        return choise;
    }
}

class TimeStamp{
    static String getTime(){
        LocalTime lt = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return lt.format(dateTimeFormatter);
    }
}

class IgnoreFile{
    private String name;
    private TypeFile type;


    public IgnoreFile(String name, TypeFile type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
}

class FormRealize {
    private Cleaner1C cleaner1C;
    final String userHome = System.getProperty("user.home");
    final String path1cV8Roaming = "\\AppData\\Roaming\\1C\\1cv8";
    final String path1cV8Local = "\\AppData\\Local\\1C\\1cv8";

    final List<IgnoreFile> ignoreFiles = Arrays.asList(
            new IgnoreFile("1cv8",TypeFile.PFL),
            new IgnoreFile("1cv8c",TypeFile.PFL),
            new IgnoreFile("1cv8ccmn",TypeFile.PFL),
            new IgnoreFile("1cv8strt",TypeFile.PFL),
            new IgnoreFile("1cv8u",TypeFile.PFL),
            new IgnoreFile("EmptyIB",TypeFile.DIR),
            new IgnoreFile("ExtCompT",TypeFile.DIR),
            new IgnoreFile("tmplts",TypeFile.DIR),
            new IgnoreFile("WebKit",TypeFile.DIR)
    );

    boolean isIgnored(String arg){
        for (IgnoreFile file: ignoreFiles) {
            if (file.getName().equals(arg)) return true;
        }
        return false;
    }
    // Roaming
    File getFilePath(){
        return new File(userHome + path1cV8Roaming);
    }
    // Local
    File getFilePathLocal(){
        return new File(userHome + path1cV8Local);
    }

    public FormRealize(Cleaner1C cleaner1C) {
        this.cleaner1C = cleaner1C;
    }

    void findCashe(){
        if (!getFilePath().canRead()){
            cleaner1C.setTextArea1("Нет прав на чтение! \n");
        } else if (!getFilePath().isDirectory()) {
            cleaner1C.setTextArea1("Не является директорией!\n");
        } else if (!getFilePath().canWrite()) {
            cleaner1C.setTextArea1("Нет прав!\n");
        }

        // Проверка на директории
        List<File> dir = Arrays.stream(getFilePath().listFiles()).filter(File::isDirectory).toList();

        // Тщательная проверка, проверка еще раз на директории
        for (File file: dir) {
            if (isIgnored(file.getName())){
                continue;
            }
            String tempName = file.getName();
            cleaner1C.setTextArea1("[" +TimeStamp.getTime() + "] "+  tempName + " был найден \n");
            deleteDir(file);

        }
        findCasheLocal();
    }

    void findCasheLocal(){
        if (!getFilePathLocal().canRead()){
            cleaner1C.setTextArea1("Нет прав на чтение! \n");
        } else if (!getFilePath().isDirectory()) {
            cleaner1C.setTextArea1("Не является директорией!\n");
        } else if (!getFilePath().canWrite()) {
            cleaner1C.setTextArea1("Нет прав!\n");
        }

        // Проверка на директории
        List<File> dir = Arrays.stream(getFilePathLocal().listFiles()).filter(File::isDirectory).toList();

        // Тщательная проверка, проверка еще раз на директории
        for (File file: dir) {
            if (isIgnored(file.getName())){
                continue;
            }
            String tempName = file.getName();
            cleaner1C.setTextArea1("[" +TimeStamp.getTime() + "] "+  tempName + " был найден \n");
            deleteDir(file);
        }

    }

    void deleteDir(File dir){
        if (!dir.exists()){
            return;
        }

        for (File f: Objects.requireNonNull(dir.listFiles())) {
            String tempName = f.getName();

            if (f.isDirectory()) {
                if (f.delete()){
                    cleaner1C.setTextArea1("[" +TimeStamp.getTime() + "] "+  tempName + " был удалён \n");
                } else {
                    deleteDir(f);
                }

            } else if (f.isFile()) {
                cleaner1C.setTextArea1("[" +TimeStamp.getTime() + "] "+  tempName + " был удалён \n");
                f.delete();
            }

            if (dir.delete()) {
                cleaner1C.setTextArea1("[" + TimeStamp.getTime() + "] " + dir.getName() + " была удалена \n");
            }
        }
    }
}



public class Cleaner1C extends JFrame {
    FormRealize formRealize = new FormRealize(this);

    private JButton button1;
    private JPanel panel;

    public void setTextArea1(String textArea1) {
        this.textArea1.append(textArea1);
    }

    private JTextArea textArea1;
    public JLabel lError;

    public Cleaner1C(){
        setResizable(false);
        setIconImage(new ImageIcon("F:\\Java\\Программирования\\java-course\\java_course\\src\\main\\java\\org\\example\\SwingApp\\Cleaner\\static\\icon.png").getImage());
        setTitle("Очистка кэша: 1С"); // Заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие программы при выходе
        setContentPane(panel); // Устанавливаем основную панель
        setSize(600, 400); // Устанавливаем размеры окна
        setLocation(700, 400); // Устанавливаем положение окна на экране
        setVisible(true); // Делаем окно видимым
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formRealize.findCashe();
            }
        });
    }

    public static void main(String[] args) {
        new Cleaner1C();
    }

}
