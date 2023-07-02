import java.util.Scanner;
public class L1_009 {
    public static Boolean gcdt(long a,long b){
        if (b % a ==0 || a % b==0){
            return true ;
            //if (a >b){b=a;}else{a=b;}
        }
        return false;
    }
    static long gcd(long a,long b ){
        return (b==0) ? a:gcd(b,a % b);
    }
    public static void main(String[] args) {//L1-083
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        // String[] strt;
        long fz[] = new long[n];
        long fm[] = new long[n];
        int i=0,stwa=n;
        long fzs=0;long fms=0;
        while (stwa-- >0){
            String str = sc.next();
            String[] strt = str.split("/");
            fz[i]= Long.parseLong(strt[0]);
            fm[i]= Long.parseLong(strt[1]);
            i++;

        }
        for ( i=0;i<n && i!=n-1;i++) {
            if (gcdt(fm[i], fm[i + 1])) {//是否整除，通分
                if (fm[i] > fm[i + 1]) {
                    fz[i + 1] = fz[i + 1] * (fm[i] / fm[i + 1]);
                    fm[i + 1] = fm[i];
                    fz[i+1]+=fz[i];
                } else {
                    fz[i] = fz[i] * (fm[i + 1] / fm[i]);
                    fz[i+1]+=fz[i];
                    fm[i] = fm[i + 1];
                }
            } else {
                fz[i]*=fm[i+1];
                fz[i+1] *= fm[i];
                fm[i]=fm[i]*fm[i+1];
                fm[i+1]=fm[i];
                fz[i+1]+=fz[i];
                //fzs += fz[i];
            }
        }
        long ts  =gcd(fz[n-1],fm[n-1]);
        fzs = fz[n-1]/ts;
        fms = fm[n-1]/ts;
        if (fzs % fms !=0 && fzs /fms !=0){
            if (fzs > 0 && fms > 0 ) {
                System.out.printf("%d %d/%d", fzs / fms, fzs % fms, fms);
            }else{
                System.out.printf("%d -%d/%d", fzs / fms, fzs % fms, fms);
            }
        }else if(fzs /fms !=0){
            System.out.printf("%d",fzs /fms);
        }else if (fzs ==0)System.out.printf("%d",0);
        else{
//            if (fzs > 0 && fms > 0 ) {
            System.out.printf("%d/%d",fzs % fms ,fms);
            //}
            //System.out.printf("-%d/%d",fzs % fms ,fms);
        }

        //        long gcd6 =gcd(fm[i],fm[i+1]);
//                fz[i]=fz[i]*gcd6;
//                fm[i]=fm[i]*gcd6;
//                fz[i+1]=fz[i+1]*gcd6;
//                fm[i+1]=fm[i];
//                fzs += fz[i];
        //System.out.printf("%d",vs);
//        System.out.println("2022-04-23");
    }
}
