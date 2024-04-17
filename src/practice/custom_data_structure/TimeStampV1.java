package practice.custom_data_structure;

import java.util.HashMap;

public class TimeStampV1 {

    private final HashMap<String, HashMap<Integer, String>> datastore = new HashMap<>();

    public TimeStampV1() {
        // Write your code here
    }

    // Set TimeStamp data variables
    public boolean setValue(String key, String value, int timestamp) {
        HashMap<Integer, String> timestampToValueMap = datastore.getOrDefault(key, new HashMap<>());
        timestampToValueMap.put(timestamp, value);
        datastore.put(key, timestampToValueMap);

        return true;
    }

    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {

        HashMap<Integer, String> timestampToValueMap = datastore.getOrDefault(key, new HashMap<>());
        return timestampToValueMap.getOrDefault(timeStamp, "");
    }
}
