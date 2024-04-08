package atlassian.algo;

import java.util.Comparator;
import java.util.HashMap;

public class VoteCountComparator implements Comparator<BookKeepEntry> {
    @Override
    public int compare(BookKeepEntry personToCountEntry1, BookKeepEntry personToCountEntry2) {
//        return personToCountEntry2.getCountOfVotes() - personToCountEntry1.getCountOfVotes();

        if (personToCountEntry2.getCountOfVotes() != personToCountEntry1.getCountOfVotes()) {
            return personToCountEntry2.getCountOfVotes() - personToCountEntry1.getCountOfVotes();
        }

        HashMap<Integer, Integer> pointToCountMap1 = createPointToCountMap(personToCountEntry1);
        HashMap<Integer, Integer> pointToCountMap2 = createPointToCountMap(personToCountEntry2);


        return 0;
    }

    private static HashMap<Integer, Integer> createPointToCountMap(BookKeepEntry personToCountEntry) {
        HashMap<Integer, Integer> pointToCountMap = new HashMap<>();
        for (Integer point : personToCountEntry.getPoints()) {
            Integer count = pointToCountMap.getOrDefault(point, 0);
            count++;
            pointToCountMap.put(point, count);
        }
        return pointToCountMap;
    }
}
