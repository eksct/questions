package Branch_structure;

import java.util.Scanner;

public class P5709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int time = sc.nextInt();
        if (f ==0) System.out.printf("0");
        else {
            if (n-time/f >=0){
               if (time % f==0){
                   System.out.printf("%d",n-time/f);
               }else {
                   System.out.printf("%d",n-time/f-1);
               }
            }else System.out.printf("0");
        }
    }
}
