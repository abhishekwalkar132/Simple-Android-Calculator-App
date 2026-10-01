package com.example.calculator;

public class CalculatorEngine {

    private double memory = 0.0;

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }

    public double sqrt(double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException("Negative for sqrt");
        }
        return Math.sqrt(value);
    }

    public double toggleSign(double value) {
        return -value;
    }

    public void memoryClear() {
        memory = 0.0;
    }

    public void memoryAdd(double value) {
        memory += value;
    }

    public void memorySubtract(double value) {
        memory -= value;
    }

    public double memoryRecall() {
        return memory;
    }

    public double getMemory() {
        return memory;
    }
}
