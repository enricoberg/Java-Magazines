package org.example.utilities;
import org.example.Main;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
public class Utilities {
    public static String ValidatedUserString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input != null && !input.isEmpty()) return input;
            else System.out.println("Invalid string, please try again: ");
        }
        
    }
    public static int ValidatedUserInteger() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                   return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, please try again: ");
            }
        }
    }
    public static LocalDate ValidatedUserDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date, please insert date with format yyyy-mm-dd");
            }
        }
    }

    public static String PathOf(String filename) {
        //GETS THE CSV FROM THE RESOURCES FOLDER IF IN DEVELOPMENT MODE, OTHERWISE SEARCHES IN THE JAR DIRECTORY
        String className = Main.class.getName().replace('.', '/');
        String classJar = Main.class.getResource("/" + className + ".class").toString();
        if (!classJar.startsWith("jar:")) {
            String resourcePath = "src/main/resources/";
            resourcePath = resourcePath + filename;
            resourcePath = Paths.get(System.getProperty("user.dir"), resourcePath).normalize().toString();
            return resourcePath;
        }
        return  filename;
    }

    public static void write(String content, String filename) throws IOException{
        Path path = Paths.get(filename);
        byte[] strToBytes = content.getBytes();
        Files.write(path, strToBytes);
    }


}
