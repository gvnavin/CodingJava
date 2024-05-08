package companies.microsoft;

import java.util.HashMap;

class BiValue {
    public int solution(int[] inp) {
        int beg = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        HashMap<Integer, Integer> cntMap = new HashMap<>();

        while (end < inp.length) {
            int endv = inp[end];
            int endvCnt = cntMap.merge(endv, 1, (v1, v2) -> v1 + 1);
            System.out.println("beg : " + beg + ", end : " + end + ", endvCnt = " + endvCnt);

            if (cntMap.size() <= 2) {
                System.out.println("if (cntMap.size() == 2) { = ");
                int lsz = end - beg + 1;
                System.out.println("lsz = " + lsz);
                if (lsz > max) {
                    max = lsz;
                }
            }

            while (beg < inp.length && beg <= end && cntMap.size() > 2) {
                int begv = inp[beg];
                int lCnt = cntMap.merge(begv, 0, (v1, v2) -> v1 - 1);
                if (lCnt == 0) {
                    cntMap.remove(begv);
                }
                beg++;
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        BiValue solution = new BiValue();
        int ret = 0;
//        ret = solution.solution(new int[]{4, 2, 2, 4, 2});
//        System.out.println("ret = " + ret);
//        ret = solution.solution(new int[]{1, 2, 3, 2});
//        System.out.println("ret = " + ret);
//        ret = solution.solution(new int[]{0, 5, 4, 4, 5, 12});
//        System.out.println("ret = " + ret);
        ret = solution.solution(new int[]{4, 4});
        System.out.println("ret = " + ret);
    }
}