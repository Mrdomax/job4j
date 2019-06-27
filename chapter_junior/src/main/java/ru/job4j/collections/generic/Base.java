package ru.job4j.collections.generic;

import java.util.Objects;

/**
 * @author Semenchenko
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id != null && id.equals(base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
