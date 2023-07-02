

import java.util.Scanner;

public class P1421小玉买文具 {
    public static void main(String[] args) {
        int pen = 19;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt()+a*10;
        System.out.println(b / pen);
    }
}
