package com.ucb.tdd;

import java.util.Random;

public class Elevator {
    private final int MAX_FLOORS = 3;

    private int currentFloor;
    private Person person;
    private boolean goingUp;

    public Elevator() {
        this.currentFloor = 1;
        this.person = null;
        this.goingUp = true;
    }

    public void createPerson() throws Exception {
        Random random = new Random();
        int currentFloor = random.nextInt(MAX_FLOORS) + 1;
        int destinationFloor = random.nextInt(MAX_FLOORS) + 1;
        while(currentFloor == destinationFloor) {
            destinationFloor = random.nextInt(MAX_FLOORS) + 1;
        }
        Person newPerson = new Person(currentFloor, destinationFloor);
        this.createPerson(newPerson);
    }

    public void createPerson(Person person) throws Exception {
        if (this.person != null) {
            throw new Exception("Elevator is full");
        }
        this.person = person;
    }

    public void pickUp() throws Exception {
        if (this.person == null) {
            throw new Exception("Elevator is empty");
        }
        if(this.currentFloor < this.person.getCurrentFloor()) {
            this.goingUp = true;
        } else {
            this.goingUp = false;
        }
        this.currentFloor = this.person.getCurrentFloor();
    }

    public void goToDestination() throws Exception {
        if (this.person == null) {
            throw new Exception("Elevator is empty");
        }
        if(this.currentFloor < this.person.getDestinationFloor()) {
            this.goingUp = true;
        } else {
            this.goingUp = false;
        }
        this.currentFloor = this.person.getDestinationFloor();
    }

    public void dropOff() throws Exception {
        if (this.person == null) {
            throw new Exception("Elevator is empty");
        }
        if(this.currentFloor != this.person.getDestinationFloor()) {
            throw new Exception("Elevator is not at destination floor");
        }
        this.person = null;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setCurrentFloor(int floor) {
        if (floor < 1 || floor > MAX_FLOORS) {
            throw new IllegalArgumentException("Invalid floor");
        }
        this.currentFloor = floor;
    }

    public boolean isGoingUp() {
        return this.goingUp;
    }
}
