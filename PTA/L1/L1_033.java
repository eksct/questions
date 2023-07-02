import java.util.Scanner;

public class L1_033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String strs =sc.next();
         StringBuilder str = new StringBuilder(strs);
        int sum = sc.nextInt();
        for (int i=0;str.length()<4;i++){
            str.insert(0,0);
        }
        for (int i = Integer.valueOf(String.valueOf(str));; i++){
            int val=1;
            str.delete(0,str.length());
            str.append(i);
            for (int t=0;str.length()<4;t++){
                str.insert(0,0);
            }
            if (str.charAt(0) != str.charAt(1) && str.charAt(0) != str.charAt(2) && str.charAt(0) != str.charAt(3)){
                val++;
            }
                if (str.charAt(1) != str.charAt(2) && str.charAt(1)!=str.charAt(3)){
                    val++;
                }
                    if (str.charAt(2)!=str.charAt(3)){
                        val++;
                    }





            if (sum == val){
                System.out.printf("%d %04d",Integer.parseInt(String.valueOf(str))-Integer.parseInt(strs),Integer.parseInt(String.valueOf(str)));
                break;
            }
        }
    }
}
