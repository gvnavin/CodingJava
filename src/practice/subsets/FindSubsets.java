package practice.subsets;

import java.util.*;

public class FindSubsets {

    public static List<List<Integer>> findAllSubsets(int[] nums) {

        List<List<Integer>> setsList = new ArrayList<>();
        recur(nums, 0, new ArrayList<>(), setsList);
        return setsList;
    }

    static void recur(int[] nums, int i, List<Integer> list, List<List<Integer>> setsList) {
        if (i == nums.length) {
            setsList.add(new ArrayList<>(list));
            return;
        }

        ArrayList<Integer> l = new ArrayList<>(list);
        ArrayList<Integer> r = new ArrayList<>(list);

        l.add(nums[i]);

        recur(nums, i+1, l, setsList);
        recur(nums, i+1, r, setsList);

    }
}
