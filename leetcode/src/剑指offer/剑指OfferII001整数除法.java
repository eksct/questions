package 剑指offer;

import java.util.Scanner;

public class 剑指OfferII001整数除法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(fx(sc.nextInt(),sc.nextInt()));
        }
    }
    private static final int BOUND = Integer.MIN_VALUE >> 1;
    public static int fx(int a,int b){
        if (a == b)return 1;
        if (a == Integer.MIN_VALUE &&  b ==-1)return Integer.MAX_VALUE;
        if (a == 0 || b == 1)
            return a;
        else if (b==-1)return -a;
        int js =2;
        if (a > 0){
            js--;
            a = -a;
        }
        if (b > 0 ){
            js--;
            b = -b;
        }
        int res =Code(a,b);
        return js ==1 ? -res : res;
    }
    public static int Code(int a,int b){
        int res =0;
        int shift =getMax(b,a);
        while (a <= b){
            while (a > (b<< shift)){
                shift--;
            }
            a -= (b << shift);
            res += 1 << shift;
        }
        return res;
    }
    public static int getMax(int b,int a){
        int shift =0;
        int temp = b;
        while (temp > a && temp >= BOUND){
            shift++;
            temp <<=1;
        }
        return shift;
    }
}
