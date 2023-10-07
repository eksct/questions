import java.util.Scanner;
/**
 * 模拟滚骰子
 * */
public class P7744 {
    static long r;
    static long c;
    static int t = 1;
    static long sum = 0;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
         r = sc.nextLong();
         c = sc.nextLong();
        Tou tou = new Tou();

        if (c % 4 >0 ){
            sum = 1;
        }
        for (int i = 1;i <= r;i++){
            long rod = c / 4;//获取列周期
            sum += tou.nums()*rod;
            if (c % 4 > 0 ){
                run(tou,t);
            }
            tou.s();
            if (r!=i && c % 4 > 0){
                sum+=tou.number[1];
            }
            t++;
        }
        System.out.println(sum);
    }
    public static void run(Tou tou,int t){
        long rod = c % 4;
        for (int j=1;j<rod;j++){
            if ((t & 1) == 1){
                tou.d();
            }else{
                tou.a();
            }
            sum+=tou.number[1];
        }
    }
    public static class Tou{
        private int []number = {0,1,2,3,4,5,6};
        private int temp;
        public void d(){
            temp = number[1];number[1] = number[4];number[4] = number[6];number[6] = number[3];number[3]=temp;
        }
        public void a(){
            temp = number[1];number[1] = number[3];number[3] = number[6];number[6] = number[4];number[4] = temp;
        }
        public void s (){
            temp = number[1];number[1] = number[5];number[5] = number[6];number[6] = number[2];number[2]=temp;
        }
        public int nums(){
            return number[1] + number[4] + number[3] + number[6];
        }

    }
}
