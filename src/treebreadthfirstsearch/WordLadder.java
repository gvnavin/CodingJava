package treebreadthfirstsearch;

import java.util.*;

public class WordLadder {
    static class Node {
        String str;
        int l;

        public Node(String str, int l) {
            this.str = str;
            this.l = l;
        }

        public Node(String str) {
            this.str = str;
            this.l = 1;
        }
    }

    public static int wordLadder(String src, String dest, List<String> words) {

        HashMap<Integer, List<Character>> indexToPossibleCharactersMap = new HashMap<>();
        HashSet<String> wordsSet = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                List<Character> characterList = indexToPossibleCharactersMap.getOrDefault(i, new ArrayList<>());
                characterList.add(word.charAt(i));
                indexToPossibleCharactersMap.put(i, characterList);
            }
            wordsSet.add(word);
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(src));

        HashMap<String, Boolean> isVisited = new HashMap<String, Boolean>();

        while(!q.isEmpty()) {
            Node node = q.poll();
            if (node.str.equals(dest)) {
                return node.l;
            }

            if (isVisited.getOrDefault(node.str, false)) {
                continue;
            }

            isVisited.put(node.str, true);

            for (int i = 0; i < node.str.length(); i++) {
                List<Character> characters = indexToPossibleCharactersMap.get(i);
                for (Character character : characters) {
                    char[] charArray = node.str.toCharArray();
                    if (character == node.str.charAt(i)) {
                        continue;
                    }
                    charArray[i] = character;
                    String newString = new String(charArray);
                    if (wordsSet.contains(newString)) {
                        q.offer(new Node(newString, node.l+1));
                    }
                }
            }
        }

        return 0;
    }

}
