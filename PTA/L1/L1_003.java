import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L1_003 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap();
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        //int n = Integer.parseInt(N);
        int index[] = new int[10];
        for (int i=0;i<N.length();i++){
            index[N.charAt(i)-'0']++;
        }
        for (int i=0;i<10;i++){
            if (index[i]!=0){
                System.out.printf("%d:%d\n",i,index[i]);
            }
        }
//        for (int i:index){
//            if (i!=0){
//                System.out.printf("%d:%d\n",index[i],i);
//            }
//        }
//        for (int i=0;i<N.length();i++){
//            System.out.printf("%d:%d\n",i,index[i]);
//        }
    }
}
