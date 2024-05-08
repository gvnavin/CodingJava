package companies.kredivo;

import companies.kredivo.entities.Direction;
import companies.kredivo.statuses.FloorSelectionOperationStatus;
import companies.kredivo.statuses.RequestLiftStatus;

public interface UserElevatorOperations {

    // outside of the lift
    // extension: to select the floor outside itself.
    RequestLiftStatus requestLiftAndSelectTheDirection(int currentFloor, Direction direction);

    FloorSelectionOperationStatus selectTheFloor(String elevatorId, int number);

}
