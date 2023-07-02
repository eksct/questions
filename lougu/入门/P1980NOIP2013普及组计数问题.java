

import java.util.Scanner;

public class P1980NOIP2013普及组计数问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nub = sc.nextInt();
        int cs =0;
        for (int i=1;i <= n;i++){
            int b = i;
            while (b!=0){
                if (b % 10==nub){
                    cs++;
                }
                b /=10;
            }
        }
        System.out.println(cs);
    }
}
