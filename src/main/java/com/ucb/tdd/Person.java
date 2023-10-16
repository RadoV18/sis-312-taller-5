package com.ucb.tdd;

public class Person {
    private int currentFloor;
    private int destinationFloor;

    public Person(int currentFloor, int destinationFloor) throws IllegalArgumentException {
        if (currentFloor == destinationFloor) {
            throw new IllegalArgumentException("Floors cannot be equal");
        }
        if(currentFloor < 1 || destinationFloor < 1) {
            throw new IllegalArgumentException("Floors cannot be less than 1");
        }
        if(currentFloor > 3 || destinationFloor > 3) {
            throw new IllegalArgumentException("Floors cannot be greater than 3");
        }

        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

    public void setCurrentFloor(int floor) {

        this.currentFloor = floor;
    }

    public void setDestinationFloor(int floor) {
        this.destinationFloor = floor;
    }
}
