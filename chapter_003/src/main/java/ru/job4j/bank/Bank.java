package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.*;
import java.util.stream.Collectors;


public class Bank {

    public TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

//    public User findByPassport(String passport) {
//        Set<User> find = treemap.keySet();
//        User result = null;
//        for (User aa: find) {
//            if (aa.getPassport().equals(passport)) {
//                result = aa;
//                break;
//            }
//        } return result;
//    }

    public User findByPassport(String passport) {
        Set<User> find = treemap.keySet();
        User result = find.stream().filter(x -> x.getPassport().equals(passport)).findFirst().orElse(null);
        return result;
    }

    //    public Account findAccountByRequisite(String passport, String requisite) {
//        Account result = null;
//        User user = findByPassport(passport);
//        if (user != null) {
//            ArrayList<Account> list = this.treemap.get(user);
//            for (Account ac : list) {
//                if (ac.getReqs().equals(requisite)) {
//                    result = ac;
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    public Account findAccountByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            ArrayList<Account> list = this.treemap.get(user);
            result = list.stream().filter(e -> e.getReqs().equals(requisite)).findFirst().orElse(null);
        }
        return result;
    }


    public void addAccountToUser(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            this.treemap.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            this.treemap.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = this.treemap.get(findByPassport(passport));
        return result;
    }

    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        Account srcAccount = findAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = findAccountByRequisite(destPassport, dstRequisite);
        if (amount > 0
                && srcUser != null
                && destUser != null
                && srcAccount != null
                && destAccount != null
                && srcAccount.values >= amount) {
            result = srcAccount.transfer(destAccount, amount);
        }
        return result;
    }

//    private Account getActualAccount(User user, Account account) {
//        ArrayList<Account> list = this.treemap.get(user);
//        Account result = null;
//        for (Account aa: list) {
//            if (aa.equals(account)) {
//                result = list.get(list.indexOf(account));
//                break;
//            }
//        }
//        return result;
//    }

    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        Account result = list.stream().filter(e -> e.equals(account)).findFirst().orElse(null);
        return result;
    }


    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}