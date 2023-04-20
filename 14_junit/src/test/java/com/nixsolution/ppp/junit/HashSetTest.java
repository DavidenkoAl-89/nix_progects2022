package com.nixsolution.ppp.junit;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class HashSetTest {

    private Set<String> set = new HashSet<>();
    private final String[] array = new String[]{
            "first", "second", "third"
    };

    @Test
    public void shouldAddElement() {
        assertTrue(set.add("String Added"));
        assertEquals(1, set.size());
    }

    @Test
    public void shouldSearchForElement() {
        set = new HashSet<>(Set.of(array));
        assertTrue(set.contains("second"));
    }

    @Test
    public void shouldRemoveElement() {
        set = new HashSet<>(Set.of(array));
        assertTrue(set.remove("first"));
        assertEquals(2, set.size());
    }

    @Test
    public void shouldClearHashSet() {
        set = new HashSet<>(Set.of(array));
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    public void shouldReturnSize() {
        set = new HashSet<>(Set.of(array));
        assertEquals(3, set.size());
    }

    @Test
    public void shouldCheckForEmpty() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void canAddNull() {
        set.add(null);
        assertFalse(set.isEmpty());
    }

    @Test
    public void noDuplicate() {
        set = new HashSet<>(Set.of(array));
        set.add("first");
        assertEquals(3, set.size());
    }
}