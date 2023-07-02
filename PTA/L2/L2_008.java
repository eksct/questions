import java.util.Scanner;

public class L2_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LCSdop(sc.nextLine());

    }
    public static void LCSdop(String str){
        int LCSmax =0;
        if (str.equals("")){
            System.out.println(0);
            return;
        }
        boolean[][]ans = new boolean[str.length()][str.length()];
        for (int i=0;i< ans.length;i++){
            for (int j =0;j < ans.length;j++){
                if (str.charAt(i)==str.charAt(j)){
                    if (i - j <3) {
                        ans[j][i] = true;
                    }else{
                        ans[j][i] =ans[j+1][i-1];
                    }
                }
                if (ans[j][i] && i-j+1 >LCSmax){
                    LCSmax = i-j+1;
                }
            }
        }
        System.out.println(LCSmax);
    }
//    public static void LCSdop(String str) {//最长对称子字符串
//        if (str.equals("")){
//            System.out.println(0);
//            System.out.println("null");
//            return;
//        }
//        boolean[][] ans = new boolean[23][23];
////        for (int i=0;i<Strn;i++){ans[i][i]=true;}
//        int maxLcs=0;
//        String SmaxLcs=null;
//        for (int i=1;i<21;i++){
//            for (int j=0;j<21;j++){
//                if (str.charAt(i)==str.charAt(j)){
//                    if (i-j<3){//assa                                1. 0,1 f /  1,1 t / 2,1 t / 3.1 f    2. 2,0 f 2,1 t / 2.2 t/ 2.3 f   3. 3.0 t ,3.1f 3.2f 3.3 t
//                        ans[j][i]=true;
//                    }else {
//                        ans[j][i]=ans[j+1][i-1];
//                    }
//                }
//                if (ans[j][i] && i-j +1 >maxLcs){
//                    maxLcs = i-j+1;
//                    SmaxLcs = str.substring(j,i+1);
//                }
//            }
//        }
//        System.out.println(maxLcs);
//        System.out.println(SmaxLcs);
//    }
}
