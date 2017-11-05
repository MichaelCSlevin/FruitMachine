package com.example.michaelslevin.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static android.R.attr.value;
import static java.sql.Types.ARRAY;
import static org.junit.Assert.assertEquals;

/**
 * Created by michaelslevin on 03/11/2017.
 */

public class FruitMachineTest {
    FruitMachine fruitMachine;
    ArrayList<Symbol> slots;
    FruitMachine spyFruitMachine;
//declares properties needed for each object


    @Before
    public void setUp() throws Exception {
        fruitMachine = new FruitMachine(3);
        spyFruitMachine = Mockito.spy(fruitMachine);
    }

    @Test
    public void testWinSpin(){
        slots = new ArrayList<Symbol>();
        slots.add(Symbol.BAR);
        slots.add(Symbol.BAR);
        slots.add(Symbol.BAR);

        //instantiates test fruit machine for test

        Mockito.when(spyFruitMachine.getRandomSymbol())
                .thenReturn(Symbol.BAR)
                .thenReturn(Symbol.BAR)
                .thenReturn(Symbol.BAR);

        //changes fruit machine properties to the ones we want, this time winning



        int value = spyFruitMachine.spin();
        assertEquals(slots, spyFruitMachine.getSlots());
        assertEquals(8, value);
    }

    @Test
    public void testLoseSpin(){
        slots = new ArrayList<Symbol>();
        slots.add(Symbol.PEAR);
        slots.add(Symbol.CHERRY);
        slots.add(Symbol.LEMON);

        //instantiates test fruit machine for test

        Mockito.when(spyFruitMachine.getRandomSymbol())
                .thenReturn(Symbol.PEAR)
                .thenReturn(Symbol.CHERRY)
                .thenReturn(Symbol.LEMON);

        //changes fruit machine properties to the ones we want, this time losing
        int value = spyFruitMachine.spin();
        assertEquals(slots, spyFruitMachine.getSlots());
        assertEquals(0, value);

    }



}
