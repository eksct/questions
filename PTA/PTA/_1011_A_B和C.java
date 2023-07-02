package PTA;

import java.util.Scanner;

public class _1011_A_B和C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        while (n-->0){
            long a =sc.nextLong();
            long b =sc.nextLong();
            long c =sc.nextLong();
            if (a+b > c) System.out.printf("Case #%d: %b\n",i++,true);
            else System.out.printf("Case #%d: %b\n",i++,false);
        }
    }
}
