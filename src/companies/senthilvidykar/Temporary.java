import java.util.TreeMap;

public class Temporary {
    public static int minZeroArray(int[] nums, int[][] queries) {
        TreeMap<Integer, Integer> counter = new TreeMap();
        counter.put(Integer.MAX_VALUE, 0);
        int total = 0, k = 0, pos = 0;
        while (pos < nums.length && nums[pos] == 0) {
            pos++;
        }
        if (pos == nums.length) return k;
        for (int[] query : queries) {
            int l = query[0], r = query[1], val = query[2];
            k++;
            if (r < pos) {
                continue;
            } else if (l > pos) {
                counter.put(l, counter.getOrDefault(l, 0) + val);
                counter.put(r + 1, counter.getOrDefault(r + 1, 0) - val);
            } else {
                total += val;
                counter.put(r + 1, counter.getOrDefault(r + 1, 0) - val);
                while (pos < nums.length) {
                    int firstKey = counter.firstKey();
                    if(firstKey > pos && total >= nums[pos]) {
                        pos++;
                    } else if(firstKey <= pos) {
                        total += counter.get(firstKey);
                        counter.remove(firstKey);
                    } else {
                        break;
                    }
                }
            }
            if (pos == nums.length) return k;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 4};
        int[][] queries = new int[][] {{0,1,5},{1,1,5},{1,1,3},{1,1,4},{0,0,3},{1,1,4},{0,1,2},{1,1,3},{1,1,1}};
        System.out.println("Result : "+minZeroArray(arr, queries));
    }
}
