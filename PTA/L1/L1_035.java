import java.util.Scanner;

public class L1_035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[120];
        int i=0;
        while (true){
            str[i]=sc.nextLine();
            if (str[i].equals("."))break;
            i++;
        }
        if (i >= 13){
            System.out.printf("%s and %s are inviting you to dinner...\n",str[1],str[13]);
        }else if ( i>=2){
            System.out.printf("%s is the only one for you...\n",str[1]);
        }else {
            System.out.printf("Momo... No one is for you ...\n");
        }
    }
}
