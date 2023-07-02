

import java.util.Arrays;
import java.util.Scanner;

public class P1888三角函数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] s= new int[3];
        for (int i=0; i<s.length; i++) {
            s[i] = sc.nextInt();
        }
        Arrays.sort(s);
        int st = fx(s[0],s[2]);
        System.out.println(s[0]/st + "/" + s[2]/st);
    }
    public static int fx(int a,int b){
        return b ==0 ? a : fx(b,a % b);
    }
}
