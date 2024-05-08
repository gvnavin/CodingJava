package companies.atlassian.ballotvotingalgo;

import java.util.*;

public class VotingMachineV1 {

    private final int maxPointers;
    private final int topX;

    public VotingMachineV1(int maxPointers, int topX) {
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

        HashMap<String, Integer> nameToCountMap = new HashMap<>();

        for (Ballot ballot : ballots) {

            int maxPointers = this.maxPointers;
            //as per the discussion, the list of names will be 3
            for (String name : ballot.getNames()) {
                Integer countOfthePerson = nameToCountMap.getOrDefault(name, 0);
                countOfthePerson += maxPointers;
                nameToCountMap.put(name, countOfthePerson);
                maxPointers--;
            }
        }

        List<Map.Entry<String, Integer>> nameToCountHashMapEntries = new ArrayList<>(nameToCountMap.entrySet());
        Collections.sort(nameToCountHashMapEntries,
                (personToCountEntry1, personToCountEntry2) ->
                        personToCountEntry2.getValue() - personToCountEntry1.getValue()
        );

        List<Map.Entry<String, Integer>> topXHighestVotes = nameToCountHashMapEntries.subList(0, topX);

        List<String> topXHighestVotesPersonNames = topXHighestVotes.stream()
                .map(Map.Entry::getKey)
                .toList();

        return topXHighestVotesPersonNames;
    }

}
