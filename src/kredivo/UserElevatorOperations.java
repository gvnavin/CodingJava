package kredivo;

import kredivo.entities.Direction;
import kredivo.statuses.FloorSelectionOperationStatus;
import kredivo.statuses.RequestLiftStatus;

public interface UserElevatorOperations {

    // outside of the lift
    // extension: to select the floor outside itself.
    RequestLiftStatus requestLiftAndSelectTheDirection(int currentFloor, Direction direction);

    FloorSelectionOperationStatus selectTheFloor(String elevatorId, int number);

}
