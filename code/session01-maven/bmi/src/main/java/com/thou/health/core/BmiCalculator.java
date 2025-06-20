package com.thou.health.core;

public class BmiCalculator {
    //hàm static tính chỉ số khối cơ thể dựa trên cân nặng và chiều cao
    //công thức tính BMI = weight / (height * height)

    public static double getBmi(double weight, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

//    public static String getBmiCategory(double bmi) {
//        if (bmi < 18.5) {
//            return "Underweight";
//        } else if (bmi < 24.9) {
//            return "Normal weight";
//        } else if (bmi < 29.9) {
//            return "Overweight";
//        } else {
//            return "Obesity";
//        }
//    }
}
