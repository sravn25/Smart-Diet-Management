package smartdietmanagement;

/**
 *
 * @author Wan Teng
 */

import java.util.Scanner;

public class FoodIntake {

    public static final double RECOMMENDED_CALORIES = 2079;

    public static void foodIntake() {

        Scanner keyboard = new Scanner(System.in);
        double servingCalories = 0;
        double caloriePercent;
        String foodType;
        String brandName;

        System.out.println("This program accepts a brand name and descriptive " + "food type, followed\n"
                + "by the amount of Calories in one serving." + "It then calculates the percentage\n"
                + "of the total daily calorie" + "requirement of an adult, that the food supplies.");

        System.out.println("    Sample Foods and Brands:\n");
        System.out.println("    Brand Name     Descriptive Food Type      Calories Per Serving");
        System.out.println("     --------       -------------------        ------------------ ");
        System.out.println("     Aramark       Cheese Pizza                  163.4            ");
        System.out.println("     Generic       Wild, Raw Altlantic Salmon    562.3            ");
        System.out.println("     Quakers       Oatmeal                       225              ");
        System.out.println("     Starbucks     Cinnamon Raisin Bagel         440              ");
        System.out.println("     Homemade      Mixed Fruit Smoothie          250              ");
        System.out.println("     Tropicana     100% Orange Juice             140              ");
        System.out.println("     Earth         Tap Water                     0                ");

        System.out.print(">Please enter the brand name and food type: ");
        brandName = keyboard.next();
        foodType = keyboard.next();

        boolean entering = true;
        while (entering) {
            System.out.print("Please enter the amount of Calories in 1 serving:");
            String calories = keyboard.next();
            try {
                // servingCalories = keyboard.nextDouble();
                Double.parseDouble(calories);
                servingCalories = Double.parseDouble(calories);
            } catch (Exception e) {
                System.out.println("Please enter a valid amount\n");
            }

            if (servingCalories != 0) {
                entering = false;
            }
        }

        System.out.println();

        caloriePercent = (servingCalories / RECOMMENDED_CALORIES) * 100;

        System.out.print(foodType + "(" + brandName + ")" + "is ");
        System.out.printf("%.0f", caloriePercent);
        System.out.println("% of an adult's daily caloric requirement.");
        keyboard.nextLine();

    }
}
