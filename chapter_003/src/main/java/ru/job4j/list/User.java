package ru.job4j.list;

public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private String city;
    private Integer age;

    public User (Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User (String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }
}
