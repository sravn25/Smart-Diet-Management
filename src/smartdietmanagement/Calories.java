package smartdietmanagement;

/**
 *
 * @author Jez
 */

public class Calories {

    public double weight;
    public double height;
    public int age;
    public char sex;

    public Calories(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public void updateCalories(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public boolean updateSex(String sex) {
        if (sex.equalsIgnoreCase("m") || sex.equalsIgnoreCase("f")) {
            this.sex = sex.charAt(0);
            return true;
        }
        return false;
    }

    public int bmrCalc() {
        // daily calories need
        // https://diabetesstrong.com/how-to-find-your-daily-calorie-need/
        // http://www.moneychimp.com/diversions/bmi.htm
        double weight = this.weight, leanFactor = 1;

        if (this.sex == 'f') 
            weight *= 0.9;

        weight *= 24;

        if (this.sex == 'm') {
            if (this.age < 15) {
                leanFactor = 1.00;
            } else if (this.age > 14 && this.age < 21) {
                leanFactor = 0.95;
            } else if (this.age > 20 && this.age < 29) {
                leanFactor = 0.90;
            } else {
                leanFactor = 0.85;
            }
        } else {
            if (this.age < 19)
                leanFactor = 1.00;
            else if (this.age > 18 && this.age < 29)
                leanFactor = 0.95;
            else if (this.age > 28 && this.age < 39)
                leanFactor = 0.90;
            else {
                leanFactor = 0.85;
            }
        }

        weight *= leanFactor;

        return (int)Math.round(weight);
    }

    /*
    public void displayData() {

        String number, type;
        String data[] = { this.height == 0.0 ? null : Double.toString(this.height),
                this.weight == 0.0 ? null : Double.toString(this.weight),
                this.age == 0 ? null : Integer.toString(this.age), this.goal.equals("") ? null : this.goal };
        for (int i = 0; i < data.length; ++i) {

            switch (i) {
                case 0:
                    type = "Height";
                    break;
                case 1:
                    type = "Weight";
                    break;
                case 2:
                    type = "Age";
                    break;
                default:
                    type = "Goal";
            }

            number = "[" + (i + 1) + "]";

            if (data[i] == null)
                System.out.printf("%-20s%-20s%-20s%n%n", number, type, "data unavailable");
            else if (i == 0 || i == 1)
                System.out.printf("%-20s%-20s%-20.2f%n%n", number, type, i == 0 ? this.height : this.weight);
            else
                System.out.printf("%-20s%-20s%-20s%n%n", number, type, data[i]);
        }
        if (this.weight == 0.0 && this.height == 0.0)
            System.out.printf("%-20s%-20s%-20s%n%n", "[5]", "BMI", "insufficient data");
        else
            System.out.printf("%-20s%-20s%-20.2f%n%n", "[5]", "BMI", this.BMICalc());

    }
    */

    /*
     * public static void main(String[] args) {
     * 
     * Calories data = new Calories(55.5, 160.5, 25); Exercise reminder = new
     * Exercise(5);
     * 
     * double a, b, c, d, e, f, g, h, men, women; a = 66; b = 6.2; c = 12.7; d =
     * 6.7; e = 655.1; f = 4.4; g = 4.7; h = 4.7;
     * 
     * men = a + (b * Calories.weight) + (c * Calories.height) - (d * Calories.age);
     * women = e + (f * Calories.weight) + (g * Calories.height) - (h *
     * Calories.age);
     * 
     * System.out.println(women);
     * 
     * System.out.println("Reminder scheduled");
     * 
     * }
     */

}