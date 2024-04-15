package practice.stack;

import java.util.*;

public class NestedInteger {
    List<NestedInteger> list;
    int file;

    // Constructor initializes an empty nested list.
    public NestedInteger(){
        this.list = new ArrayList<NestedInteger>();
    }

    // Constructor initializes a single file.
    public NestedInteger(int value){
        this.file = value;
    }
    // @return true if this NestedInteger holds an integer value.
    public boolean isInteger() {
        return isFile();
    }


    // @return true if this NestedDirectories holds a single file, rather than a nested list.
    public boolean isFile(){
        if(this.file != 0)
            return true;
        return false;
    }

    // @return the single file that this NestedDirectories holds, if it holds a single file
    // Return null if this NestedDirectories holds a nested list
    public int getFile(){
        return this.file;
    }

    // Set this NestedDirectories to hold a single file.
    public void setFile(int value){
        this.list = null;
        this.file =  value;
    }

    // Set this NestedDirectories to hold a nested list and adds a nested file to it.
    public void add(NestedInteger ni){
        if (this.file != 0){
            this.list = new ArrayList<NestedInteger>();
            this.list.add(new NestedInteger( this.file));
            this.file = 0;
        }
        this.list.add(ni);
    }

    // @return the nested list that this NestedDirectories holds, if it holds a nested list
    // Return null if this NestedDirectories holds a single file
    public List<NestedInteger> getList(){
        return this.list;
    }
}
