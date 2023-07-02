import java.util.Scanner;

public class L1_032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split("\\s");
        StringBuilder sts = new StringBuilder(sc.nextLine());
        int len = sts.length();
        if (0 < (Integer.valueOf(str[0])-len)){
            for (int i =0; i< (Integer.valueOf(str[0])-len);i++){
                sts.insert(0,str[1]);
            }
        }else{
            System.out.println(sts.substring(len-Integer.valueOf(str[0])));
            return;
        }

        System.out.println(sts);
    }
}
