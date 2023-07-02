package 队列;

import java.util.Stack;

public class _232_用栈实现队列 {
    static Stack<Integer> stack;
    static Stack<Integer> stack1;
    public _232_用栈实现队列(){
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && stack1.isEmpty();
    }
}
