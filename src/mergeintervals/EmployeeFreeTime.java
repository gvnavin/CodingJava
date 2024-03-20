package mergeintervals;

import java.util.*;

public class EmployeeFreeTime {

    public static Interval[] merge(Interval int1, Interval int2) {
        if (int1.end < int2.start) {
            Interval[] allIntervals = {int1, int2};
            return allIntervals;
        }

        if (int2.end < int1.start) {
            Interval[] allIntervals = {int2, int1};
            return allIntervals;
        }

        if (int1.start <= int2.start &&  int2.start <= int1.end) {
            Interval[] allIntervals = {new Interval(Math.min(int1.start, int2.start), Math.max(int1.end, int2.end))};
            return allIntervals;
        }

        if (int2.start <= int1.start &&  int1.start <= int2.end) {
            Interval[] allIntervals = {new Interval(Math.min(int1.start, int2.start), Math.max(int1.end, int2.end))};
            return allIntervals;
        }

        return new Interval[]{};
    }

    static class IntervalWrapper {
        public IntervalWrapper(int i, int j, Interval interval) {
            this.i = i;
            this.j = j;
            this.interval = interval;
        }

        int i, j;
        Interval interval;

        @Override
        public String toString() {
            return "{" +
                    "i=" + i +
                    ", j=" + j +
                    ", interval=" + interval +
                    '}';
        }
    }

    static class ComparatorImpl implements Comparator<IntervalWrapper> {
        @Override
        public int compare(IntervalWrapper o1, IntervalWrapper o2) {
            return o1.interval.start - o2.interval.start;
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        PriorityQueue<IntervalWrapper> q = new PriorityQueue<>(new ComparatorImpl());
        List<Interval> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < schedule.size(); i++) {
            int j = 0;
            Interval interval = schedule.get(i).get(j);
            q.add(new IntervalWrapper(i, j, interval));
        }

        System.out.println("Printing initial queue state");
        printQueue(q);
        System.out.println("------------");

        while (!q.isEmpty()) {
            IntervalWrapper intervalWrapper = q.poll();
            System.out.println("intervalWrapper = " + intervalWrapper);
            printQueue(q);
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(intervalWrapper.interval);
            } else {
                Interval interval = mergedIntervals.remove(mergedIntervals.size() - 1);
                Interval[] merge = merge(interval, intervalWrapper.interval);
                for (int j = 0; j < merge.length; j++) {
                    mergedIntervals.add(merge[j]);
                }
                System.out.println("mergedIntervals = " + mergedIntervals);
            }
            int i = intervalWrapper.i;
            int j = intervalWrapper.j;
            if (j + 1 < schedule.get(i).size()) {
                Interval interval = schedule.get(i).get(j+1);
                q.add(new IntervalWrapper(i, j+1, interval));
            }
            System.out.println("------------");
        }

        List<Interval> output = new ArrayList<>();
        for (int i = 0; i+1 < mergedIntervals.size(); i++) {
            output.add(new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i+1).start));
        }
        return output;
    }

    private static void printQueue(PriorityQueue<IntervalWrapper> q) {
        for (IntervalWrapper intervalWrapper: q) {
            System.out.println("intervalWrapper = " + intervalWrapper);
        }
    }

    // Function for displaying interval list
    public static String display(List<Interval> l1) {
        if (l1.size() == 0) {
            return "[]";
        }

        String resultStr = "[";

        for (int i = 0; i < l1.size() - 1; i++) {
            resultStr += "[" + l1.get(i).start + ", ";
            resultStr += l1.get(i).end + "], ";
        }

        resultStr += "[" + l1.get(l1.size() - 1).start + ", ";
        resultStr += l1.get(l1.size() - 1).end + "]";
        resultStr += "]";

        return resultStr;
    }

    // Driver code
    public static void main(String args[]) {
        List<List<List<Interval>>> inputs1 = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                        Arrays.asList(new Interval(1, 3)),
                        Arrays.asList(new Interval(4, 10))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                        Arrays.asList(new Interval(2, 4)),
                        Arrays.asList(new Interval(2, 5), new Interval(9, 12))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(2, 3), new Interval(7, 9)),
                        Arrays.asList(new Interval(1, 4), new Interval(6, 7))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(3, 5), new Interval(8, 10)),
                        Arrays.asList(new Interval(4, 6), new Interval(9, 12)),
                        Arrays.asList(new Interval(5, 6), new Interval(8, 10))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
                        Arrays.asList(new Interval(3, 4), new Interval(7, 12)),
                        Arrays.asList(new Interval(1, 3), new Interval(7, 10)),
                        Arrays.asList(new Interval(1, 4)),
                        Arrays.asList(new Interval(7, 10), new Interval(11, 12))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)),
                        Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12))
                )
        );

        int i = 1;
        List<List<List<Interval>>> inputs = new ArrayList<>();

        for (int j = 0; j < inputs1.size(); j++) {
            inputs.add(new ArrayList<List<Interval>>());

            for (int k = 0; k < inputs1.get(j).size(); k++) {
                inputs.get(j).add(new ArrayList<Interval>());

                for (int g = 0; g < inputs1.get(j).get(k).size(); g++) {
                    inputs.get(j).get(k).add(inputs1.get(j).get(k).get(g));
                }
            }
        }

        for (int j = 0; j < inputs.size(); j++) {
            System.out.println(i + ".\tEmployee Schedules:\n");

            for (int s = 0; s < inputs.get(j).size(); s++) {
                System.out.println("\t\t" + display(inputs.get(j).get(s)));
            }

            System.out.println("\n\tEmployees' free time " + display(employeeFreeTime(inputs.get(j))));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i += 1;
        }
    }
}
