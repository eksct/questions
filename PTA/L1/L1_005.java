import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class L1_005 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n =sc.nextInt();
        HashMap<Integer,String> map = new HashMap();
        for (int i=0;i<n;i++){
            String ksh = sc.next();
            map.put(sc.nextInt(),ksh+sc.nextLine());
        }
        int m = sc.nextInt();
        for (int i=0;i<m;i++){
            System.out.printf("%s\n",map.get(sc.nextInt()));
        }
    }
}
