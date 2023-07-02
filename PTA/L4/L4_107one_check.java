import java.util.Scanner;

public class L4_107one_check {
   public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        sc.nextLine();
//        String str = sc.nextLine();
        while (n-- > 0){
            char[] str = sc.next().toCharArray();
            int chars = 0,mus = 0,dian=0, s=0;
            if (str.length <= 6){
                System.out.printf("Your password is tai duan le.\n");
                continue;
            }
            for (int i=0 ; i < str.length ; i++){
                if ((str[i] >= 'A' && str[i] <= 'Z') || (str[i] >= 'a' && str [i]<= 'z') ){
                    chars++;
                } else if (str[i] >= '0' && str[i] <= '9' ) {
                    mus++;
                }else if (str[i]=='.'){
                    dian++;
                }else {
                    System.out.printf("Your password is tai luan le.\n");
                    s=1;
                    break;
                }
            }
            if (s != 1){
                if (chars > 0 && mus == 0){
                    System.out.printf("Your password needs shu zi.\n");
                } else if (chars == 0 && mus != 0) {
                    System.out.printf("Your password needs zi mu.\n");
                }else {
                    System.out.printf("Your password is wan mei.\n");
                }
            }
        }
    }
//
}
//            if (str.equals("."))continue;
//            if (str.length()<=6){
//                System.out.printf("Your password is tai duan le.\n");
//                continue;
//            }
//            if (fxts(str)){
//                System.out.printf("Your password is tai luan le.\n");
//                continue;
//            }
//            if (!fxt(str)){
//                System.out.printf("Your password needs shu zi.\n");
//                continue;
//            }
//            if (!fx(str)){
//                System.out.printf("Your password needs zi mu\n");
//                continue;
//            }
//
//            System.out.printf("Your password is wan mei.\n");
////
//        }
////
//
//    }
//    public static boolean fx(String str){
//        return Pattern.matches(".*[a-zA-Z].*",str);//包含字母
//    }
//    public static boolean fxt(String str){
//        return Pattern.matches(".*[0-9].*",str);//包含数字
//    }
//    public  static  boolean fxts(String str){
//        return  Pattern.matches(".*[^a-zA-Z0-9.].*",str);//除了有效字符以外的字符
//    }