import java.util.Scanner;
import java.util.regex.Pattern;

public class L1_016 {
    public static void main(String[] args) {
        int ts =0;
        int[] wid ={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        String[] m ={"1", "0", "X", "9","8","7","6","5","4","3","2"};
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        while (n -- >0){
            int sum =0;
            String name = sc.next();
            if (!patten(name)){ System.out.println(name);ts++;continue;}
            for (int i= 0;i<wid.length;i++){
                sum += (wid[i]*(name.charAt(i)-'0'));
            }
            String s = name.substring(17);
            boolean st = m[sum % 11].equals(s);
            if (!st){
                System.out.println(name);
                ts++;
            }
        }
        if (ts == 0){
            System.out.println("All passed");
        }
    }
    public static boolean patten(String str){
       // Pattern pat = Pattern.compile("^0[1-9]\\d*$17");
        return Pattern.matches("[0-9]{17}\\d*",str.substring(0,17));
    }
}
