package com.example.task3;
public class CalculatorLogic {

    private double firstOperand = 0;
    private double secondOperand = 0;
    private String operation = "";
    private double memory = 0;
    private boolean isOperatorPressed = false;

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double calculate() {
        switch(operation) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    return Double.NaN; // Not a Number for division by zero
                }
            case "sqrt":
                return Math.sqrt(firstOperand);
            default:
                return 0;
        }
    }

    public void memoryClear() {
        memory = 0;
    }

    public void memoryStore(double value) {
        memory = value;
    }

    public void memoryAdd(double value) {
        memory += value;
    }

    public void memorySubtract(double value) {
        memory -= value;
    }

    public double calculate(double firstOperand, double secondOperand, String operation) {
        return firstOperand;
    }

}