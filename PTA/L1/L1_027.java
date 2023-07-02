import java.util.*;
import java.util.stream.Collectors;

public class L1_027 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder strs = new StringBuilder();
        //HashMap<Integer,Integer> map = new HashMap();
        int sumt = 0;
        int []arr = new int[10];
        int [] index = new int[11];
        int [] sum =new int[10];
        for (int i=0 ; i < 11; i++){
            if (sum[str.charAt(i)-'0']==0){
                sum[str.charAt(i)-'0']++;
                //map.put(str.charAt(i)-'0', map.size()).compareTo(map.get(i));
                strs.append(str.charAt(i)-'0');
            }
        }
        char[] phonesum = String.valueOf(strs).toCharArray();
        Arrays.sort(phonesum);
        char[] copyP = new char[phonesum.length];
        for (int i=0 ; i<phonesum.length; i++){
            copyP[i] = phonesum[phonesum.length-1-i];
        }
        for (int i = 0;i < 11 ;i++){
            for (int j = 0; j < phonesum.length ; j++){
                if(copyP[j] ==str.charAt(i)){
                    index[i]=j;
                }
            }
        }
        System.out.printf("int[] arr = new int[]{%s};\n",Arrays.toString(copyP).replaceAll("\\]*\\[*\\s*",""));
        System.out.printf("int[] index = new int[]{%s};",Arrays.toString(index).replaceAll("\\]*\\[*\\s*",""));
    }
}
