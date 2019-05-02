package ru.job4j.bank;

public class User implements Comparable {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    public String getName() {
        return name;
    }
    public String getPassport() {
        return passport;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return this.passport.equals(user.passport);
    }

    public int hashCode() {
        return this.passport.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        int result = this.name.compareTo(user.name);
        return result;
    }
}
