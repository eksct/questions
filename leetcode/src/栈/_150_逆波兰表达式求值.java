package 栈;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Stack;

//        String tmep = tokens[i];
//                if (fx(tmep)){
//                int l = pl(tokens);
//                int r =pl(tokens);
//                }
public class _150_逆波兰表达式求值 {
    static int i;
    static  int t=1;
    public int evalRPN(String[] tokens) {
        i = tokens.length-t; t++;
        String tmep = tokens[i];
        if (fx(tmep)) {
            int l = evalRPN(tokens);
            int r = evalRPN(tokens);
            switch (tmep) {
                case "+" -> {return r + l;}
                case "-" -> {return r - l;}
                case "*" -> {return r * l;}
                case "/" -> {return r / l;}
            }
        }
        return Integer.parseInt(tmep);
    }
//    public int pl(String[] tokens){
//        String tmep = tokens[i--];
//        if (fx(tmep)){
//            int l = pl(tokens);
//            int r =pl(tokens);
//            switch (tmep) {
//                case "+" -> {return r + l;}
//                case "-" -> {return r - l;}
//                case "*" -> {return r * l;}
//                case "/" -> {return r / l;}
//            }
//        }
//        return Integer.parseInt(tmep);
//    }

//    public int evalRPN(String[] tokens) {
//            Stack<Integer> stack = new Stack();
//            for (String s : tokens){
//                if (fx(s))stack.push(Integer.parseInt(s));
//                else {
//                    int r = stack.pop();
//                    int l = stack.pop();
//                    switch (s){
//                        case "+" -> stack.push(l + r);
//                        case "-" -> stack.push(l - r);
//                        case "*" -> stack.push(l * r);
//                        case "/" -> stack.push(l / r);
//                    }
//                }
//            }
//            return stack.pop();
//    }
    public boolean  fx(String s){
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public static void main(String[] args) {
        System.out.println(new _150_逆波兰表达式求值().evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
