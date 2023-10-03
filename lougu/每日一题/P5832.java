import java.util.Scanner;

public class P5832 {
    static int sum = 0;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();
        for(int i = 0; i < n; i++) {
            for (int j=i+1 ;j < n;j++){
                search(i,j,str);
                if (sum > max){ max = sum;}
                sum = 0;
            }
        }
        System.out.println(max+1);
    }
    public static void search(int i,int k,char[] str){
        if (k == str.length)return;
        if (str[i] == str[k]){
            sum++;
            search(i+1,k+1,str);
        }
    }
}
