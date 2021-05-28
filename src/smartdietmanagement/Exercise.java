package smartdietmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Jez
 */

public class Exercise {

    public static String activities[][] = { { "Jogging", "2" }, // Monday
            { "Swimming", "2" }, // Tuesday
            { "Lifting", "3" }, // Wednesday
            { "Jumping", "3" }, // Thurdsay
            { "Hiking", "4" }, // Friday
            { "Swimming", "5" }, // Saturday
            { "Jogging", "2" }, // Sunday
            { "404", "1" } // error flag
    };

    public static String days[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
            "error" };

    Timer timer;

    public Exercise(int seconds) {
        timer = new Timer();
        timer.schedule(new ExerciseReminder(), seconds * 1000);
    }

    class ExerciseReminder extends TimerTask {

        public void run() {
            System.out.format("Exercise Completed!%n");
            timer.cancel();
        }
    }

    public static void exerciseDetail() {

        LocalDate day = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE");
        String today = day.format(format);

        System.out.printf("%-30s%-30s%n", "Today :", today.equals("Mon") ? "Monday"
                : today.equals("Tue") ? "Tuesday"
                        : today.equals("Wed") ? "Wednesday"
                                : today.equals("Thu") ? "Thursday"
                                        : today.equals("Fri") ? "Friday" : today.equals("Sat") ? "Saturday" : "Sunday");
        System.out.printf("%-30s%-30s%n", "Activity: ",
                today.equals("Mon") ? activities[0][1]
                        : today.equals("Tue") ? activities[1][1]
                                : today.equals("Wed") ? activities[2][1]
                                        : today.equals("Thu") ? activities[3][1]
                                                : today.equals("Fri") ? activities[4][1]
                                                        : today.equals("Sat") ? activities[5][1] : activities[6][1]);

        System.out.printf("%n%n%-20s%-20s%n", "[1]", "Start Exercising");
        System.out.printf("%-20s%-20s%n%n", "[2]", "Return");

    }

    public static void exerciseSchedule() {

        LocalDate day = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE");
        String today = day.format(format);

        int index;

        switch (today) {
            case "Mon":
                index = 0;
                break;
            case "Tue":
                index = 1;
                break;
            case "Wed":
                index = 2;
                break;
            case "Thu":
                index = 3;
                break;
            case "Fri":
                index = 4;
                break;
            case "Sat":
                index = 5;
                break;
            case "Sun":
                index = 6;
                break;
            default:
                index = 7;
        }

        System.out.printf("%-30s%-30s%n", "Yesterday :", index == 0 ? days[6] : days[index - 1]);
        System.out.printf("%-30s%-30s%n%n", "Yesterday's Activity :",
                index == 0 ? activities[6][0] : activities[index - 1][0]);

        for (int i = 0; i < 60; ++i) {
            System.out.print("=");
        }
        System.out.printf("%n%n%-30s%-30s%n", "Today :", days[index]);
        System.out.printf("%-30s%-30s%n%n", "Today's Activity :", activities[index][0]);
        for (int i = 0; i < 60; ++i) {
            System.out.print("=");
        }

        System.out.printf("%n%n%-30s%-30s%n", "Tomorrow :", index == 6 ? days[0] : days[index + 1]);
        System.out.printf("%-30s%-30s%n%n", "Today's Activity :", index == 6 ? activities[0][0] : activities[index][0]);

    }

    public static void exerciseList() {
        String number;
        System.out.printf("%-10s%-15s%-20s%-15s%n%n", "Number", "Day", "Activity", "Duration (s)");
        for (int i = 0; i < activities.length - 1; ++i) {
            number = "[" + (i + 1) + "]";
            System.out.printf("%-10s%-15s%-20s%-15s%n", number, days[i], activities[i][0], activities[i][1]);
        }
        System.out.println("");
    }

    public static void updateExercise(int day, String newE, String newT) {
        --day;

        activities[day][0] = newE; // new Exercise name
        activities[day][1] = newT; // new Exercise duration

    }

    public static boolean durationIntCheck(String duration) {
        try {
            Integer.parseInt(duration);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int exerciseDuration() {

        LocalDate day = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE");
        String today = day.format(format);

        int index = 7;

        if (today.equals("Mon"))
            index = 0;
        else if (today.equals("Tue"))
            index = 1;
        else if (today.equals("Wed"))
            index = 2;
        else if (today.equals("Thu"))
            index = 3;
        else if (today.equals("Fri"))
            index = 4;
        else if (today.equals("Sat"))
            index = 5;
        else if (today.equals("Sun"))
            index = 6;
        else
            index = 7;

        return Integer.parseInt(activities[index][1]);
    }

}