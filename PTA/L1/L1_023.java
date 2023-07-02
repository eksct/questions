import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class L1_023 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str1 = sc.readLine().toUpperCase();//字母转大写
        char[] str = str1.toCharArray();
        int G = 0, P = 0, L = 0, T = 0;
        int[] sus = new int[130];
        for (int i = 0; i < str.length; i++) {
            sus[str[i]]++;
        }
        while ( sus['G']!=0 || sus['P']!=0 || sus['L'] != 0 || sus[('T')] !=0){
            if (sus['G'] > 0){
                System.out.printf("G");
                sus['G']--;
            }
            if (sus['P'] > 0){
                System.out.printf("P");
                sus['P']--;
            }
            if (sus['L'] > 0){
                System.out.printf("L");
                sus['L']--;
            }
            if (sus[('T')] > 0){
                System.out.printf("T");
                sus[('T')]--;
            }
        }
    }
}
//均超时
//            switch (str[i]){
//                case 'G':
//                case 'g':
//                    G++;
//                    break;
//                case 'P':
//                case 'p':
//                    P++;
//                    break;
//                case 'L':
//                case 'l':
//                    L++;
//                    break;
//                case 'T':
//                case 't':
//                    T++;
//                    break;

//            if (str[i]=='G' || str[i] == 'g'){
//                G++;
//            } else if (str[i]=='P' || str[i] == 'p') {
//                P++;
//            } else if (str[i]=='L' || str[i] == 'l') {
//                L++;
//            } else if (str[i]=='T' || str[i] == 't') {
//                T++;
//            }

//        int sum = G + P + L + T;
//        for (int i=0;i < sum; i++){
//            if (G != 0){
//                System.out.printf("G");
//                G--;
//            }
//            if (P != 0){
//                System.out.printf("P");
//                P--;
//            }
//            if (L != 0){
//                System.out.printf("L");
//                L--;
//            }
//            if (T != 0){
//                System.out.printf("T");
//                T--;
//            }
//        }

