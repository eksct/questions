import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS{//深度搜索
    boolean vas[][];
    BFSNode map[][];
    public static void main(String[] args) {
        BFS bs = new BFS();
        //bs.vas={};
        int xt=0,yt=0,ex=0,ey=0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("输入n行n列，@为起点，#为终点。除.外均是路障,起点默认(0,0),无权重,最短路");
        int n = sc.nextInt();
        bs.map = new BFSNode[n][n];
        bs.vas = new boolean[n][n];
        for (int y=0;y<n;y++){
            for ( int x =0 ; x < n ; x++ ){
                String str = sc.next();
                if (str.equals("@")) {
                    yt = y; xt = x;
                }else if (str.equals("#")){
                    ey = y; ex = x;
                }else if (!str.equals("."))bs.vas[y][x]=true;
            }
        }
        bs.bfs(xt,yt,ex,ey);
        int sum =bs.fx(ex,ey,0,xt,yt);
        System.out.printf("%d",sum);
    }
    public   void bfs(int x,int y,int ex,int ey){
        int [][] xyt = {{0,-1},{1,0},{0,1},{-1,0}};
        BFSNode node = new BFSNode(x,y);
        Queue<BFSNode> queue = new LinkedList();
        //HashMap hashMap = new HashMap();
        this.vas[y][x]=true;
        queue.add(node);
        breaks:while (!queue.isEmpty()){
            BFSNode pre = queue.poll();
            for (int i=0 ;i < 4 ; i++){
                int xx =pre.x+xyt[i][0];int yy = pre.y+xyt[i][1];
                if (xx < 0 || xx > vas[0].length-1 || yy >vas.length-1 || 0 >yy )continue;
                if (vas[yy][xx])continue;
                this.vas[yy][xx]=true;
                BFSNode in = new BFSNode(xx,yy);
                this.map[yy][xx]=pre;
                queue.add(in);
                if (queue.peek().y == ey && queue.peek().x == ex){break breaks;}
            }
        }
    }
    public int fx(int x, int y,int sum,int xt,int yt){
        if (xt==x && yt ==y){return sum;}
        BFSNode pre =this.map[y][x];
        sum = fx(pre.x, pre.y,sum+1,xt,yt);
        System.out.printf("(%d,%d) ",pre.x,pre.y);
        return sum;
    }
}
class BFSNode{
    int x;
    int y;
    BFSNode(int x,int y){
        this.x = x;
        this.y =y;
    }
}
