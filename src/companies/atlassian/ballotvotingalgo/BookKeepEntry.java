package companies.atlassian.ballotvotingalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookKeepEntry {

    private String nameOfPerson;
    private int countOfVotes;
    private List<Integer> points;

    public BookKeepEntry(String nameOfPerson, int countOfVotes, List<Integer> points) {
        this.nameOfPerson = nameOfPerson;
        this.countOfVotes = countOfVotes;
        this.points = points;
    }

    public BookKeepEntry(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.points = new ArrayList<>();
    }

    public BookKeepEntry() {
        this.points = new ArrayList<>();
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public int getCountOfVotes() {
        return countOfVotes;
    }

    public void setCountOfVotes(int countOfVotes) {
        this.countOfVotes = countOfVotes;
    }

    public void incrementCountOfVotes(int points) {
        this.countOfVotes += points;
        this.addPoints(points);
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public void addPoints(int point) {
        this.points.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookKeepEntry bookKeepEntry = (BookKeepEntry) o;
        return Objects.equals(nameOfPerson, bookKeepEntry.nameOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfPerson);
    }
}
