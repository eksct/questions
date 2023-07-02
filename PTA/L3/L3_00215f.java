import java.util.*;
/**
 *
 * 树状数组，通过位运算 “与&” 创建树状下标
 *  更新： 在树状节点上更新
 *  第一步Lowe 求不同位上的值。奇数均1，偶数是期间二的次方的因数 如 48 & -48 = 32/2= 16
 *  第二步更新树状区间数据由下往上由左往右
 *  第三步求x-----1的和  从右往左累加求和
 *  延续超时的光！绝了，什么意思
 * */
public class L3_00215f {
    static int n = 350;
    static int tree[] = new int[n];

    public static int  loldo(int x){
        return x & (-x);
    }
    public static void upfx(int i,int k){
        while (i<=n){
            tree[i] += k;
            i += loldo(i);
        }
    }
    public static int sumfx(int x){
        int er =0;
        while (x > 0){
            er += tree[x];
            x -= loldo(x);
        }
        return er;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        int nt = sc.nextInt();int js=0;
        while (nt-- > 0){
            String str = sc.next();
            if (stack.isEmpty() && str.contains("Pop")){
                System.out.println("Invalid");
                continue;
            }
            if (str.contains("PeekMedian") && stack.isEmpty()){
                System.out.println("Invalid");
                continue;
            }
            if (str.contains("Push")){
                int x= sc.nextInt();
                stack.push(x);
                upfx(x,1);
                js++;
                continue;
            }
            if (str.contains("Pop")){
                int x= stack.pop();
                System.out.println(x);
                upfx(x,-1);
                js--;
                continue;
            }
            int mid=0;
            if (js % 2 ==0)mid =js / 2;
            else mid = (js+1) / 2;
            int left =1,right = n;
            int m = (left+right)/2;
            while (left != right){

                    if(sumfx(m) < mid){
                      left += m;
                    }else {
                        right = m;
                    }
                 m = (left+right)/2;
            }
            System.out.printf("%d\n",m);
        }

    }
}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Stack<Integer> stack = new Stack();
////        HashMap map = new HashMap();
//        int n = sc.nextInt();
//        int i = 0;int t=0;
////       int [] stack = new int[50];
//        sc.nextLine();
//        while (n-- > 0) {
//            String str = sc.nextLine();
//            if (str.contains("Pop") && stack.isEmpty()){
//                System.out.println("Invalid");
//            } else if (str.contains("PeekMedian") && stack.isEmpty()){
//                System.out.println("Invalid");
//            }else if (str.contains("Push")) {
//                stack.push(Integer.valueOf(str.replaceAll("[^0-9]","")));
//            }else if (str.contains("Pop")){
//                System.out.println(stack.pop());
//            }else {
//                if (t % 2 ==0){
//                    System.out.println(stack.get(t/2));
//                }else {
//                    System.out.println(stack.get((t+1)/2));
//                }
//                t++;
//            }
//        }
//    }
//            if (str.contains("Pop") && stack.isEmpty()){
//                    System.out.println("Invalid");
//                    } else if (str.contains("PeekMedian") && stack.isEmpty()){
//                    System.out.println("Invalid");
//                    }else if (str.contains("Push")) {
//                    map.put(stack.size(),);
//                    stack.push(str.replaceAll("[^0-9]",""));
//                    i++;
//                    }else if (str.contains("Pop")){
//                    map.remove(stack.size()-1);
//                    System.out.println(stack.pop());
//                    }else if (str.contains("PeekMedian")){
//                    if (stack.size() % 2 ==0){
//                    System.out.println(map.get(stack.size()/2));
//                    }else {
//                    if (stack.size()==1){
//                    System.out.println(map.get((stack.size())/2));
//                    }else {
//                    System.out.println(map.get((stack.size())/2));
//                    }
//                    }
//                    }
//            switch (str){
//                case "Pop":
//                    if (stack.isEmpty())System.out.println("Invalid");
//                    else{
//                        int st = Integer.valueOf(str.replaceAll("[^0-9]",""));
//                        stack.add(st,stack.get(st));}
//                    break;
//                case "Push":
//            }
//            if (str.contains("Pop") && stack.size()==0) {
//                System.out.println("Invalid");
//            } else if (str.contains("PeekMedian") && stack.size()==0) {
//                System.out.println("Invalid");
//            } else if (str.contains("Push")) {
//                int nas = Integer.valueOf(str.replaceAll("[^0-9]",""));
//                stack.add(stack.size(),nas);
//            }else if (str.contains("Pop")){
//                System.out.println(stack.get(stack.size()-1));
//                stack.remove(stack.size()-1);
//            }else if (str.contains("PeekMedian")){
//
//                int st = stack.size();
//                if (stack.size() % 2 ==0){
//                    System.out.println(stack.get(i/2));
//                    i++;
//                }else {
//                    System.out.println(stack.get((i+1)/2));
//                    i++;
//                }
//            }
//           if (i==0 && str.contains("Pop")){
//                   System.out.println("Invalid");
//                   }else if (str.contains("PeekMedian") && i==0){
//                   System.out.println("Invalid");
//                   } else if (str.contains("Push")) {
//                   stack[i] =Integer.valueOf(str.replaceAll("[^0-9]",""));
//                   i++;
//                   }else if (str.contains("Pop")){
//                   System.out.println( stack[i-1]);
//                   stack[i-1]=0;
//                   i--;
//                   } else if (str.contains("PeekMedian")) {
//                   if (t % 2 ==0){
//                   System.out.println(stack[t/2]);
//                   }else {
//                   System.out.println(stack[(t+1)/2]);
//                   }
//                   t++;
//                   }
