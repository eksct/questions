import java.util.Scanner;
public class L1_002{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();int t=0;
        String str = sc.next();
        int h =(int)Math.sqrt((n+1)/2);
        for(int i=0;i<h-1;i++){
            for(int j=1;j<2*(h-i);j++){
                System.out.print(str);
                sum++;
            }
            if (i==0){t=sum;}
            if(i!=2*(h-i)){System.out.println();}
            for(int x = 0;x<=i;x++){
                System.out.print(" ");
            }
        }
        tablc:
        for(int i = 0;i<h;i++){
            for(int j = 0;j<=2*i;j++){
                if (sum==n)break tablc;
                System.out.print(str);
                sum++;

            }
            System.out.println();
            for(int x = 2;x<h-i;x++){
                System.out.print(" ");
            }
        }
        System.out.print(n-sum);
    }
}