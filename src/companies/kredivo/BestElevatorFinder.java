package companies.kredivo;

import companies.kredivo.entities.ElevatorOperationsInfo;

import java.util.List;

public class BestElevatorFinder {

    public static ElevatorOperationsInfo findBestElevatorToAllocateInSameDirection(int currentFloor, List<ElevatorOperationsInfo> inputElevators) {
        //going up
        int min = Integer.MAX_VALUE;
        ElevatorOperationsInfo minElevatorOperationsInfo = null;
        for (ElevatorOperationsInfo runningUpElevator : inputElevators) {
            int localCurrentFloor = runningUpElevator.getCurrentFloor();
            if (localCurrentFloor <= currentFloor) {
                int localMin = currentFloor - localCurrentFloor;
                if (localMin < min) {
                    min = localMin;
                    minElevatorOperationsInfo = runningUpElevator;
                }
            }
        }
        return minElevatorOperationsInfo;
    }

    public static ElevatorOperationsInfo findBestElevatorToAllocateFromIdle(int currentFloor, List<ElevatorOperationsInfo> inputElevators) {
        //going up
        int min = Integer.MAX_VALUE;
        ElevatorOperationsInfo minElevatorOperationsInfo = null;
        for (ElevatorOperationsInfo elevator : inputElevators) {
            int localCurrentFloor = elevator.getCurrentFloor();
            int localMin = Math.abs(currentFloor - localCurrentFloor);
            if (localMin < min) {
                min = localMin;
                minElevatorOperationsInfo = elevator;
            }

        }
        return minElevatorOperationsInfo;
    }

    public static ElevatorOperationsInfo findBestElevatorToAllocateFromGoingDownDirection(int currentFloor, List<ElevatorOperationsInfo> inputElevators) {
        //going up
        int min = Integer.MAX_VALUE;
        ElevatorOperationsInfo minElevatorOperationsInfo = null;
        for (ElevatorOperationsInfo elevator : inputElevators) {
            int localCurrentFloor = elevator.getCurrentFloor();
            int localMin = currentFloor + localCurrentFloor;
            if (localMin < min) {
                min = localMin;
                minElevatorOperationsInfo = elevator;
            }

        }
        return minElevatorOperationsInfo;
    }

    public static ElevatorOperationsInfo findBestElevatorToAllocateFromGoingUpDirection(int currentFloor, List<ElevatorOperationsInfo> inputElevators, int topFloor) {
        //going up
        int min = Integer.MAX_VALUE;
        ElevatorOperationsInfo minElevatorOperationsInfo = null;
        for (ElevatorOperationsInfo elevator : inputElevators) {
            int localCurrentFloor = elevator.getCurrentFloor();
            int localMin = (topFloor - currentFloor) + (topFloor - localCurrentFloor);
            if (localMin < min) {
                min = localMin;
                minElevatorOperationsInfo = elevator;
            }

        }
        return minElevatorOperationsInfo;
    }

}
