

import java.util.Scanner;

public class P1424小鱼的航程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        long sum =0;
        for (int i=x;i <=x+n-1;i++){
            if (i % 7 ==6 || i % 7 ==0) continue;
            sum+=250;
        }
        System.out.printf("%d\n",sum);
    }
}
