package smartdietmanagement;

/**
 *
 * @author Jez
 */

public class Calories {

    public static double weight;
    public static double height;
    public static int age;

    public Calories(double weight, double height, int age) {
        Calories.weight = weight;
        Calories.height = height;
        Calories.age = age;
    }

    /*
    public static void main(String[] args) {

        Calories data = new Calories(55.5, 160.5, 25);
        Exercise reminder = new Exercise(5);

        double a, b, c, d, e, f, g, h, men, women;
        a = 66;
        b = 6.2;
        c = 12.7;
        d = 6.7;
        e = 655.1;
        f = 4.4;
        g = 4.7;
        h = 4.7;

        men = a + (b * Calories.weight) + (c * Calories.height) - (d * Calories.age);
        women = e + (f * Calories.weight) + (g * Calories.height) - (h * Calories.age);

        System.out.println(women);

        System.out.println("Reminder scheduled");

    }
    */

}