import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.Stack;

public class behind {
    int leftorright=0;
    char fx;//运算符
    int wight=0;//权重
    behind(){}//
    behind(int wight ,char fx){//接收权值与运算符
        this.wight=wight;
        this.fx=fx;
    }
    public static void main(String[] args) {//会塞进字符
        behind behind = new behind();
        //Stack<Integer> stack3 = new Stack<>();
        Stack<behind> stack = new Stack();
        Stack<Character> stack1 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String expret = sc.nextLine();
        int n =expret.length();
        int i=0;
        while ( i < n){
            if (fxt(expret.charAt(i))){
                stack1.push(expret.charAt(i));
                //if (expret.charAt(i)>='0' && expret.charAt(i) <='9')
                //stack3.push(expret.charAt(i)-'0');
                //System.out.printf("%c ",expret.charAt(i));
                i++;
                continue;
            }
            if (stack.isEmpty()){ stack.push ( new behind ( behind.wight ( expret.charAt(i)),expret.charAt(i) ) );//栈空入栈
            } else if (expret.charAt(i)=='(') {//左括号直接入栈
                stack.push(new behind(-1,'('));
            } else if (expret.charAt(i)==')') {//右括号出栈,并在遇到左括号时停止并遗弃左括号
                while (!stack.isEmpty() && stack.peek().fx!='('){
                    //System.out.printf("%c",stack.pop().fx);
                    stack1.push(stack.pop().fx);
                }
                stack.pop();
            } else if (stack.peek().wight < behind.wight ( expret.charAt(i))) {//运算符权重大于栈顶运算符权重则入栈
                stack.push(new behind ( behind.wight ( expret.charAt(i)),expret.charAt(i) ));
            }else {//运算符权重小于等于栈顶运算符权重时出栈
                while (!stack.isEmpty() && stack.peek().wight>= behind.wight(expret.charAt(i)) ){
                    //System.out.printf("%c",stack.pop().fx);
                    stack1.push(stack.pop().fx);
                }
                stack.push(new behind(behind.wight(expret.charAt(i)),expret.charAt(i)));
            }
            i++;
        }
        while (!stack.isEmpty()){
            //System.out.printf("%c",stack.pop().fx);
            stack1.push(stack.pop().fx);
        }
        StringBuilder str = new StringBuilder();
        while (!stack1.isEmpty()){
            str.insert(0,stack1.pop());
        }
        System.out.println(str);
        System.out.println(fxv(str));

    }
    public static Boolean fxt(char x){//判断是否可运算
        return (x >='A' && x<='Z') || (x>='0' && x<='9') || (x>='a' && x<='z');
    }
    public   int  wight(char x){//运算符权重
        if (x == '+' || x == '-') return 1;
        if (x == '*' || x == '/') return 2;
        if (x == '(') return 3;
        //if (x == ')')  return 3;
        return 0;
    }
    public static int fxv(StringBuilder str){//求后缀表达式值
        int i=0;int valy ,valx;
        StringBuilder strs = new StringBuilder();
        Stack<Integer> SumStack = new Stack();
        while (i<str.length()){
            if (i>2 && fxt(str.charAt(i)) && (str.charAt(i-1)=='*'|| str.charAt(i-1)=='-' || str.charAt(i-1)=='/' || str.charAt(i-1)=='+'))
            {strs.append(str.charAt(i));i++;continue;
            }else if ( i>2 && fxt(str.charAt(i)) ){
                strs.append(str.charAt(i));i++;
                continue;
            }
            if (strs.length()>0){
                SumStack.push(Integer.parseInt(String.valueOf(strs)));
                strs.delete(0,strs.length());
            }else if(fxt(str.charAt(i))) {
                SumStack.push(str.charAt(i)-'0');i++;continue;
            }
            switch (str.charAt(i)){
                case '+':
                    if (!SumStack.isEmpty()){valy= SumStack.pop();valx= SumStack.pop();SumStack.push(valx+valy);}
                    break;
                case '-':
                    if (!SumStack.isEmpty()){valy=SumStack.pop();valx=SumStack.pop();SumStack.push(valx-valy);}
                    break;
                case '*':
                    if (!SumStack.isEmpty()){valy =SumStack.pop();valx=SumStack.pop();SumStack.push(valx*valy);}
                    break;
                case '/':
                    if (!SumStack.isEmpty()){valy =SumStack.pop();valx=SumStack.pop();SumStack.push(valx/valy);}
                    break;
            }
            i++;
        }
        return SumStack.pop();
    }
}

