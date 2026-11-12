package com.temperature.temperature_converter1;
import java.util.Scanner;

public class App {

    public static double convert(double temperature,
                                 String from, String to) {

        double celsius;

        // Convert to Celsius first
        switch (from.toUpperCase()) {
            case "C":
                celsius = temperature;
                break;

            case "F":
                celsius = (temperature - 32) * 5 / 9;
                break;

            case "K":
                celsius = temperature - 273.15;
                break;

            default:
                throw new IllegalArgumentException(
                    "Invalid source scale");
        }

        if (celsius < -273.15) {
            throw new IllegalArgumentException(
                "Temperature below absolute zero");
        }

        // Convert Celsius to required scale
        switch (to.toUpperCase()) {
            case "C":
                return celsius;

            case "F":
                return (celsius * 9 / 5) + 32;

            case "K":
                return celsius + 273.15;

            default:
                throw new IllegalArgumentException(
                    "Invalid target scale");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("---------------------");

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        System.out.print("From scale (C/F/K): ");
        String from = sc.next();

        System.out.print("To scale (C/F/K): ");
        String to = sc.next();

        try {
            double result = convert(temp, from, to);

            System.out.printf(
                "Converted Temperature: %.2f %s%n",
                result, to.toUpperCase());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
