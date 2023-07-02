package 栈;

//import java.util.Stack;

public class _856_括号的分数 {
    public int scoreOfParentheses(String s) {
        int tmpe = 0;
        int st = 0;
        for (int j = 0; j < s.length(); j++) {
            st += (s.charAt(j) == '(' ? 1 : -1);
            if (s.charAt(j) == ')' && s.charAt(j - 1) == '(') {
                tmpe += 1 << st;
            }
        }
        return tmpe;
    }

    public static void main(String[] args) {
        _856_括号的分数 s = new _856_括号的分数();
        System.out.println( s.scoreOfParentheses("(())"));
    }
}
//    Stack<Integer> stack = new Stack();
//        stack.push(0);
//                boolean ft =true;
//                for (int i=0;i < s.length();i++){
//        char t = s.charAt(i);
//        if (t == '(')stack.push(0);
//        else {
//        int v = stack.pop();
//        int sum = stack.pop() + Math.max(2 * v, 1);
//        stack.push(sum);
//        }
//        }
//        return stack.pop();
