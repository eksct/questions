import java.util.Scanner;

public class L1_062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0){
            String str = sc.nextLine();
            if (str.charAt(0)+str.charAt(1)+str.charAt(2)==str.charAt(3)+str.charAt(4)+str.charAt(5)){
                System.out.printf("You are lucky!\n");
            }else {
                System.out.printf("Wish you good luck.\n");
            }
        }
    }
}
