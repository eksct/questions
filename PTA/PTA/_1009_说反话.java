import java.util.Scanner;

public class _1009_说反话 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for(int i=str.length-1 ; i >=0; i--){
            if (i==0)
                System.out.printf("%s",str[i]);
            else
                System.out.printf("%s ",str[i]);
        }

    }
}
