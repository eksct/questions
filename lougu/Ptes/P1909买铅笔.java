import java.util.Scanner;

public class P1909买铅笔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int js =Integer.MAX_VALUE;
        for (int i=0;i < 3;i++){//倍增ing
            int nt = sc.nextInt();
            int cost = sc.nextInt();
            int x =nt;
            int y =cost;
            while (x < n) {
                x <<= 1;
                y <<= 1;
            }
            while (x > n){
                x -= nt;
                y -= cost;
            }
            while (x < n){
                x += nt;
                y += cost;
            }
            if (js >= y) js = y;
        }
        System.out.println(js);
    }
}
