import java.util.Scanner;

public class L1_058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        System.out.printf(str);
        int js = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i!=str.length() && str.charAt(i) =='6' ){
                js++;
                continue;
            }
            if (js > 9){
                System.out.printf("27");
            }else if (js > 3){
                System.out.printf("9");
            }else {
                while (js-- > 0){
                    System.out.printf("6");
                }
            }
            js=0;
            if (i != str.length()){
                System.out.printf("%s",str.charAt(i));
            }
        }
    }
}
