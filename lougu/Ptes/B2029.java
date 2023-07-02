package Sequential_structure;

import java.util.Scanner;

public class B2029 {
    public static void main(String[] args) {
        int L = 20000;
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int r = sc.nextInt();
        double s = r*r*3.14*h;
        int N = (int) (L/s);
        System.out.printf("%d",N+1);
    }
}
