package 栈;
import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {
    static HashMap<Character,Character> map = new HashMap();
    static {
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i=0;i < s.length();i++) {
            char t = s.charAt(i);
            if (map.containsKey(t)) {
                stack.push(t);
                continue;
            }
            if (stack.isEmpty()) return false;
            char key = stack.pop();
            if (map.get(key)!= t)return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        _20_有效的括号 s = new _20_有效的括号();
        System.out.println(s.isValid("["));
    }
}
//    Stack<Character> stack = new Stack();
//        for (int i = 0; i < s.length(); i++) {
//        char t = s.charAt(i);
//        if (t == '(' || t == '{' || t == '[') {
//        stack.push(t);
//        continue;
//        }
//        if (stack.isEmpty()) return false;
//        char peek = stack.pop();
//        if (t != ')' && peek == '(') return false;
//        if (t != ']' && peek == '[') return false;
//        if (t != '}' && peek == '{') return false;
//        }
//        return stack.isEmpty();
//        }
//
