
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6832Cnoi2020子弦 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String str = buff.readLine();
        int ls[] = new int[105];
        for (int i = 0; i < str.length(); i++) {
            ls[str.charAt(i)-'a']++;
        }
        int ans =0;
        for (int i=0;i< 26;i++){
            ans =Math.max(ls[i],ans);
        }
        System.out.println(ans);
    }
}
