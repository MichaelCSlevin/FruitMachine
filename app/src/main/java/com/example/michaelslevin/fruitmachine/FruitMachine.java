package com.example.michaelslevin.fruitmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelslevin on 03/11/2017.
 */

public class FruitMachine {

    ArrayList<Symbol> slots;
    int numberOfSlots;

    public FruitMachine(int numberOfSlots) {
        this.slots = new ArrayList<Symbol>();
        this.numberOfSlots = numberOfSlots;
    }

    public ArrayList<Symbol> getSlots() {
        return slots;
    }


    public Symbol getRandomSymbol() {
        Random randomObject = new Random(); //makes new random object. Used for generating random numbers
        Symbol[] values = Symbol.values(); //values is the list of symbol  objects. This is a built in method for java enums.
        int numberOfSymbols = values.length; // gives length of symbols in Symbols array
        int taken = randomObject.nextInt(numberOfSymbols); //takes a random number between zero and the number of different symbols (e.g. lemon, etc)
        return Symbol.values()[taken]; //.values is different from enum value
    }

    public int spin() {
        for (int i = 0; i < numberOfSlots; i++) {
            Symbol fruit = getRandomSymbol();
            slots.add(i, fruit); //adds symbols to slots arraylist for comparison
        }
        return winOrLose(); //decides if win condition or lose condition is met
    }

    public int winOrLose() {
        Symbol firstFruit = slots.get(0);
        for (int i = 0; i < numberOfSlots; i++) {
            if (firstFruit != slots.get(i)) {
                return 0; //returns 0 if first symbol in array list does not match every other symbol in arraylist
            }
        }
        return firstFruit.value; //returns value of winning symbol
    }




}





