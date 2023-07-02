import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumTa {
     Scanner sc =new Scanner(System.in);
     int n,TaNM,n1;
     int STcopy[][];//为了写递归
    int STcopy1[][];//
    int vals[][];//标记
    public int[][]  SumTaNode1(int x,int[][] ST) {
        n1 = x;
        for (int y =0;y<x;y++){
            System.out.println("请输入第"+(y+1)+"层的"+(y+1)+"个数据");
            for (int z=0;z<=y;z++){
                ST[y][z]= sc.nextInt();
            }
        }
        fz(x);
        STcopy = ST;
        return ST;
    }
    public int[][]  SumTaNode(int x,int[][] ST){
        System.out.println("输入底层数据"+x+"个");
        n=x-1; TaNM = n;n1 = x;
        for (int i =0;i<x;i++){
            ST[x-1][i]= sc.nextInt();
        }
        //Arrays.sort(ST[x-1]);
        STcopy=ST;
        STcopy1=ST;
        fz(x);
        return ST;
    }//为底层数据排序（感觉是多余的）已注释排序，没排序会更好？
    public int[][] TaNode1(int x,int y){//x = 2,y=0
        if (n>0 && x>=0){
            n=n-1;
            STcopy[x][y]=STcopy[x+1][y]+STcopy[x+1][y+1];
            TaNode1(x, y + 1);
        } else if (n==0 && x>=0){
            n=x;
            TaNode1(x - 1, 0);
        }
        return STcopy;
    }//递归向上构造数塔
    public void TaNode(int[][] ST,int x){
        for (int i =x-2;i>=0;i--){
            for (int j=0 ;j<=i;j++){
                ST[i][j]=ST[i+1][j]+ST[i+1][j+1];
            }
        }
    }//以底层数据向上构造数塔
    public int[][] TaNodeMax(int x,int y){
        if (TaNM>0 && x>=0){
            TaNM=TaNM-1;
            //STcopy[x][y]=((STcopy[x+1][y]>=STcopy[x+1][y+1]) ? STcopy[x+1][y] : STcopy[x+1][y+1])+ STcopy[x][y];
            if (STcopy[x+1][y]>STcopy[x+1][y+1]){
                STcopy[x][y]=STcopy[x+1][y]+STcopy[x][y];
                vals[x][y]=0;
            }else{
                STcopy[x][y]=STcopy[x+1][y+1]+STcopy[x][y];
                vals[x][y]=1;
            }
            TaNodeMax(x, y + 1);
        } else if (TaNM==0 && x>=0){
            TaNM=x;
            TaNodeMax(x - 1, 0);
        }
        return STcopy;
    }//在原数塔上递归向上构造数塔最大值

    public  void stet(int x,int[][] ST){
        for (int i =0;i<x;i++){
            for (int j = 0;j<=i;j++){
                System.out.print(ST[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("MAX "+STcopy[0][0]+"\n");
    }//输出数塔
    public void fz(int x){
        int ttt[][]=new int[x][x];
        for (int i =0;i<x;i++){
            for (int j =0;j<=i;j++){
                ttt[i][j]=0;
            }
        }
        vals = ttt;
    }//标记初始化辣
    public void MAXLine(){
        System.out.print("最大值路径:");
        for (int x=0,y=0;x<n1;x++){
            System.out.print(STcopy[x][y] + " " + "(" + x +","+y+ ")"+"  ");
            y+=vals[x][y];
        }
        System.out.println();
    }//最大值路径，覆盖后（真头疼鸭
    public static List<List<Integer>> san(int n){
        List<List<Integer>>  list = new ArrayList<List<Integer>>();
        for (int i=0;i<n;i++){
            List<Integer> liste = new ArrayList<Integer>();
            for (int j=0;j<=i;j++){
                if (j==0 || j==i){liste.add(1);continue;}
                liste.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
            }
            list.add(liste);
        }
        System.out.println(list);
        return list;
    }//很奇妙的表，不知道为啥一会可以一会不行
    //杨辉三角构建求解
}
