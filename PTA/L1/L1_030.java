import java.util.Scanner;

public class L1_030 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n = sc.nextInt();
        int sex[] = new int[n];
        String[] name = new String[n];
        for (int i= 0; i < n;i++){
            sex[i] = sc.nextInt();
            name[i] = sc.next();
        }
        int left =0,right=n-1;
        for (int i=left ;i < n ; i++){
            for (int j = right;0 < j;j--){
                if (sex[i]==0 && sex[j]==1){
                    System.out.printf("%s %s\n",name[i],name[j]);
                    sex[i]=2;sex[j]=2;
                    break;
                }else if (sex[i]==1 && sex[j]==0){
                    System.out.printf("%s %s\n",name[i],name[j]);
                    sex[i]=2;sex[j]=2;
                    break;
                }
            }
        }

    }
}
