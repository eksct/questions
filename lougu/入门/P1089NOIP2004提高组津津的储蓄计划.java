

import java.util.Scanner;

public class P1089NOIP2004提高组津津的储蓄计划 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost =0;
        int seve =0;
        for (int i = 0; i <12 ;i++){
            cost+=300;
            cost-=sc.nextInt();
            if (cost < 0) {
                System.out.printf("-%d",i+1);
                seve = -seve;
                break;
            }
            int n =cost / 100;
            if ( n > 0){
                seve += n;
                cost %= 100;
            }
        }
        if (seve > 0){
            seve *= 100;
            System.out.printf("%.0f",cost+seve*1.2);
        }
    }
}
