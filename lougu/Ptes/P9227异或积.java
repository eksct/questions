
import java.util.Scanner;

public class P9227异或积 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        long T  = sc.nextInt();
        while (T --> 0){
            long n = sc.nextLong();
            long k = sc.nextLong();
            int sum = 0;
            long t[] = new long[90000];
            for(int i=0;i<n;i++){
                t[i] = sc.nextLong();
                //????????????????????????这就全异或一遍了是吧草，全数组异或积
                //找规律了属于
                sum ^= t[i];
            }
            //当n或k为奇数时，输出的值是原数组，异或积一次后的值，否则输出原数组
            if (n % 2 !=0 || k % 2 !=0){
                for (int i=0;i<n;i++){
                    //因为b[i]位是除a[i]位以外的异或积，所以这样弄
                    System.out.print((sum^t[i])+" ");
                }
            }else {
                for (int i=0;i<n;i++){
                    System.out.print(t[i]+" ");
                }
            }
            System.out.println();
        }
    }
}
