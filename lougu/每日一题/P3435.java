
import java.util.Scanner;

public class P3435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long  k = sc.nextLong();
        char[] str = sc.next().toCharArray();
        int [] next = new int[str.length+10];
        getNext(next,str,k);
        long sum = 0;
        for (int i= 1 ;i <= k;i++){
            int j = i;
            while (next[j] > 0)j = next[j];
            if (next[i] > 0)next[i] = j;
            sum+= i-j;
        }
        System.out.println(sum);

    }
    public static void getNext(int[] next,char[] pat,long  k){
        int j = 0;
        for (int i = 1;i < pat.length;i++){
            while (j > 0 && pat[j] != pat[i])j = next[j];
            if (pat[i] ==pat[j]) j++;
            next[i+1] = j;
        }
    }
}
