package com.elpawluczoro.SimplyCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double firstNumber = 0;
        double secondNumber = 0;
        double result = 0;
        String operation;
        String operator = "blad";
        String check;

        System.out.println("Wpisz działanie: ");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine();
        for(int i=0; i<operation.length(); i++) {
            check = operation.substring(i, i+1);
            //System.out.println("check: " + check);
            if (((check.equals("+")) || (check.equals("-")) || (check.equals("*")) || (check.equals("/")))&&(operation.length() >= 3)){
                firstNumber = Double.parseDouble(operation.substring(0, i));
                //System.out.println("pierwszy: " + firstNumber);
                operator = check;
                //System.out.println("Operator: " + operator);
                break;
            }else if((check.equals(" "))&&(operation.length()>= 3)) {
                firstNumber = Double.parseDouble(operation.substring(0, i));
                //System.out.println("pierwszy: " + firstNumber);
                operator = operation.substring(i+1,i+2);
                //System.out.println("Operator: " + operator);
                break;
            }else {operator = "blad";}

        }
        for(int i=0; i<operation.length(); i++){
            check = operation.substring(operation.length()-1-i, operation.length()-i);
            if ((check.equals("+")) || (check.equals("-")) || (check.equals("*")) || (check.equals("/")) || (check.equals(" "))){
                secondNumber = Double.parseDouble(operation.substring(operation.length()-i, operation.length()));
                //System.out.println("drugi: " + secondNumber);
                break;
            }
        }

        switch (operator){
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> result = firstNumber / secondNumber;
            case "blad" -> System.out.println("Błąd, nie można wykonań takiego działania");
            case " " -> System.out.println("Błąd, nie znaleziono operatora działania");
            default -> System.out.println("Niespodziewany błąd");
        }

        if ((!operator.equals("blad")&&(!operator.equals(" ")))){
            System.out.println("Wynik działania: " + result);
        }
    }
}

