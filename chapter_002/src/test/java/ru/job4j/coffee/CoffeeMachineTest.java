package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void coffeeMachineReturnAllKindOfChange() {
        CoffeeMachine keepChange = new CoffeeMachine();
        int[] expect = {10, 5, 2, 1};
        assertThat(keepChange.coffeeMachine(20, 2), is(expect));
    }
}
