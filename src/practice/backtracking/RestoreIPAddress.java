package practice.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static practice.utils.Print.repeat;

public class RestoreIPAddress {

    public static List<String> restoreIpAddresses(String str) {
        List<List<String>> recur = recur(str, new ArrayList<>());
        List<String> list = new ArrayList<>();
        for (List<String> strings : recur) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.size(); i++) {
                String string = strings.get(i);
                sb.append(string);
                if (i < strings.size()-1) {
                    sb.append(".");
                }
            }

            list.add(sb.toString());
        }
        return list;
    }

    public static List<List<String>> recur(String str, List<String> parts) {

        System.out.println("str = " + str + ", parts = " + parts);

        if (parts.size() == 4 && str.isEmpty()) {
            if(isValid(parts)) {
                ArrayList<List<String>> lists = new ArrayList<>();
                lists.add(new ArrayList<>(parts));
                return lists;
            }
        } else if(parts.size() == 4 && !str.isEmpty()) {
            return Collections.emptyList();
        } else if (parts.size() != 4 && str.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<String>> retlist = new ArrayList<>();
        int stInd = 0;
        for (int l = 1; l <= 3; l++) {
//            System.out.println("stInd = " + stInd + ", l = " + l);
            if (stInd < str.length() && stInd + l <= str.length()) {

                ArrayList<String> newParts = new ArrayList<>(parts);
                newParts.add(str.substring(stInd, stInd + l));
                String substring = str.substring(stInd + l);
                System.out.println("newParts = " + newParts + " , substring = " + substring);
                List<List<String>> ret = recur(substring, newParts);
                if (!ret.isEmpty()) {
                    retlist.addAll(ret);
                }
            }
        }
        return retlist;
    }

    public static boolean isValid(List<String> parts) {

//        System.out.println("parts = " + parts);

//        should not start with zero
        for (String part : parts) {
            if (part.startsWith("0") && part.length() > 1) {
                return false;
            }
        }

        //length <= 3
        for (String part : parts) {
            if(part.length() <= 0 || part.length() > 3) {
                return false;
            }
        }

        //zero length
//        for (String part : parts) {
//            int integer = Integer.parseInt(part);
//            if (integer == 0 && part.length() > 1) {
//                return false;
//            }
//        }

        // 0 to 255
        for (String part : parts) {
            int integer = Integer.parseInt(part);
            if (integer < 0 || integer > 255) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] inputs = {
                "0000",
                "25525511135",
                "12121212",
                "113242124",
                "199219239",
                "121212",
                "25525511335"
        };
        for (int i = 0; i < inputs.length; i++) {

            List<String> result = restoreIpAddresses(inputs[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput Addresses: " + inputs[i]);
            System.out.println("\n\tPossible valid IP Addresses are: " + result);
            System.out.println(repeat("-", 100));
        }
    }
}
