package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void whenTransferThenAccountGetMoney() {
        Account account1 = new Account(100, "Abc");
        Account account2 = new Account(100, "Abc");
        account1.transfer(account2, 50);
        boolean expect = account1.values == 50 && account2.values == 150;
        assertThat(expect, is(true));
    }
}
