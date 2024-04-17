package practice.custom_data_structure;

import java.util.*;

class TimeStamp {

    private final HashMap<String, HashMap<Integer, String>> datastore = new HashMap<>();

    public TimeStamp() {
        // Write your code here
    }

    // Set TimeStamp data variables
    public boolean setValue(String key, String value, int timestamp) {
        HashMap<Integer, String> timestampToValueMap = datastore.getOrDefault(key, new HashMap<>());
        timestampToValueMap.put(timestamp, value);
        datastore.put(key, timestampToValueMap);

        return true;
    }

    public String getValue(String key, int timeStamp) {

        HashMap<Integer, String> timestampToValueMap = datastore.getOrDefault(key, new HashMap<>());

        if (timestampToValueMap.isEmpty()) {
            return "";
        }

        if (timestampToValueMap.containsKey(timeStamp)) {
            return timestampToValueMap.get(timeStamp);
        }

        ArrayList<Map.Entry<Integer, String>> integers = new ArrayList<>(timestampToValueMap.entrySet());

        int beg = 0;
        int end = integers.size() - 1;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            System.out.println("beg : " + beg + " end : " + end + " mid : " + mid);
            if (beg == end - 1) {
                if (timeStamp < integers.get(beg).getKey()) {
                    beg = end;
                    break;
                } else if (timeStamp < integers.get(end).getKey()) {
                    break;
                } else {
                    break;
                }
            } else if (mid == 0 && timeStamp < integers.get(mid).getKey()) {
                end = mid;
            } else if (mid > 0 && integers.get(mid - 1).getKey() < timeStamp && timeStamp < integers.get(mid).getKey()) {
                end = mid - 1;
            } else {
                beg = mid;
            }
        }

        return integers.get(beg).getValue();
    }

    // Driver code
    public static void main(String args[]) {
        TimeStampV1 ts = new TimeStampV1();
        int num = 1;
        List<Triplet> input = Arrays.asList(new Triplet("course", "OOP", 3), new Triplet("course", "PF", 5), new Triplet("course", "OS", 7), new Triplet("course", "ALGO", 9), new Triplet("course", "DB", 10));
        for (int i = 0; i < input.size(); i++) {
            System.out.println(num + ".\tAdd value: (" + '"' + input.get(i).course + '"' + ", " + '"' + input.get(i).cName + '"' + ", " + input.get(i).id + ")");
            ts.setValue(input.get(i).course, input.get(i).cName, input.get(i).id);
            int randomInt = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
            System.out.println("\n\tGet value for:");
            System.out.println("\t\tKey = course  \n\t\tTimestamp = " + randomInt);
            System.out.println("\n\tReturned value = " + '"' + ts.getValue("course", randomInt) + '"');
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    static class Triplet {
        public String course;
        public String cName;
        public int id;

        public Triplet(String course, String cName, int id) {
            this.course = course;
            this.cName = cName;
            this.id = id;
        }
    }
}
