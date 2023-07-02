

public class _0_1背包 {
    static int[] w = new int[]{
        2,4,6,7,8,9,10 ,30,40,50,60,70,80,90,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,
        121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150
    };
    static int[] v = new int[]{
            2,120,6,7,8,9,10 ,30,40,50,60,70,80,90,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,
            121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150
    };
    static int cap = 600;
    /**0/1背包问题
     * 背包问题得有序，无序则排序
     *回溯法
     * 利用递归，在所挑出的两种可能——
     * 1.把当前物品放入背包，寻找下个物品
     * 2.不把当前物品放入背包，跳过寻找下个物品
     * 中选出最大价值并返回
     * */
    public static int bag(int wight,int index){
        if (index >= v.length-1) return 0;
        if(cap < wight +w[index]) return 0;
        return Math.max(v[index]+bag(wight+w[index],index+1),bag(wight,index+1));
    }
    /**0/1背包问题
     * 背包问题得有序，无序则排序
     *递归回溯法+记忆数组，减少递归次数
     * 应该可称剪枝法。
     * 优化
     * */
    public static int bag2(int wight,int index){
        if (index >= v.length-1) return 0;
        if (dp[index][wight] > 0) return dp[index][wight];
        if(cap < wight +w[index]) return 0;
        return dp[index][wight] = Math.max(v[index]+bag2(wight+w[index],index+1),bag2(wight,index+1));
    }
    static int[][] dp = new int[3250][3250];
    /**0/1背包动态规划dp
     * 打表
     *0   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15……
     *1   0 0 6 6 6 6 6 6 6 6 6 6 6 6 6 6
     *2   0 0 6 6 20 20 26 26 26 26 26 26 26 26 26
     *3   0 0 6 6 20 20 26 26 26 26 26 26 29 29 29
     *4   0 0 6 6 20 20 26 26 26 26 26 26 29 29 29
     *5   0 0 6 6 20 20 26 26 26 26 26 26 29 29 33
     *6   0 0 6 6 20 20 26 26 26 26 26 26 29 29 33
     * 可以由表格推出,由第二行开始，重量如果不足，则用上一行的数据，即 (i+1,j)位置处的数据
     * 如果重量足够,则将当前物品的价值与第一列开始相加，然后从得出的值和上一行的值中选出最大值
     * 记录在dp数组中
     * dpbag[i+1][j] =Math.max(dpbag[i][j],dpbag[i][j-w[i]]+v[i]);
     * 并且，由于动态规划实际上是打表操作，即从第一件物品开始，从重量0开始到cap，列出每一步的数据
     * 所以动态规划支持无序
     * */
    public static int dpbag(){
        for (int i= 0;i <= w.length-1;i++){
            for (int j =0;j <= cap;j++){
                if (j < w[i])dpbag[i+1][j] = dpbag[i][j];
                else dpbag[i+1][j] =Math.max(dpbag[i][j],dpbag[i][j-w[i]]+v[i]);
            }
        }
        return dpbag[w.length-1][cap];
    }
    static int[][] dpbag = new int[3250][3250];

    public static void main(String[] args) {
        System.out.println(bag2(0,0));/**递归回溯+记忆数组*/
        System.out.println(dpbag());/**动态规划*/
        System.out.println(bag(0,0));/**递归回溯*/


    }
}