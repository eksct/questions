import java.text.ChoiceFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class L1_017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //NumberFormat fl = NumberFormat.getCompactNumberInstance();
        char[] str = sc.next().toCharArray();
        int stu = 0;int fals = 1;int i = 0;
        if ((str[str.length-1]-'0') % 2 ==0){
            fals=2;
        }
        if (str[i]=='-'){fals=-fals;i++;}
        for (;i < str.length ; i++){
            if (str[i]-'0'==2){
                stu++;
            }
        }
        double nt = (str.length)*1.0;
        if (fals < 0 && fals==-2 ){
            System.out.printf("%.2f%%",(stu / (nt-1.0) * 2 * 1.5)* 100);
        } else if(fals < 0) {
            System.out.printf("%.2f%%",(stu / (nt-1.0) *  1.5)* 100);
        }else if(fals ==2){
            System.out.printf("%.2f%%",(stu / nt * 2 * 100));
        }else {
            System.out.printf("%.2f%%",(stu / nt) *100);
        }
    }
}
