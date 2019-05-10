package ru.job4j.turist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Profiles {
    Comparator<Address> comparator = new Comparator<Address>() {
        public int compare(Address o1, Address o2) {
            return o1.getCity().compareTo(o2.getCity());
        }
    };

    List<Address> collect(List<Profile> profiles) {
        List<Address> turists = profiles.stream().map(
                profile -> profile.getAddress()
        ).sorted(comparator).distinct().collect(Collectors.toList());
        return turists;
    }
}
