//package inmobi;
//
//
//// string of customer ids - events with time stamp. Running stream
//// oldest customer who bought 1 product
//// definition of old ?
//// list, query, list , query
//
///**
// * Example stream → C1, C2, C3, Query
// * Result → C1
// * Example stream → C1, C2, C2, C1, Query
// * Result → None
// * Example stream → C1, C2, C3, C1, Query
// * Result → C2
// */
//
//import java.util.*;
//
///**
// * <Cx, Tx> - Store
// * <Cx, Cnt> - Query
// * HashMp<CustId, Cnt>
// * SortedList<CustId, Time, Cnt=1> - picking the earlier
// *     if (cnt > 1) {
// *         remove from SortedSet
// *     }
// */
//
//public class InMobiCoding {
//
//    static class Node implements Comparable<Node> {
//        int time;
//        String customerId;
//        int count;
//        Node prev;
//        Node next;
//
//        Node(String customerId) {
//            this.customerId = customerId;
//            time = -1;
//            count = 0;
//        }
//
//        Node(String customerId, int time, int count) {
//            this.customerId = customerId;
//            this.time = time;
//            this.count = count;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.time-o.time;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return ((Node)obj).equals(this.customerId);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(customerId);
//        }
//    }
//
//    static class StreamProcessor {
//        private Map<String, Node> customerIdToCountMap = new HashMap<>();
//        SortedSet<Node> sortedSet = new SortedSet<>(); //LinkedList
//        int monotonicallyIncreasingTime = 1;
//
//        public void add(String customerId) {
//            Integer cnt = customerIdToCountMap.getOrDefault(customerId, 0);
//            cnt++;
//            Node value = new Node(customerId, monotonicallyIncreasingTime, cnt);
//            customerIdToCountMap.put(customerId, value);
//            if (cnt > 1) {
//                sortedSet.remove(new Node(customerId));
//            } else { // cnt == 1
//                sortedSet.add(value); //addAtLast
//            }
//
//            monotonicallyIncreasingTime++;
//        }
//
//        public String query() {
//            return sortedSet.first().customerId;
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
