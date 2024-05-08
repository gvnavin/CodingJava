package companies.kredivo.entities;

import java.util.ArrayList;
import java.util.List;

public class ElevatorOperationsInfo {
    public ElevatorOperationsInfo(Elevator elevator, Direction direction, int currentFloor, List<Integer> floorsToStop) {
        this.elevator = elevator;
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.floorsToStop = floorsToStop;
    }

    public ElevatorOperationsInfo(Elevator elevator) {
        this.elevator = elevator;
        this.direction = Direction.IDLE;
        this.currentFloor = 0;
        this.floorsToStop = new ArrayList<>();
    }

    private Elevator elevator;

    private Direction direction;

    private int currentFloor;

    private List<Integer> floorsToStop;

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Integer> getFloorsToStop() {
        return floorsToStop;
    }

    public void setFloorsToStop(List<Integer> floorsToStop) {
        this.floorsToStop = floorsToStop;
    }
}
