/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat.pkg1.pkg319191;

import java.util.Scanner;

/**
 *
 * @author Cedric Jansen
 */
public class Viruscalculator {

    //Represents the number of infections when starting the calculation.
    private static int infectionsAtStart;

    //Represents the amount of weeks used in the caluclation.
    private static int weekCalculationAmount;

    // Is the number of current infections in week x.
    private static int currentInfections;

    //Is the number of current deaths in week.
    private static int currentDeaths;

    // Represents the percentage amount of infection increase per week.
    private static double weeklyInfectionIncrease;

    //Represents the percentage amount of deaths per week.
    private static double mortalityRate;

    //Output messages for the parsing methods.
    private static  String infectedPeopleOutputError = "The given input for the infected persons cannot be converted into a int.";
    private static  String weekAmountOutputError = "The given input for the week amount cannot be converted into a int.";
    private static  String infectionIncreaseRateError = "The given input for the increase of infections cannot be converted into a valid double.\n Use a value between 0 and 100.";
    private static  String mortalityRateError = "The given input for the mortality rate of infections cannot be converted into a valid double.\n Use a value between 0 and 100.";
    
    
    
    public static void main(String[] args) {
        System.out.println("Testat 1 - Viruscalculator:");

        // At least one argument is present, here the amout of persons at start.
        if (args.length >= 1) {
            // Check if the given argument for infectionsAtStart can be parsed
            // into an integer.
            infectionsAtStart = parseInputStringToInteger(args[0], infectedPeopleOutputError);
        }

        // At least two arguments are given: persons at start, week amount
        if (args.length >= 2) {
            // Check if the given argument for weekCalculationAmount can be parsed
            // into an integer.
            weekCalculationAmount = parseInputStringToInteger(args[1], weekAmountOutputError);
        }

        // At least three arguments are given: persons at start, week amount and
        // percentage of the infection increase.
        if( args.length >= 3 ) {
            // Check if the given argument for weeklyInfectionIncrease can be parsed
            // into a double and whether the value is larger than 0.0 and smaller than 100.
            weeklyInfectionIncrease = parseInputStringToDouble(args[2], infectionIncreaseRateError);
        }

        // All needed arguments are present.
        if( args.length >= 4 ) {
            // Check if the given argument for mortality rate can be parsed
            // into a double and whether the value is larger than 0.0 and smaller than 100.
            mortalityRate = parseInputStringToDouble(args[2], mortalityRateError);
        }
        
        // Since we are partly working with percentages, we need to modify the values before
        // starting the calculation
        weeklyInfectionIncrease = weeklyInfectionIncrease / 100;
        mortalityRate = mortalityRate / 100;

        // Calculates the increasing infections and deaths for a given
        // amount of weeks.
        calculateInfection(weekCalculationAmount);
    }

    // Checks whether a string representing an integer is given
    // If not, asks user to input another value and then checks the
    // the input.
    // If input string equals an integer      --> success, continue programm
    // If input does not represent an integer --> ask user for new input
    // This method is used since it makes no sense to set the starting population to
    // a random number or 0,1.
    private static Integer parseInputStringToInteger(String inputString, String outputMessage) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            // The result string stores the final result of which the integer value is returned.
            String result;
            // The Scanner is used to recieve user input.
            Scanner scanner = new Scanner(System.in);
            // Trim the input to eliminate spaces in front and at the end of the string
            // before checking the length.
            result = inputString.trim();
            
            // Check if the trimmed argument string is at least one char long and
            // represents an integer with the help of a regular expression.
            // \ escapes the next character, passing "\d+" to the interpreter.
            // \d represents a digit from 0-9, plus causes the regex to iterate through
            //the whole string.
            while (result.length() < 1 || !result.matches("\\d+")) {
                System.out.println(outputMessage);
                System.out.println("Please try again with an integer number: ");
                // Wait for a user input and store it
                result = scanner.next();
            }
            // Can return the integer value of the string because it is 
            // guaranteed that result represents a string containing a positive integer.
            return Integer.valueOf(result);
        }
    }
    
    
    
    // Checks if the input String can be converted into a double value, if not,
    // sets the output rate to 0.0.
    private static Double parseInputStringToDouble(String inputString, String outputMessage) {
        try {
            return Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            // The result string stores the final result of which the double value is returned.
            String input;
            Double result = 0.0;
            // The Scanner is used to recieve user input.
            Scanner scanner = new Scanner(System.in);

            while (result <= 0.0 || result > 100.0) {
                System.out.println(outputMessage);
                System.out.println("Please try again with a double value: ");
                input = scanner.next();
                // Trim the input to eliminate spaces in front and at the end of the string
                // before parsing.
                input = input.trim();
                try {
                    result = Double.parseDouble(input);
                } catch(NumberFormatException ex) {
                    result = 0.0;
                } 
            }           
            return result;
        }
    }

    private static void calculateInfection(int repeats) {
        for (int i = 1; i < repeats + 1; i++) {
            if (i == 1) {
                printWeek();
                currentInfections = infectionsAtStart;
            } else {
                currentInfections = currentInfections + (int) Math.round(currentInfections * weeklyInfectionIncrease);
            }
            currentDeaths = (int) Math.round(currentInfections * mortalityRate);
            printWeek(i, currentInfections, currentDeaths);
        }
    }

    private static void printWeek() {
        System.out.format("%s%14s%10s\n", "Week", "Infections", "Deaths");
    }

    private static void printWeek(int weekNumber, int infections, int deaths) {
        System.out.format("%4d%14d%10d\n", weekNumber, infections, deaths);
    }

}
