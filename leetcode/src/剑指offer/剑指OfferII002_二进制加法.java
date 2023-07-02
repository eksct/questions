package 剑指offer;

import java.util.Scanner;

public class 剑指OfferII002_二进制加法 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        addBinary(sc.next(), sc.next());
    }
    public static String addBinary(String a, String b) {
        int maxn = Math.max(a.length(),b.length());
        StringBuilder sb = new StringBuilder();
        int jw = 0;
        for(int i = 0; i <maxn;i++){
            jw += i < a.length() ? a.charAt(a.length()-1-i)-'0' : 0;
            jw += i < b.length() ? b.charAt(b.length()-1-i)-'0' : 0;
            sb.append(jw % 2);
            jw /= 2;
        }
        if (jw > 0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
