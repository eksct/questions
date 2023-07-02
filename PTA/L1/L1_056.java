import java.util.Scanner;

public class L1_056 {//超时间java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //HashMap<String,Integer> ma = new HashMap();
        int n = sc.nextInt();
        double sum=0;
        int a[]=new int[n];
        String namet[] = new String[n];
        for (int i=0;i<n;i++){
            namet[i] =sc.next();
            a[i] = sc.nextInt();
            sum +=a[i];
            //ma.put(namet[i],a[i]);
        }
        sum= (sum*1.0)/n;sum /=2;
        String str="";
        double t =100;
        for (int i=0;i<n;i++){
            double x =Math.abs(a[i]-sum);
            if ( x< t){
                t = x;
                str = namet[i];
            }
        }
        System.out.printf("%.0f %s",sum,str);
    }
}
