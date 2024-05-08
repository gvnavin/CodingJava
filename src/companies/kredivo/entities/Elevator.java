package companies.kredivo.entities;

public class Elevator {

    public Elevator(String elevatorId, int capacity, ElevatorType elevatorType) {
        this.elevatorId = elevatorId;
        this.capacity = capacity;
        this.elevatorType = elevatorType;
    }

    public Elevator(String elevatorId) {
        this.elevatorId = elevatorId;
        this.capacity = 20;
        this.elevatorType = ElevatorType.PRIMARY;
    }

    //string sometimes it us numbers and sometimes it is alphabets
    private String elevatorId;

    //number of people or weight
    private int capacity;

    private ElevatorType elevatorType;

    public String getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ElevatorType getElevatorType() {
        return elevatorType;
    }

    public void setElevatorType(ElevatorType elevatorType) {
        this.elevatorType = elevatorType;
    }
}
