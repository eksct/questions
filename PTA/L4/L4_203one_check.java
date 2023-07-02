

import java.util.Arrays;
import java.util.Scanner;

public class L4_203one_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fenshu = sc.nextInt();
        int[] zhanli = new int[n];
//        int yi = 0, er = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            zhanli[i] = sc.nextInt();
        }
        Arrays.sort(zhanli);
        for (int i = 0; i < n; i++) {
            int under = (Math.abs(zhanli[i] - fenshu));
            int top = fenshu + zhanli[i];

            int left =fx(i, zhanli, under)-(n+1);
            int right =fx(i, zhanli, top)-(n+1);
//            if (left == right){continue;}
            sum += right-left;
        }
        System.out.println(sum);
    }

    public static int  fx(int left, int[] zhanli, int str6) {///自己本身也算的哦

        int life = left+1;
        int right = zhanli.length-1;
        while (life < right) {
            int mid = (life + right) / 2;
            if (zhanli[mid] > str6) {
                right--;
            } else if (zhanli[mid] < str6) {
                life++;
            }
        }
        return life;
    }
}
