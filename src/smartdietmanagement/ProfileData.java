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
    
    //assign values to variables
    public ProfileData(){
        height = (double) 0.0;
        weight = (double) 0.0;
        age = (int) 0.0;
        goal = null;
    }
    
    //constructor
    public ProfileData (double height, double weight, int age, String goal){
    this.height = height;
    this.weight = weight;
    this.age = age;
    this.goal = goal;
    }

    
    //calculate bmi 
    public double BMICalc(double weight, double height){
        return (weight / (height * height));
    }
    
    public String BMIScale (double bmi){
        //bmi scale
        if(bmi < 18.5)
         return "underweight"; 
      else if(bmi < 25)
         return "normal";
      else if(bmi < 30)
         return"overweight";
      else
         return "obese";
    }
    
    
//    public static int update()

    //update user info
//     public boolean update(String type, String value) {
//        if (type.compareTo("height") == 0) {
//            int newVal = Integer.parseInt(value);
//            setHeight(newVal);
//            return true;
//
//        } else if (type.compareTo("weight") == 0) {
//            int newVal = Integer.parseInt(value);
//            setWeight(newVal);
//            return true;
//
//        } else if (type.compareTo("age") == 0) {
//            int newVal = Integer.parseInt(value);
//            setAge(newVal);
//            return true;
//
//        } else if (type.compareTo("goal") == 0) {
//            setGoal(value);
//            return true;
//
//        } else {
//            return false;
//        }
//
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setGoal(String goal) {
//        this.goal = goal;
//    }

 
}