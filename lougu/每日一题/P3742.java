import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3742 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(sb.readLine());
        System.out.println(ff(sb.readLine(),sb.readLine(),line));
    }
    public static String ff(String a,String b,int line){
            char[] ac =a.toCharArray();
            char[] bc =b.toCharArray();
            for(int i=0;i<line;i++){
                if (ac[i] < bc[i]){
                    return "-1";
                }
            }
        return b;
    }
}
