import java.util.Arrays;

public class 递归与递推 {
    /**
     * 这个是递归实现兔子斐波那契数列 1 1 2 3 5 ………从 第三项开始都为前两项的和
     * 递归时间复杂度还蛮高的,其实这个复杂度？个人感觉也是2^n
     * 所以用了下记忆化数组recon，这个应该是吧
     * */
    static long[] recon = new long[326];
    public static long n(int n){//兔子
        if (n < 2)return 1;
        if (recon[n]!=-1) return recon[n];
        return recon[n] = n(n-1) +n(n-2);
    }
    public static void fn(int n){//兔子
        long[] fx = new long[3250];
        fx[0] =fx[1] =1;
        for (int i=2;i<=n;i++){
            fx[i]+= fx[i-1] + fx[i-2];
        }
        System.out.println(fx[n]);
    }
    /**
     * dp即动态规划，dp只要知道了递推式其实还蛮好写的？（个人感觉）
     * dp的难点个人认为是找到其递推公式，不然不是很好写
     * Math.max(ta[i+1][j],ta[i+1][j+1]);这是数塔的递推公式
     * */
    public static void ta(int[][] ta){//dp数塔
        for (int i = ta.length-2; 0 <= i;i--){
            for (int j =0;j <=i;j++){
                ta[i][j] += Math.max(ta[i+1][j],ta[i+1][j+1]);
            }
        }
        System.out.println(ta[0][0]);
    }

    /**
     *递归数塔，首先从顶部依次下移至最底层，然后返回上一层的左右数，取二者最大值与该数相加
     * 但是，由于递归每次都要重复访问已访问过的数据，所以它的速度很慢，时间复杂度是2^n
     * 递归大部分是自底向上
     *  */
    public static int ta(int i,int j,int[][] ta){//递归数塔
        if (i >= ta.length-1) return ta[i][j];
        return ta[i][j] +=Math.max( ta(i+1,j,ta),ta(i+1,j+1,ta));
    }
    /**
     *为了优化递归实现的数塔的时间复杂度，我们可以开一个数组rec，用来记忆这个点是否被记录过值，即被访问
     * 当rec中某点的值不为-1时，则此处值被修改过，即代表该点已被修改，直接返回rec中存储的该点数据，不用再向下递归
     * 个人觉得这是一种极大的优化
     * 这种方法其实是空间换时间
     * 空间多，对吧？哈哈哈
     *  */
    static int rec[][] = new int[100][100];
    public static int recta(int i,int j,int[][] ta){//记忆化数塔
        if (i >= ta.length-1) return ta[i][j];
        if (rec[i][j] !=-1) return rec[i][j];
        return rec[i][j] = Math.max( recta(i+1,j,ta),recta(i+1,j+1,ta))+ta[i][j];
    }

    public static void main(String[] args) {
        for (int i=0;i<rec.length;i++){
            Arrays.fill(rec[i],-1);
        }
        Arrays.fill(recon,-1);

        /**
         * 斐波那契数列*/
        System.out.println(n(64));/**记忆化数组+递归实现，也可以单递归实现*/
        fn(64);/**循环实现*/

        /**数塔*/
        ta(new int[][]{/**动态规划dp找数塔最大值路径的值*/
                {1},
                {4,5},
                {1,2,3}
        });

        System.out.println(ta(0,0,new int[][]{/**递归找数塔最大值路径的值*/
                {1},
                {4,5},
                {1,2,3}
        }));


        System.out.println(recta(0,0,new int[][]{/**递归+记忆化数组找数塔最大值路径的值*/
                {1},
                {4,5},
                {1,2,3}
        }));
    }
}
