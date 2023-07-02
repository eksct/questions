import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class L1_011A_B {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        char[] st = sc.readLine().toCharArray();
        char[] s2 = sc.readLine().toCharArray();
        boolean ans[] =new boolean[200];
        for(int i = 0;i < s2.length;i++){
            ans[s2[i]]=true;
        }
        for (int i = 0;i < st.length ;i++){
            if (!ans[st[i]]){
                s.append(st[i]);
            }
        }
        System.out.println(s);
    }

}
//    StringBuilder str= new StringBuilder(sc.nextLine());//超时非零
//    StringBuilder s = new StringBuilder();
//    String rigs = sc.nextLine();
//        for (int i = 0; i < rigs.length(); i++){
//        String[] st =String.valueOf(str).split(rigs.substring(i,i+1));
//        str.delete(0,str.length());
//        for (int j = 0;j < st.length ; j++){
//        s.append(st[j]);
//        //str = String.valueOf(s);
//        }
//        str.append(s);
//        s.delete(0,s.length());
//        }
//        System.out.println(str);
