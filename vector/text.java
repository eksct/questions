public class text {
    /**
     * 有一说一
     * 这里测试一部分
     *稀奇古怪的玩意，并记录
     * 1.位运算 >> << 左右移动  左边为被操作数，右边为移动位数
     * 每向左移动一位结果就在原有基础上*2，反之亦然
     * >>> 无符号右移，首部添0000，无论正负
     * 2.& | ^ 与 或 异或 对位进行运算并出值，二进制比对
     * 或：有1就1   异或：全0全1为0其余为1
     *~  按位取反 0变1 1变0
     */
    public static void main(String[] args) {
        System.out.println(~-10);//
    }
}
