package atlassian.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VotingMachineTest {

    @Test
    void getResults_Case1_Simple() {
        VotingMachine votingMachine = new VotingMachine(3, 5);

        Ballot ballot1 = new Ballot();
        ballot1.addNames("p1");
        ballot1.addNames("p2");
        ballot1.addNames("p3");
        ballot1.addNames("p4");
        ballot1.addNames("p5");

        Ballot ballot2 = new Ballot();
        ballot2.addNames("p2");
        ballot2.addNames("p1");
        ballot2.addNames("p3");
        ballot2.addNames("p4");
        ballot2.addNames("p5");

        List<Ballot> ballots = new ArrayList<>();
        ballots.add(ballot1);
        ballots.add(ballot2);

        List<String> results = votingMachine.getResults(ballots);
        Assertions.assertEquals(results.get(0), "p1");
        Assertions.assertEquals(results.get(1), "p2");
        Assertions.assertEquals(results.get(2), "p3");
        Assertions.assertEquals(results.get(3), "p4");
        Assertions.assertEquals(results.get(4), "p5");

    }

    @Test
    void getResults_Case2() {
        VotingMachine votingMachine = new VotingMachine(3, 5);

        Ballot ballot1 = new Ballot();
        ballot1.addNames("p1");
        ballot1.addNames("p2");
        ballot1.addNames("p3");
        ballot1.addNames("p4");
        ballot1.addNames("p5");

        Ballot ballot2 = new Ballot();
        ballot2.addNames("p3");

        Ballot ballot3 = new Ballot();
        ballot3.addNames("p1");
        ballot3.addNames("p3");
        ballot3.addNames("p2");
        ballot3.addNames("p4");
        ballot3.addNames("p5");

        List<Ballot> ballots = new ArrayList<>();
        ballots.add(ballot1);
        ballots.add(ballot2);
        ballots.add(ballot3);

        List<String> results = votingMachine.getResults(ballots);
        Assertions.assertEquals(results.get(0), "p1");
        Assertions.assertEquals(results.get(1), "p3");
        Assertions.assertEquals(results.get(2), "p2");
        Assertions.assertEquals(results.get(3), "p4");
        Assertions.assertEquals(results.get(4), "p5");

    }

}