import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 还蛮怪的，还是要遵守java的声明捏
 * */
public class P3708 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
//        System.out.print(n-1+" ");
        long []start =new long[n+1];
        for (int i=2;i <= n;i++){
            for (int j = i;j<=n;j+=i){
                start[j]+=i;
            }
        }
        long sum= n-1;
        System.out.print(sum);
        for (int x = 2; x <= n; x++) {
            sum +=n-start[x]-1;
            System.out.print(sum +" ");
        }
    }
}
