package companies.atlassian.ballotvotingalgo;

import java.util.ArrayList;
import java.util.List;


//only 3 items.
public class Ballot {

    private List<String> names;

    public Ballot() {
        this.names = new ArrayList<>();
    }

    public Ballot(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void addNames(String name) {
        this.names.add(name);
    }
}
