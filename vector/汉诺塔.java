import java.util.Scanner;

public class 汉诺塔 {
    static Scanner sc = new Scanner(System.in);
    static char a ='a';
    static char b ='b';
    static char c ='c';
    public static void main(String[] args) {

        move(sc.nextInt(),a,b,c);
    }
    public static void move(int n,char a,char b,char c){
        if (n == 0) return;
        move(n-1,a,c,b);
        System.out.println(a + "-->" + c);
        move(n-1,b,a,c);
    }
}
