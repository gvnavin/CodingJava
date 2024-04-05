package practice.kredivo;

public interface SystemElevatorOperations {

    void setElevatorsCurrentFloor(String elevatorId, int floor);

    void changeDirectionToUp(String elevatorId);

    void changeDirectionToDown(String elevatorId);
}
