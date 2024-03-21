package mergeintervals;

import java.util.*;

public class MeetingRooms {

    static class Interval {
        public int st;
        public int end;
        public int room;

        public Interval(int st, int end) {
            this.st = st;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "st=" + st +
                    ", end=" + end +
                    ", room=" + room +
                    '}';
        }
    }

    public static int findSets(int[][] intervals) {

        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            list.add(interval);
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.st));

        HashMap<Integer, Integer> roomIdToEndTimeMap = new HashMap<>();

        List<List<Interval>> rooms = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);

            boolean found = false;
            for (Map.Entry<Integer, Integer> roomIdToEndTime : roomIdToEndTimeMap.entrySet()) {
                if (interval.st >= roomIdToEndTime.getValue()) {
                    Integer roomId = roomIdToEndTime.getKey();
                    interval.room = roomId;
                    rooms.get(roomId).add(interval);
                    roomIdToEndTimeMap.put(roomId, interval.end);
                    found = true;
                    break;
                }
            }

            if (!found) {
                int roomId = rooms.size();
                interval.room = roomId;
                List<Interval> ll = new ArrayList<Interval>();
                ll.add(interval);
                rooms.add(ll);
                roomIdToEndTimeMap.put(roomId, interval.end);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                System.out.print(rooms.get(i).get(j) + " ");
            }
            System.out.println();
        }

        return rooms.size();
    }

}