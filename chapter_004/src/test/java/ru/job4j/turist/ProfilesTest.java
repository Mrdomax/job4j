package ru.job4j.turist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollectAddressesThenListOfAddresses() {
        Profiles profiles1 = new Profiles();
        Address address1 = new Address();
        Address address2 = new Address();
        Address address3 = new Address();
        Profile profile1 = new Profile();
        Profile profile2 = new Profile();
        Profile profile3 = new Profile();
        profile1.setAddress(address1);
        profile2.setAddress(address2);
        profile3.setAddress(address3);
        List<Profile> profiles = Arrays.asList(profile1, profile2, profile3);
        List<Address> expected = Arrays.asList(address1, address2, address3);
        List<Address> result = profiles1.collect(profiles);
        assertThat(result.equals(expected), is(true));
    }
}
