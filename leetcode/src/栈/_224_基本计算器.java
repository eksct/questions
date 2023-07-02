package 栈;

//import java.util.Deque;
//import java.util.LinkedList;
import java.util.Stack;

public class _224_基本计算器 {

    public int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _224_基本计算器().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
//    static  int i =0;
//    char ysf = '+';//递归
//    int sum =0;
//        while (i < s.length()){
//        if (s.charAt(i) ==' '){i++; continue;}
//        int sun=0;
//        if (s.charAt(i) == '(') { i++ ; sun = calculate(s);}
//        while (  i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//        sun = s.charAt(i) - '0' + sun * 10;
//        i++;
//        }
//        sum = ysf == '+' ? sum + sun : sum - sun;
//        if (i < s.length() && s.charAt(i) ==')'){ i++ ; return sum;}
//        if (i < s.length())ysf =s.charAt(i);
//        i++;
//        }
//        i =0;
//        return sum;
