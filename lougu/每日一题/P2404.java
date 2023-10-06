import java.util.Arrays;
import java.util.Scanner;

/**
 * dfs深搜
 * **/
public class P2404 {
    static int[] arr;
    static int k;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        k = n;
        arr = new int[n+1];
        Arrays.fill(arr,1);
        dfs(1);
    }
    public static void dfs(int a){
        for (int i = arr[a-1];i <= k;i++){
            if (i == n )continue;
            arr[a] = i;
            k-= i;
            if (k == 0 ) println(a);
            else dfs(a+1);
            k+=i;
        }
    }
    public static void println(int a){
        for (int i = 1;i <=a;i++){
            if (i==a){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i]+"+");
            }
        }
        System.out.println();
    }
}
