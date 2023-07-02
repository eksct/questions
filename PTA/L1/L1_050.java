import java.util.Arrays;
import java.util.Scanner;

public class L1_050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int sum = sc.nextInt();
        StringBuilder str = new StringBuilder();
        double maxn = Math.pow(26,n);//最大序列次数26*26*26*......*26
        int maxls = (int)(maxn-sum);
        while ( n -- > 0){
            str.insert(0,(char) ((maxls % 26)+'a'));
            maxls /= 26;
        }
        System.out.println(str);
    }
}
