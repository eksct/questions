package 队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _225_用队列实现栈 {
    public void push(int x) {
        if (queue.isEmpty()){
            queue.offer(x);
        }else {
            int size = queue.size();
            queue.offer(x);
            while (size-- > 0){
                queue.offer(queue.poll());
            }
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
    static Queue<Integer> queue;
    public _225_用队列实现栈() {
        queue = new LinkedList();
    }
}
