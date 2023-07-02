
import java.util.Scanner;

public class P1047NOIP2005普及组校门外的树 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l  = sc.nextInt();
        int m = sc.nextInt();
        int count = l+1;
        int[] b = new int[m];
        int[] a = new int[m];
        boolean[] map = new boolean[l];
        for(int i=0;i < m;i++) {
            b[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            for(int j =b[i];j<=a[i];j++){
                if(!map[j]){
                    map[j] = true;
                    count--;
                }
            }
        }
        System.out.println(count);
    }
}
