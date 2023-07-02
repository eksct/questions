package Sequential_structure;

import java.math.BigInteger;
import java.util.Scanner;

public class P1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger big = new BigInteger(String.valueOf(sc.nextBigInteger()));
        BigInteger big1 = new BigInteger(String.valueOf(sc.nextBigInteger()));
        System.out.println(big.add(big1));
    }
}
