package atlassian.algo;

import java.util.*;

public class VotingMachine {

    private final int maxPointers;
    private final int topX;

    public VotingMachine(int maxPointers, int topX) {
        this.maxPointers = maxPointers;
        this.topX = topX;
    }

    /**
     * p1 -> p50
     * p2 -> p20
     * p3 -> p30
     * <p>
     * p-100 are there
     * <p>
     * first vote = 3
     * second vote = 2
     * 1
     * input list of ballot
     */
    public List<String> getResults(List<Ballot> ballots) {

        HashMap<String, BookKeepEntry> nameToCountMap = new HashMap<>();

        for (Ballot ballot : ballots) {

            int maxPointers = this.maxPointers;
            //as per the discussion, the list of names will be 3
            for (String name : ballot.getNames()) {
                BookKeepEntry bookKeepEntry = nameToCountMap.getOrDefault(name, new BookKeepEntry(name));
                bookKeepEntry.incrementCountOfVotes(maxPointers);
                nameToCountMap.put(name, bookKeepEntry);
                maxPointers--;
            }
        }

        List<BookKeepEntry> bookKeepEntries = new ArrayList<>(nameToCountMap.values());
        Collections.sort(bookKeepEntries, new VoteCountComparator());

        List<BookKeepEntry> topXHighestVotes = bookKeepEntries.subList(0, topX);

        List<String> topXHighestVotesPersonNames = topXHighestVotes.stream()
                .map(BookKeepEntry::getNameOfPerson)
                .toList();

        return topXHighestVotesPersonNames;
    }

}
