package oop.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    @Test
    public void include_correct_outputs(){
        App myApp = new App();
        int people = 8;
        int pizzas = 2;
        int slicesPerPizza = 8;

        int totalSlices = myApp.calcTotalSlices(pizzas, slicesPerPizza);
        int slicesPerPerson = myApp.calcPersonSlices(people, totalSlices);
        int leftovers = myApp.calcLeftovers(people, totalSlices);

        String actualMessage = myApp.generateMessage(people, pizzas, totalSlices, slicesPerPerson, leftovers);
        String expectedMessage = "8 people with 2 pizzas (16 slices)\n" +
                "Each person gets 2 pieces of pizza.\n" +
                "There are 0 leftover pieces.";

        assertEquals(expectedMessage, actualMessage);
    }
}
