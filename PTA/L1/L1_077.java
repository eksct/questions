import java.util.Scanner;

public class L1_077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a = new int[24];
        for (int i=0;i<24;i++){
            a[i]=sc.nextInt();
        }
        while (true){
            int n = sc.nextInt();
            if (n <0 || n> 23)break;
            if (a[n]> 50){
                System.out.printf("%d Yes\n",a[n]);
            }else {
                System.out.printf("%d No\n",a[n]);
            }
        }
    }
}
