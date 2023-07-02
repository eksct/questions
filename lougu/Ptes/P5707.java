package Sequential_structure;

import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int v = sc.nextInt();
        int fen = 60*8+24*60;
        if (s % v !=0){
            int time =s/v+1;
            if (time < 60*8){
                fen = 60*8;
                time =fen-time-10;
                System.out.printf("%02d:%02d",time/60,time%60);
            }else {
                time = fen-time-10;
                System.out.printf("%02d:%02d",time/60,time%60);
            }
        }else {
            int time = s/v;
            if (time < 60 * 8){
                time = 60*8-time-10;
                System.out.printf("%02d:%02d",time/60,time%60);
            }else {
                time = fen-time-10;
                System.out.printf("%02d:%02d",time/60,time%60);
            }
        }
    }
}
