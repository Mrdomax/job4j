package ru.job4j.turist;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address address = (Address) o;

        return this.city.equals(address.city);
    }

    public int hashCode() {
        return this.city.hashCode();
    }
}


