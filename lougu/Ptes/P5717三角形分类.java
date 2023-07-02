

import java.util.Arrays;
import java.util.Scanner;

public class P5717三角形分类 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  str[] = new int [3];
        for (int i = 0; i < str.length; i++) {
            str[i] = sc.nextInt();
        }
        Arrays.sort(str);
        int x = str[0];
        int y = str[1];
        int z = str[2];
        if (z >= x+y){
            System.out.printf("Not triangle\n");
            return;
        }
        if (x * x + y * y == z * z) System.out.printf("Right triangle\n");
        else if (x * x + y * y > z * z) System.out.printf("Acute triangle\n");
        else if (x * x + y * y < z * z) System.out.printf("Obtuse triangle\n");
        if (x == y || y == z || x == z) System.out.printf("Isosceles triangle\n");
        if (x == y && y == z) System.out.printf("Equilateral triangle\n");
    }
}
