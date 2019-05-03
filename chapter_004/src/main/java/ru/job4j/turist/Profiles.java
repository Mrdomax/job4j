package ru.job4j.turist;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        List<Address> turists = profiles.stream().map(
                profile -> profile.getAddress()
        ).collect(Collectors.toList());
        return turists;
    }
}
