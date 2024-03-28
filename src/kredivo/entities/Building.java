package kredivo.entities;

import java.util.*;

public class Building {

    private String buildingId;

    private List<Elevator> elevators;

    private int noOfFloors;

    //extension
    //Elevator to Floor Mapping

    public Building(String buildingId, List<Elevator> elevators, int noOfFloors) {
        this.buildingId = buildingId;
        this.elevators = elevators;
        this.noOfFloors = noOfFloors;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }
}
