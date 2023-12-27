package org.example;
import java.nio.file.Paths;
import org.example.controller.Controller;
public class Main {

    public static void main(String[] args) {


        System.out.println("""
                ------------------------------------------------------
                ------Welcome to Magazine Administration System-------
                ------------------------------------------------------""");

        do {
            System.out.println("""
                    ------------------------------------------------------
                    Please press:
                    -1 to view all magazines
                    -2 to subscribe to an existing magazine
                    -3 to cancel a subscription
                    -4 to add new user
                    -5 to export available magazines list in CSV
                    -0 to exit the program
                    ------------------------------------------------------""");
        }
        while (Controller.control());
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
        return filename;
    }
}
