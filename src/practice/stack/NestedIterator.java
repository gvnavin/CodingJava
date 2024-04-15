package practice.stack;

import java.util.*;

class NestedIterator {

    Stack<NestedInteger> stk = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        addToStackInReverse(nestedList);
    }

    // hasNext() will return True if there are still some integers in the
    // stack (that has nested_list elements) and, otherwise, will return False.
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    // Check if there is still an integer in the stack
    public int next() {

        while (!stk.peek().isInteger()) {
            NestedInteger nestedInteger = stk.pop();
            List<NestedInteger> nestedList = nestedInteger.getList();
            addToStackInReverse(nestedList);
        }

        return stk.pop().file;
    }

    private void addToStackInReverse(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stk.push(nestedList.get(i));
        }
    }

    // ------ Please don't change the following function ----------
    // flattenList function is used for testing porpuses.
    // Your code will be tested using this function
    public static List<Integer> flattenList(NestedIterator obj) {
        List<Integer> result = new ArrayList<Integer>();

        while (obj.hasNext()) {
            result.add(obj.next());
        }
        return result;
    }
}