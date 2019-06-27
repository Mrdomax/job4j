package ru.job4j.collections.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {

    @Test
    public void whenFindByIdThanReturnObject() {
        UserStore userStore = new UserStore(2);
        User user = new User("Kasha");
        User user1 = new User("Kasha1");
        userStore.add(user);
        userStore.add(user1);
        assertThat(userStore.findById("Kasha1").equals(user1), is(true));
    }

    @Test
    public void whenRoleStoreGetIndexThanReturnInt() {
        RoleStore roleStore = new RoleStore(2);
        Role role = new Role("Kasha");
        Role role1 = new Role("Masha");
        roleStore.add(role);
        roleStore.add(role1);
        assertThat(roleStore.getIndex(role1), is(1));
    }

    @Test
    public void whenUserStoreGetIndexThanReturnInt() {
        UserStore userStore = new UserStore(2);
        User user = new User("Kasha");
        User user1 = new User("Masha");
        userStore.add(user);
        userStore.add(user1);
        assertThat(userStore.getIndex(userStore.findById("Masha")), is(1));
    }

    @Test
    public void whenAddUserThenUserStoreHasUser() {
        UserStore userStore = new UserStore(1);
        User user = new User("Kasha");
        userStore.add(user);
        assertThat(userStore.findById("Kasha").getId(), is("Kasha"));
    }

    @Test
    public void whenAdRoleThanRoleStoreHasRole() {
        RoleStore roleStore = new RoleStore(1);
        Role role = new Role("Malasha");
        roleStore.add(role);
        assertThat(roleStore.findById("Malasha").getId(), is("Malasha"));
    }

    @Test
    public void whenReplaceUserStore() {
        UserStore userStore = new UserStore(1);
        User user = new User("Kasha");
        User user1 = new User("Malasha");
        userStore.add(user);
        userStore.replace("Kasha", user1);
        assertThat(userStore.findById("Malasha").getId(), is("Malasha"));
    }

    @Test
    public void whenDelete() {
        UserStore userStore = new UserStore(2);
        User user = new User("Kasha");
        User user1 = new User("Malasha");
        userStore.add(user);
        userStore.add(user1);
        userStore.delete("Kasha");
        assertThat(userStore.getIndex(user1), is(0));
    }

}