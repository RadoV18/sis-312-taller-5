package com.ucb.tdd;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.junit.Rule;

public class PersonTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void floorsCannotBeEqual() {
        exception.expect(IllegalArgumentException.class);
        new Person(1, 1);
    }

    @Test
    public void floorsCannotBeLessThanOne() {
        exception.expect(IllegalArgumentException.class);
        new Person(0, 1);
    }

    @Test
    public void floorsCannotBeGreaterThanThree() {
        exception.expect(IllegalArgumentException.class);
        new Person(1, 4);
    }
}
