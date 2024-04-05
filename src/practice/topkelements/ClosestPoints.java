package practice.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPoints {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }

    public static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o2.distFromOrigin() - o1.distFromOrigin());
        for (Point point : points) {
            if (q.size() < k) {
                q.add(point);
                continue;
            }

            if (point.distFromOrigin() < q.peek().distFromOrigin()) {
                q.poll();
                q.add(point);
            }
        }

        return new ArrayList<>(q);

    }
}
