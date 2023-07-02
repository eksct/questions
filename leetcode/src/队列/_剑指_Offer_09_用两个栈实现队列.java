package 队列;

import java.util.LinkedList;
import java.util.Stack;

public class _剑指_Offer_09_用两个栈实现队列 {
    static Stack<Integer> stack ;
    static Stack<Integer> stack1 ;
    public _剑指_Offer_09_用两个栈实现队列() {
        stack = new Stack();
        stack1 = new Stack();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty() && stack1.isEmpty()){
            return -1;
        }
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        return stack1.pop();
    }
}
