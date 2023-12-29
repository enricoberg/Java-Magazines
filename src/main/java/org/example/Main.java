package org.example;
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


}
