package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.*;


public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public User findByPassport(String passport) {
        Set<User> find = treemap.keySet();
        Iterator<User> itr = find.iterator();
        User result = null;
        while(itr.hasNext()) {
            if(itr.next().getPassport().equals(passport)) {
               result = itr.next();
               break;
            }
        }return result;
    }

    public Account findAccountByRequisite(String passport, String requisite) {
        ArrayList<Account> list = this.treemap.get(findByPassport(passport));
        Account result = null;
        for (Account ac: list) {
            if(ac.getReqs().equals(requisite)) {
                result = ac;
                break;
            }
        } return result;
    }



    public void addAccountToUser(String passport, Account account) {
        this.treemap.get(findByPassport(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.treemap.get(findByPassport(passport)).remove(account);
    }

    public List<Account> getUserAccounts (String passport) {
        return this.treemap.get(findByPassport(passport));
    }

    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        return this.treemap.get(findByPassport(srcPassport)).contains(findAccountByRequisite(srcPassport, srcRequisite))
                && this.treemap.get(findByPassport(destPassport)).contains(findAccountByRequisite(destPassport, dstRequisite))
                && getActualAccount(findByPassport(srcPassport), findAccountByRequisite(srcPassport, srcRequisite)).transfer(
                getActualAccount(findByPassport(destPassport), findAccountByRequisite(destPassport, dstRequisite)), amount);
    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}