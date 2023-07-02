import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class L1_070 {
    public static void main(String[] args) throws IOException {
//        Scanner sc =new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int i =0;int vals=0;int ans=0;
//        String[] s;
        while (true){
            String str =sc.readLine();
            if (str.equals("."))break;
            i++;
            if (str.contains("chi1 huo3 guo1")){
                if (vals==0){
                    vals=i;
                }
                ans++;
            }
//            if (str.length >1 && vals == 0){//多个不适用截取
//                ans++;
//                vals=i;
//            }else if (str.length > 1) {
//                ans++;
//            }

//            s =str;
        }
        System.out.println(i);
        if (vals ==0){
            System.out.println("-_-#");
        }else {
            System.out.println(vals +" "+ ans);
        }
    }
}
