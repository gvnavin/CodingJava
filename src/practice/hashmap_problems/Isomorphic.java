package practice.hashmap_problems;

import java.util.HashMap;

public class Isomorphic {

    public static boolean isIsomorphic(String string1, String string2) {

        HashMap<Character, Character> characterHashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string1.length(); i++) {
            char key = string1.charAt(i);
            if (!characterHashMap.containsKey(key)) {
                char value = string2.charAt(i);
                if (!characterHashMap.containsValue(value)) {
                    characterHashMap.put(key, value);
                } else {
                    return false;
                }
            }
            Character c = characterHashMap.get(key);
            sb.append(c);
        }

        String string = sb.toString();
        System.out.println("string = " + string);

        return string.equals(string2);
    }

}
