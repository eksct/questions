import java.util.Scanner;

public class L1_071 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n =sc.nextInt();//回答层数
        int pop = sc.nextInt();//人
        int s = (int)(Math.pow(2,n));
        int [] smap = new int[s];
        for (int i=0;i < s;i++){
            smap[i]=i+1;
        }

       while (pop-- > 0){
           int liet=0,right=s;
           char[] str=sc.next().toCharArray();
           for (int i=0;i < n ; i++){
               if (str[i]=='y'){
                   right = (liet+right)/2;
               }else {
                   liet = (liet+right)/2+1;
               }
           }
           System.out.println(right);
//           int t =tree(str,0,smap.length,0,smap);
//           System.out.println(t);
       }



    }
//    public static  int tree(String str,int stand,int end,int hedn,int[] smap){//内存超限
//        int len = str.length();
//        if (hedn >= len)return smap[stand];
//            if (str.charAt(hedn) =='y'){
//                int life = stand;
//                int right = (end+stand)/2;
//                return tree(str,life,right,hedn+1,smap);
//            }else {
//                int life = (stand+end)/2;
//                int right = end;
//                return tree(str,life,right,hedn+1,smap);
//            }
//    }
}
