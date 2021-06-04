package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 8 - Pizza Party
Division isn’t always exact, and sometimes you’ll write programs that
will need to deal with the leftovers as a whole number instead of a
decimal.

Write a program to evenly divide pizzas. Prompt for the number of
people, the number of pizzas, and the number of slices per pizza.
Ensure that the number of pieces comes out even. Display the number
of pieces of pizza each person should get. If there are leftovers,
show the number of leftover pieces.

Example Output:
How many people? 8
How many pizzas do you have? 2
How many slices per pizza? 8
8 people with 2 pizzas (16 slices)
Each person gets 2 pieces of pizza.
There are 0 leftover pieces.

Challenges:
-Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
-Alter the output so it handles pluralization properly, for example:
 "Each person gets 2 pieces of pizza." or "Each person gets 1 piece
 of pizza." Handle the output for leftover pieces appropriately as well.
-Create a variant of the program that prompts for the number of people
 and the number of pieces each person wants, and calculate how many
 full pizzas you need to purchase.
 */

public class App
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        int people = myApp.getPeople();
        int pizzas = myApp.getPizzas();
        int slicesPerPizza = myApp.getPizzaSlices();

        int totalSlices = myApp.calcTotalSlices(pizzas, slicesPerPizza);
        int slicesPerPerson = myApp.calcPersonSlices(people, totalSlices);
        int leftovers = myApp.calcLeftovers(people, totalSlices);

        String message = myApp.generateMessage(people, pizzas, totalSlices, slicesPerPerson, leftovers);
        System.out.println(message);
    }

    public int getPeople(){
        System.out.print("How many people? ");
        int people = input.nextInt();
        return people;
    }

    public int getPizzas(){
        System.out.print("How many pizzas do you have? ");
        int pizzas = input.nextInt();
        return pizzas;
    }
    public int getPizzaSlices(){
        System.out.print("How many slices per pizza? ");
        int slices = input.nextInt();
        return slices;
    }

    public int calcTotalSlices(int pizzas, int slices){
        return (pizzas * slices);
    }

    public int calcPersonSlices(int people, int slices){
        return (slices / people);
    }

    public int calcLeftovers(int people, int slices){
        return (slices % people);
    }

    public String generateMessage(int people, int pizzas, int totalSlices, int slicesPerPerson, int leftovers){
        return people + " people with " + pizzas + " pizzas (" + totalSlices + " slices)\n" +
                "Each person gets " + slicesPerPerson + " pieces of pizza.\n" +
                "There are " + leftovers + " leftover pieces.";
    }
}
