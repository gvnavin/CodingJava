package practice.stack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> mainStk;
    private Stack<Integer> copyStk;

    public MyQueue() {
        mainStk = new Stack<>();
        copyStk = new Stack<>();
    }

    public void push(int x) {
        mainStk.push(x);
    }

    public int pop() {
        while(!mainStk.isEmpty()) {
            copyStk.push(mainStk.pop());
        }
        int ret = copyStk.pop();
        while(!copyStk.isEmpty()) {
            mainStk.push(copyStk.pop());
        }
        return ret;
    }

    public int peek() {
        while(!mainStk.isEmpty()) {
            copyStk.push(mainStk.pop());
        }
        int ret = copyStk.peek();
        while(!copyStk.isEmpty()) {
            mainStk.push(copyStk.pop());
        }
        return ret;
    }

    public boolean empty() {
        return mainStk.isEmpty();
    }
}
