package practice.kredivo;

import practice.kredivo.entities.Direction;
import practice.kredivo.statuses.FloorSelectionOperationStatus;
import practice.kredivo.statuses.RequestLiftStatus;

public interface UserElevatorOperations {

    // outside of the lift
    // extension: to select the floor outside itself.
    RequestLiftStatus requestLiftAndSelectTheDirection(int currentFloor, Direction direction);

    FloorSelectionOperationStatus selectTheFloor(String elevatorId, int number);

}
