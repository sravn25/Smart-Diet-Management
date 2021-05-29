package smartdietmanagement;

/**
 *
 * @author ashd
 */

public class ProfileData {
    public double height;
    public double weight;
    public int age;
    public String goal;

    // assign values to variables
    public ProfileData() {
        height = (double) 0.0;
        weight = (double) 0.0;
        age = (int) 0.0;
        goal = null;
    }

    // constructor
    public ProfileData(double height, double weight, int age, String goal) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal = goal;
    }

    // calculate bmi
    public double BMICalc() {
        return (this.weight / Math.pow(this.height, this.height));
    }

    public double BMICalculator(double height, double weight) {
        return (weight / Math.pow(height, height));
    }

    public String BMIScale(double bmi) {
        // bmi scale
        if (bmi < 18.5)
            return "underweight";
        else if (bmi < 25)
            return "normal";
        else if (bmi < 30)
            return "overweight";
        else
            return "obese";
    }

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

    // update user info
    public boolean update(int type, String value) {
        if (type == 1) {
            try {
                double newVal = Double.parseDouble(value);
                setHeight(newVal);
                return true;
            } catch (Exception e) {
                setHeight(0.0);
                return false;
            }
        } else if (type == 2) {
            try {
                double newVal = Double.parseDouble(value);
                setWeight(newVal);
                return true;
            } catch (Exception e) {
                setWeight(0.0);
                return false;
            }
        } else if (type == 3) {
            try {
                int newVal = Integer.parseInt(value);
                setAge(newVal);
                return true;
            } catch (Exception e) {
                setAge(0);
                return false;
            }
        } else if (type == 4) {
            if (value.equals("gain") || value.equals("lose") || value.equals("maintain")) {
                setGoal(value);
                return true;
            } else {
                setGoal("");
                return false;
            }
        }
        return false;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

}