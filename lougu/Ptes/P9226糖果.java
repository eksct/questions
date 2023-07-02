

import java.util.Scanner;

public class P9226糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nb = sc.nextInt();
        int s = n % nb;
        System.out.printf("%d",nb -s);
    }
}
