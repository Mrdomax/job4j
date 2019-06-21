package ru.job4j.collections.generic;


public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super.simpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(User model) {
        simpleArray.add(model);
    }
}
