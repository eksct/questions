import java.util.Arrays;
import java.util.Scanner;

public class L1_079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int [] fen = new int[n];
        for (int i=0;i < n;i++){
            fen[i] = sc.nextInt();
        }
        Arrays.sort(fen);
        int min = Arrays.stream(fen).min().getAsInt();
        int max = Arrays.stream(fen).max().getAsInt();
        System.out.printf("%d %d\n",min,fx(min,fen));
        System.out.printf("%d %d\n",max,fx(max,fen));
    }
    public static int fx(int MaxorMin,int[] fen){
        int sum=0;
        for (int i=0;i < fen.length;i++){
            if (MaxorMin==fen[i]){
                sum++;
            }
        }
        return sum;
    }
}
//    int left=0,right=fen.length;
////        int mid = (left+right)/2;
////        while (left!=right){
//
//            if (fen[mid] > MaxorMin){
//                right = right-1;
//            }else if (fen[mid] < MaxorMin){
//                left = left+1;
//            }else{
//                break;
//            }
//            mid = (left+right)/2;
//        }
//        return mid-left;
