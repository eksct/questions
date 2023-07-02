import java.util.Scanner;
public class L1_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int sum = 0;
        int t = 0;
        for (int i=one;i<=two;i++){
            sum+=i;
            System.out.printf("%5d",i);
            t+=1;
            if (t % 5 == 0 || i==two){
                System.out.println();
            }
        }
        System.out.println("Sum = "+sum);
    }
}
