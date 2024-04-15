package practice.stack;

import java.util.Stack;

class MyQueueV0 {

    private Stack<Integer> mainStk;
    private Stack<Integer> copyStk;

    public MyQueueV0() {
        mainStk = new Stack<>();
        copyStk = new Stack<>();
    }

    public void push(int x) {
        while(!mainStk.isEmpty()) {
            copyStk.push(mainStk.pop());
        }
        mainStk.push(x);
        while(!copyStk.isEmpty()) {
            mainStk.push(copyStk.pop());
        }
    }

    public int pop() {
       return mainStk.pop();
    }

    public int peek() {
        return mainStk.peek();
    }

    public boolean empty() {
        return mainStk.isEmpty();
    }
}
