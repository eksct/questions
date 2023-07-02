import java.util.Arrays;
import java.util.Scanner;

public class L1_039_12f {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] sts = str.toCharArray();
        int len = str.length();
        char map[][];
        if (n * n < str.length()) {
            map = new char[n][64];
            for (int i=0;i<n;i++){
                Arrays.fill(map[i],'-');
            }
        } else {
            map = new char[n][n];
            for (int i=0;i<n;i++){
                Arrays.fill(map[i],'-');
            }
        }
        //int vs =1;
        int st =0,nt=n;
        for (int x = 0; x <= map.length; x++) {
            for (int i = 0; i < n; i++) {
                map[i][n - x] = sts[i];
            }
            if (sts.length <= n) {
                break;
            }
            //char[] s = new char[20] ;
            int srs = (sts.length-n);
            System.arraycopy(sts, n, sts = new char[sts.length-(n)], 0, srs);
            st++;
            if (st==n){n = len % n;x = x-1 ;}
            //  vs++;
        }
        //Arrays.stream(map).parallel()
        StringBuilder str1 = new StringBuilder();
        int tsq =nt;
        int ys = str.length() % n;//输出
        for (int y=0;y < nt;y++){
            for (int x =0; x <= tsq;x++){
                if (map[y][x]=='-') System.out.printf(" ");
                else System.out.print(map[y][x]);
                //str1.append(map[y][x]);
            }
            System.out.println();
        }
    }
}
