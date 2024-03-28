package kredivo;

import kredivo.entities.Building;
import kredivo.entities.Direction;
import kredivo.entities.Elevator;
import kredivo.entities.ElevatorOperationsInfo;
import kredivo.statuses.FloorSelectionOperationStatus;
import kredivo.statuses.RequestLiftStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Orchestrator implements UserElevatorOperations, SystemElevatorOperations {

    //can i assume initially all floors in zero th floor.
    public Orchestrator(Building building) {
        this.building = building;

        for (Elevator elevator : this.building.getElevators()) {
            ElevatorOperationsInfo elevatorOperationsInfo = new ElevatorOperationsInfo(elevator);
            idleElevators.add(elevatorOperationsInfo);
            elevatorIdToElevatorOperationsInfoMap.put(elevatorOperationsInfo.getElevator().getElevatorId(), elevatorOperationsInfo);
        }

    }

    private Building building;

    private HashMap<String, ElevatorOperationsInfo> elevatorIdToElevatorOperationsInfoMap = new HashMap<>();

    //
    private List<ElevatorOperationsInfo> idleElevators;
    private List<ElevatorOperationsInfo> runningUpElevators = new ArrayList<>();
    private List<ElevatorOperationsInfo> runningDownElevators = new ArrayList<>();;

    //currently not used, since we are finding the elevator synchronously
    //we can use it when all elevators are busy and not available, that time we can store it in this.
    //some periodic thread running to check whether this list is always empty.
    //we can do schedule the thread when the items are added to the list as well.
    //to keep it simple, we can show some erorrs to user, but not a great CX.
    private List<Integer> outstandingUserRequests = new ArrayList<>();

    //FCFS basis
    @Override
    public synchronized RequestLiftStatus requestLiftAndSelectTheDirection(int currentFloor, Direction direction) {

        //resource optimization
        ElevatorOperationsInfo bestElevatorToAllocate = BestElevatorFinder.findBestElevatorToAllocateFromIdle(currentFloor, idleElevators);
        if (bestElevatorToAllocate != null) {
            bestElevatorToAllocate.getFloorsToStop().add(currentFloor);
            idleElevators.remove(bestElevatorToAllocate);
            if (currentFloor > bestElevatorToAllocate.getCurrentFloor()) {
                runningUpElevators.add(bestElevatorToAllocate);
            } else {
                runningDownElevators.add(bestElevatorToAllocate);
            }

            return RequestLiftStatus.ALLOCATED;
        }

        if (direction == Direction.UP) {
            ElevatorOperationsInfo minElevatorOperationsInfo = BestElevatorFinder.findBestElevatorToAllocateInSameDirection(currentFloor, runningUpElevators);
            if (minElevatorOperationsInfo != null) {
                minElevatorOperationsInfo.getFloorsToStop().add(currentFloor);
                return RequestLiftStatus.ALLOCATED;
            }
        }

        ElevatorOperationsInfo bestElevatorToAllocateFromGoingDownDirection = BestElevatorFinder.findBestElevatorToAllocateFromGoingDownDirection(currentFloor, runningDownElevators);
        if (bestElevatorToAllocateFromGoingDownDirection != null) {
            bestElevatorToAllocateFromGoingDownDirection.getFloorsToStop().add(currentFloor);
            //elevator reached the zero, it goes up, if there is an entry in the Floors To Stop
            //this will be trigged by system events, there is an interface method to handle the case.
            return RequestLiftStatus.ALLOCATED;
        }

        //find minimum
        ElevatorOperationsInfo bestElevatorToAllocateFromGoingUpDirection = BestElevatorFinder.findBestElevatorToAllocateFromGoingUpDirection(currentFloor, runningUpElevators, building.getNoOfFloors());
        if (bestElevatorToAllocateFromGoingUpDirection != null) {
            bestElevatorToAllocateFromGoingUpDirection.getFloorsToStop().add(currentFloor);
            //elevator reached the zero, it goes up, if there is an entry in the Floors To Stop
            //this will be trigged by system events, there is an interface method to handle the case.
            return RequestLiftStatus.ALLOCATED;
        }

        //unknown worst case scenario
        //outstandingUserRequests.add(currentFloor)
        return null;
    }

    @Override
    public synchronized FloorSelectionOperationStatus selectTheFloor(String elevatorId, int floorNumber) {
        elevatorIdToElevatorOperationsInfoMap.get(elevatorId).getFloorsToStop().add(floorNumber);
        return FloorSelectionOperationStatus.SUCCESS;
    }

    @Override
    public synchronized void setElevatorsCurrentFloor(String elevatorId, int floor) {
        //i assumed the elevators will be present in this map in the initialization.
        elevatorIdToElevatorOperationsInfoMap.get(elevatorId).setCurrentFloor(floor);
    }

    @Override
    public void changeDirectionToUp(String elevatorId) {
        ElevatorOperationsInfo elevatorOperationsInfo = elevatorIdToElevatorOperationsInfoMap.get(elevatorId);
        elevatorOperationsInfo.setDirection(Direction.UP);
        runningUpElevators.add(elevatorOperationsInfo);
        runningDownElevators.remove(elevatorOperationsInfo);
    }

    @Override
    public void changeDirectionToDown(String elevatorId) {
        ElevatorOperationsInfo elevatorOperationsInfo = elevatorIdToElevatorOperationsInfoMap.get(elevatorId);
        elevatorOperationsInfo.setDirection(Direction.DOWN);
        runningUpElevators.remove(elevatorOperationsInfo);
        runningDownElevators.add(elevatorOperationsInfo);
    }
}
