package com.thou.healthy;

import com.thou.health.core.BmiCalculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("BMI 70kg and 1.75m: " + BmiCalculator.getBmi(70, 1.75));
    }
}