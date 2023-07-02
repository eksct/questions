import java.util.Scanner;
import java.util.regex.Pattern;

public class L1_025 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] str =  sc.nextLine().split("\\s");
        //String b = sc.nextLine().substring(1);
        if (!fx(str[0]) || Integer.valueOf(str[0])>1000 || Integer.valueOf(str[0])==0){
            str[0]="";
            str[0] ="?";
        }
        if (!fx(str[1]) || Integer.valueOf(str[1])>1000 || Integer.valueOf(str[1])==0 || str.length>2){
            str[1]="";
            str[1] ="?";
        }
        if (str[1].equals("?") || str[0].equals("?")){
            System.out.printf("%s + %s = ?",str[0],str[1]);
        }else {
            System.out.printf("%d + %d = %d",Integer.valueOf(str[0]),Integer.valueOf(str[1]),Integer.valueOf(str[0])+Integer.valueOf(str[1]));
        }
    }
    public static Boolean fx(String str){
        return Pattern.matches("[0-9]\\d*$",str);
    }
}
