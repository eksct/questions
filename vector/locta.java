import java.util.Scanner;

public class locta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("输入转换进制(2,8,16)\n");
        String str = sc.nextLine();
        StringBuilder strt = new StringBuilder();
        int ten=0;
        try {
            ten= sc.nextInt();
        }catch (Exception e){
            System.out.printf("输入不为数字,ERROER");
        }
        strt=two(ten,str);
        System.out.println(strt);
    }

    public static StringBuilder two(int ten,String str){
        StringBuilder strt = new StringBuilder();
        switch (str){
            case "2":
                while (ten!=0){
                    strt.insert(0,ten%2);
                    ten /=2;
                }
                break;
            case "8":
                while (ten!=0){
                    strt.insert(0,ten%8);
                    ten /=8;
                }
                break;
            case "16":
                while (ten!=0){
                    if (ten%16>=10 && ten%16 <= 15){
                        strt.insert(0,(char)(ten%16+55));
                    }else strt.insert(0,ten%16);
                    ten /=16;
                }
                break;
        }

        return  strt;
    }
}
