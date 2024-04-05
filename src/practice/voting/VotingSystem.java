package practice.voting;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingSystem {

    static class Ballot {

        public String[] getCandidates() {
            return new String[0];
        }
    }

    Map<String, Integer> candidateToCountMap;

    public VotingSystem() {
        this.candidateToCountMap = new HashMap<>();
    }
    /**
     * Process a list of ballots, and return all candidates sorted in descending order by their total number of points.
     */
    public List<String> getResults(List<Ballot> ballots) {
        for(Ballot ballot : ballots) {
            String[] candidates = ballot.getCandidates();

            int score = 3;
            for(int i = 0; i < candidates.length; i++) {
                candidateToCountMap.putIfAbsent(candidates[i], 0);
                int previousVoteCount = candidateToCountMap.get(candidates[i]);
                candidateToCountMap.put(candidates[i], previousVoteCount + score);
                score--;
            }
        }

        List<Map.Entry<String, Integer>> candidatesCountList = new ArrayList<>(candidateToCountMap.entrySet());

        candidatesCountList.sort((candidate1, candidate2) -> {
            if(candidate1.getValue() < candidate2.getValue()) {
                return 1;
            } else if (candidate1.getValue() > candidate2.getValue()) {
                return -1;
            }
            return 0;
        });

        List<String> winnersList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : candidatesCountList) {
            winnersList.add(entry.getKey());
        }

        return winnersList;
    }

}
