package ru.job4j.collections.generic;

public class RoleStore extends AbstractStore<Role> {

    public RoleStore(int size) {
        super.simpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(Role model) {
        simpleArray.add(model);
    }
}
