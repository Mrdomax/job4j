package ru.job4j.bank;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    //Проверяем что юзер добавляется в treemap методом addUser()
    public void whenAddUserThanTreeMapGotIt() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        bank.addUser(user1);
        assertThat(bank.treemap.containsKey(user1), is(true));
    }
    @Test
    //Проверяем что keySet() работает после определения compareTo() в классе User
    public void whenAddUsersThanTreeMapGotIt() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        User user2 = new User("Alex", "A002");
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.treemap.keySet().size(), is(2));
    }

    @Test
    //Проверяем что юзер удаляется методом deleteUser()
    public void whenDeleteUserThanUserGone() {
        Bank bank = new Bank();
        User user = new User("Artiom", "A001");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.treemap.containsKey(user), is(false));
    }

    @Test
    //Проверяем работу метода findByPassport()
    public void whenFindByPassportThanReturnUser() {
        Bank bank = new Bank();
        User user2 = new User("Alex", "A002");
        bank.addUser(user2);
        assertThat(bank.findByPassport("A002").getName(), is("Alex"));
    }

    @Test
    //Проверяем метод findAccountByRequisite()
    public void whenFindAccountByRequisiteThanReturnAccount() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        bank.addUser(user1);
        bank.add(user1, account);
        assertThat(bank.findAccountByRequisite("A001", "AO Sun"), is(account));
    }

    @Test
    //Проверяем метод addAccountToUser()
    public void whenAddAccountToUserThanUserHasAccount() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        bank.addUser(user1);
        bank.addAccountToUser("A001", account);
        assertThat(bank.findAccountByRequisite("A001", "AO Sun"), is(account));
    }

    @Test
    //Проверяем метод deleteAccountFromUser()
    public void whenDeleteAccountFromUserThanUserHasNoThisAccount() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        bank.addUser(user1);
        bank.add(user1, account);
        bank.deleteAccountFromUser("A001", account);
        Account result = null;
        assertThat(bank.findAccountByRequisite("A001", "AO Sun"), is(result));
    }

    @Test
    //Проверяем что метод getUserAccounts() выдаёт ArrayList<Account> со всеми аккаунтами пользователя
    public void whenGetUserAccountsThanReturnList() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        Account account1 = new Account(300, "AO Vun");
        bank.addUser(user1);
        bank.add(user1, account);
        bank.add(user1, account1);
        ArrayList<Account> expected = new ArrayList<>();
        expected.add(account);
        expected.add(account1);
        assertThat(bank.getUserAccounts("A001").equals(expected), is(true));
    }

    @Test
    //Проверяем метод transferMoney() что аккаунты меняют значение values
    public void whenTransferMoneyThanAccountsChangeValues() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        Account account1 = new Account(300, "AO Vun");
        bank.addUser(user1);
        bank.add(user1, account);
        bank.add(user1, account1);
        bank.transferMoney("A001", "AO Sun", "A001", "AO Vun", 100);
        boolean expect = account.values == 100 && account1.values == 400;
        assertThat(expect, is(true));
    }

    @Test
    //Проверяем метод transferMoney() когда аккаунт не найден
    public void whenTransferMoneyWrongAccountThenReturnFalse() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(200, "AO Sun");
        Account account1 = new Account(300, "AO Vun");
        bank.addUser(user1);
        bank.add(user1, account);
        bank.add(user1, account1);
        assertThat(bank.transferMoney("A001", "AO Sun1", "A001", "AO Vun", 100), is(false));
    }
    @Test
    //Проверяем метод transferMoney() когда недостаточно денег для перевода
    public void whenTransferMoneyNotEnoughThenReturnFalse() {
        Bank bank = new Bank();
        User user1 = new User("Artiom", "A001");
        Account account = new Account(100, "AO Sun");
        Account account1 = new Account(300, "AO Vun");
        bank.addUser(user1);
        bank.add(user1, account);
        bank.add(user1, account1);
        assertThat(bank.transferMoney("A001", "AO Sun", "A001", "AO Vun", 1000), is(false));
    }
}
