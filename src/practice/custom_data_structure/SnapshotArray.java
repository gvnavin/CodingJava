package practice.custom_data_structure;

import java.util.HashMap;
import java.util.HashSet;

public class SnapshotArray {

    private final int length;
    private int snapShotIdx = 0;
    private final HashMap<Integer, HashMap<Integer, Integer>> datastore = new HashMap<>();

    // Constructor
    public SnapshotArray(int length) {
        this.length = length;
    }

    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int state) {
        HashMap<Integer, Integer> snapshot = datastore.getOrDefault(snapShotIdx, new HashMap<>());
        snapshot.put(idx, state);
        datastore.put(snapShotIdx, snapshot);
    }

    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {
        snapShotIdx++;
        return snapShotIdx-1;
    }

    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {
        HashMap<Integer, Integer> snapshot = datastore.getOrDefault(snapshotId1, new HashMap<>());
        return snapshot.getOrDefault(idx, 0);
    }

}
