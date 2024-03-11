import java.util.*;

class Main {

//    static class Counts {
//        int zero;
//        int one;
//        int two;
//    }
//
//    public static Counts count(int p0, int p1, int p2) {
//        int zc = 0, oc = 0, tc = 0;
//        if (p0 == 0) {
//            zc++;
//        }
//        if (p1 == 0) {
//            zc++;
//        }
//        if (p2 == 0) {
//            zc++;
//        }
//        if (p0 == 1) {
//            oc++;
//        }
//        if (p1 == 1) {
//            oc++;
//        }
//        if (p2 == 1) {
//            oc++;
//        }
//        if (p0 == 2) {
//            tc++;
//        }
//        if (p1 == 2) {
//            tc++;
//        }
//        if (p2 == 2) {
//            tc++;
//        }
//
//        Counts cnt = new Counts();
//        cnt.zero = zc;
//        cnt.one = oc;
//        cnt.two = tc;
//
//        return cnt;
//    }

    public static void swap(int[] c, int ptr1, int ptr2) {
        int temp = c[ptr1];
        c[ptr1] = c[ptr2];
        c[ptr2] = temp;
    }


    public static int[] sortColors(int[] colors) {

        int ptr0 = 0;
        int ptr1 = 0;
        int ptr2 = colors.length - 1;

        while (ptr1 < ptr2) {

            System.out.println("step-1: " + ptr0 + " " + ptr1 + " " + ptr2);

            while (ptr1 < ptr2 && ptr0 == ptr1 && colors[ptr0] == 0) {
                ptr0++;
                ptr1++;
            }

            System.out.println("step-2: " + ptr0 + " " + ptr1 + " " + ptr2);

            while (ptr1 < ptr2 && colors[ptr1] == 1) {
                ptr1++;
            }

            System.out.println("step-3: " + ptr0 + " " + ptr1 + " " + ptr2);

            while (ptr2 > 0 && colors[ptr2] == 2) {
                ptr2--;
            }

            System.out.println("step-4: " + ptr0 + " " + ptr1 + " " + ptr2);

            System.out.println("before swap colors: " + arrayToString(colors));
            if (colors[ptr1] == 0) {
                swap(colors, ptr0, ptr1);
                ptr0++;
            } else if (colors[ptr1] == 2) {
                swap(colors, ptr2, ptr0);
                if (ptr0 != ptr1) {
                    swap(colors, ptr2, ptr1);
                }
                ptr2--;
            }

            System.out.println("after swap colors: " + arrayToString(colors));
            System.out.println("------------------------------------------------");

        }

        return colors;
    }

    public static String arrayToString(int[] strArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(strArray[i]);
        }
        return sb.toString();
    }

    public static String repeat(String c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
//                {0, 1, 0},
//                {1, 1, 0, 2},
//                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
//                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + arrayToString(sortedColors));

            System.out.println(repeat("-", 100));
        }
    }
}