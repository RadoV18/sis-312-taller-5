package com.ucb.tdd;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import static org.junit.Assert.*;

public class ElevatorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void elevatorStartsOnFirstFloor() {
        Elevator elevator = new Elevator();
        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    public void elevatorCapacityIsOne() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(1, 2);
        Person person2 = new Person(1, 2);

        elevator.createPerson(person);

        exception.expect(Exception.class);
        elevator.createPerson(person2);
    }

    @Test
    public void elevatorGoesUp() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(1, 2);

        elevator.createPerson(person);
        elevator.goToDestination();
        assertEquals(true, elevator.isGoingUp());
    }

    @Test
    public void elevatorGoesDown() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(3, 1);

        elevator.createPerson(person);
        elevator.pickUp();
        elevator.goToDestination();
        assertEquals(false, elevator.isGoingUp());
    }

    @Test
    public void elevatorWontGoToDestinationIfEmpty() throws Exception {
        Elevator elevator = new Elevator();

        exception.expect(Exception.class);
        elevator.goToDestination();
    }

    @Test
    public void elevatorWontPickUpIfEmpty() throws Exception {
        Elevator elevator = new Elevator();

        exception.expect(Exception.class);
        elevator.pickUp();
    }

    @Test
    public void elevatorWontDropOffIfEmpty() throws Exception {
        Elevator elevator = new Elevator();

        exception.expect(Exception.class);
        elevator.dropOff();
    }

    @Test
    public void elevatorPicksUpPerson() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(3, 2);

        elevator.createPerson(person);
        elevator.pickUp();
        assertEquals(3, elevator.getCurrentFloor());
    }

    @Test
    public void elevatorWontDropOffIfNotAtDestination() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(3, 2);

        elevator.createPerson(person);
        elevator.pickUp();

        exception.expect(Exception.class);
        elevator.dropOff();
    }

    @Test
    public void elevatorGoesToDestination() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(3, 2);

        elevator.createPerson(person);
        elevator.pickUp();
        elevator.goToDestination();
        assertEquals(2, elevator.getCurrentFloor());
    }

    @Test
    public void elevatorDropsOffPerson() throws Exception {
        Elevator elevator = new Elevator();
        Person person = new Person(3, 2);

        elevator.createPerson(person);
        elevator.pickUp();
        elevator.goToDestination();
        elevator.dropOff();
        assertNull(elevator.getPerson());
    }

    @Test
    public void elevatorWithRandomPerson() throws Exception {
        Elevator elevator = new Elevator();

        elevator.createPerson();
        elevator.pickUp();
        elevator.goToDestination();
        elevator.dropOff();
        assertNull(elevator.getPerson());
    }
}
