

import java.util.Scanner;

public class P1035NOIP2002普及组级数求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        double v = 0;
        double i=0.0;
        while (true){
            if (v > k){
                System.out.printf("%.0f",i);
                break;
            }
            v = v+1/++i;

        }
    }
}
