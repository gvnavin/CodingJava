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
//public class InMobiCodingV2 {
//
//    static class Node implements Comparable<Node> {
//        List<Integer> timestampOfPurchase = new ArrayList<>();
//        String customerId;
//
//        Node prev;
//        Node next;
//
//        Node(String customerId) {
//            this.customerId = customerId;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.timestampOfPurchase.get(0)-o.time;
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
//
//    static class StreamProcessor {
//        private Map<String, Node> customerIdToCountMap = new HashMap<>();
//        SortedSet<Node> sortedSet = new SortedSet<>(); //LinkedList
//
//        public void add(String customerId, int timestamp) {
//            Integer cnt = customerIdToCountMap.getOrDefault(customerId, 0);
//            Node value = new Node(customerId);
//            value.timestampOfPurchase.add(timestamp);
//            customerIdToCountMap.put(customerId, value);
//        }
//
//        public String query(int st, int et) {
//
//            node = sortedSet.binarySearch(st); // =>
//
//            while(!node.isEmpty()) {
//                int lcnt = 0;
//                for(ts :node.timestampOfPurchase) {
//                    if (ts >= st && ts <= et) {
//                        lcnt++
//                    }
//                    if (lcnt>1) {
//                        break;
//                    }
//                }
//                node = node.next();
//            }
//
//
//            return sortedSet.first().customerId;
//        }
//    }
//
//    //RMQ -
//    //t1 - list of (customers, purchase cnt)
//    // t2 - c1-3, c2-1
//    // t3 - c1-3, c2-1, c3-1
//    // t4   c1-4, c2-1, c3-2
//    // tn -
//
//    t2 - t1
//
//    public static void main(String[] args) {
//
//    }
//
//}
