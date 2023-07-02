import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String [] ys = {"1","2","3"};
        int n = ys.length;

        //strings.LCS();
        new STRING("assa").LCSdop();
    }


    public static int[] twoscdate(int x) {
        int a[] = new int[sc.nextInt()];//输入数组数量
        for (int i = 0; i <= a.length - 1; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        return a;
    }
}
/*
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        */
/*twofen twofen = new twofen();
        int Arrays1[]=twoscdate(), n = sc.nextInt();
        boolean as =twofen.twocheek(Arrays1,n);
        if (as ==false){
            twofen.twosort(Arrays1,n);
        }*//*
//二分查找插入，找不到则插入该数值，初步阶段，下一阶需要实现循环操作。

        */
/*SumTa SumTa = new SumTa();//数塔
        System.out.println("输入层数");
        int x = sc.nextInt();
        int ST[][]=new int[x][x];
        //下串为，输入最底层数据，逆推构造数塔
        //SumTa.TaNode(SumTa.SumTaNode(x,ST),x);//循环构造数塔
        SumTa.SumTaNode(x,ST);
        SumTa.stet(x,SumTa.TaNode1(x-2,0));//递归构造数塔
        SumTa.stet(x,SumTa.TaNodeMax(x-2,0));//递归构造数塔并求最大根
        SumTa.MAXLine();
        SumTa.stet(x,SumTa.SumTaNode1(x,ST));//输出顶端值了辣~
        SumTa.stet(x,SumTa.TaNodeMax(x-1,0));//递归构造数塔并求最大根
        SumTa.MAXLine();*//*

*/
/*        Tree tree = new Tree();//创建树
        tree.TreeBuild(3);
        tree.per();
        tree.in();
        tree.hind();
        tree.BFS();*//*

        */
/*tree.DBS(N0);
        System.out.println();
        tree.DBM(N0);
        System.out.println();
        tree.DBD(N0);*//*

        */
/*Node N0 = new Node(0,"Z");//根
        Node N1 = new Node(1,"A");
        Node N2 = new Node(2,"B");
        Node N3 = new Node(3,"C");
        Node N4 = new Node(4,"D");
        Node N5 = new Node(5,"E");
        Node N6 = new Node(6,"F");
        N0.setLeft(N1);
        N0.setRight(N2);
        N1.setLeft(N3);
        N1.setRight(N4);
        N2.setLeft(N5);
        N2.setRight(N6);*//*

    }*/
