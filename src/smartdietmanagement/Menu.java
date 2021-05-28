package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

// import java.util.Scanner;

public class Menu {

    public static LocalDateTime date = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String formattedDate = date.format(formatter);

    public static String time;

    public static String loginOpt[] = { "Login", "Register", "Login as Guest" };
    public static String mainOpt[] = { "Profile Data", "Fitness", "Diet", "Food Intake", "Exit" };
    public static String profileOpt[] = { "Display User Data", "Update User Data", "BMI Calculator", "Log out",
            "Return" };
    public static String fitnessOpt[] = { "Calories Data", "Exercise Schedule", "Update Exercise Schedule",
            "Start Exercising", "Return" };
    public static String dietOpt[] = { "Generate Recipe", "Return" };

    public static void print(String text) {
        System.out.print(text);
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void menu(String header) {
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.printf("%n%n%-30s%30s%n%n", header, formattedDate);
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.print("\n\n");
    }

    public static void footer(String ques) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        time = dtf.format(now);

        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.printf("%n%n%-40s%20s%n%n", ques, time);
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.println("\n");
    }

    public static void mainMenu(String type) {
        String no;
        if (type.equals("login")) {
            for (int j = 1; j <= loginOpt.length; ++j) {
                no = "[" + j + "]";
                System.out.printf("%-25s%-35s%n%n", no, loginOpt[j - 1]);
            }
        } else if (type.equals("main")) {
            for (int j = 1; j <= mainOpt.length; ++j) {
                no = "[" + j + "]";
                System.out.printf("%-25s%-35s%n%n", no, mainOpt[j - 1]);
            }
        } else if (type.equals("profile")) {
            for (int j = 1; j <= profileOpt.length; ++j) {
                no = "[" + j + "]";
                System.out.printf("%-25s%-35s%n%n", no, profileOpt[j - 1]);
            }
        } else if (type.equals("fitness")) {
            for (int j = 1; j <= fitnessOpt.length; ++j) {
                no = "[" + j + "]";
                System.out.printf("%-25s%-35s%n%n", no, fitnessOpt[j - 1]);
            }
        } else if (type.equals("diet")) {
            for (int j = 1; j <= dietOpt.length; ++j) {
                no = "[" + j + "]";
                System.out.printf("%-25s%-35s%n%n", no, dietOpt[j - 1]);
            }
        }
    }

    public static int parseSelection(String selection) {
        try {
            int number = Integer.parseInt(selection);
            return number;
        } catch (Exception e) {
            return -1;
        }
    }

    public static void exit() {
        cls();
        print("\t\t\n\nGoodbye!");
        wait(2000);
        System.exit(0);
    }

}