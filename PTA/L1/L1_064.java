import java.util.Scanner;

public class L1_064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str;
        while (n-- > 0){
            str =sc.nextLine();
            System.out.println(str);
            //str =str.replaceAll("^\\s$+","");//删除首末空格
            str= str.trim();
            str =str.replaceAll("\\s+"," ");//多空格转单
            //str =str.replaceAll("\\b\\s","");
            //str = str.toLowerCase().replaceAll("\\bi","I");
//            for (int i=0;i<str.length();i++){
//                if (str.charAt(i) >='A' && str.charAt(i) <='Z' && str.charAt(i)!='I'){
//                }
//            }
            str = str.replaceAll("I","^");
            str =str.toLowerCase();
            str =str.replaceAll("\\^","I");
            str=str.replaceAll(" (\\W)","$1");
            str = str.replace("?","!");
            str =str.replaceAll("\\bcan you\\b","Q");
            str =str.replaceAll("\\bcould you\\b","W");
            str =str.replaceAll("\\b(I|me)\\b","S");
            str =str.replaceAll("Q","I can");
            str =str.replaceAll("W","I could");
            str =str.replaceAll("S","you");
            //str =str.toLowerCase().replaceAll("i","I");



            System.out.printf("AI: %s\n",str);
        }

    }
}
