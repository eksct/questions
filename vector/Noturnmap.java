import java.util.*;

class EdgemapL{//链表存储无向图
    List<Integer>[] ListE;
    int V,E;
    EdgemapL(int V){
        this.V=V;
        ListE =(List<Integer>[])new List[V];E=0;
        for (int i =0;i<V;i++){
            ListE[i]=new ArrayList<>();
        }
    }
    public void Edge(int v,int w){
        ListE[v].add(ListE[v].size(),w);
        ListE[w].add(ListE[w].size(),v);
    }
    public List<Integer> ListE(int v){
        return ListE[v];
    }
    public int v(){
        return V;
    }
    public int e(){
        return E;
    }
}
class SST{
    boolean[] ans;
    //int stand ;
    int coont=0;
    Integer[] edgval;
    Stack stack =new Stack<>();
    SST(EdgemapL Edg){
        this.edgval = new Integer[Edg.v()];
        this.ans =new boolean[Edg.v()];
    }
    public void DSF(EdgemapL Edg,int stand){
        stack.push(stand);
        this.ans[stand]=true;
        for (Integer i : Edg.ListE(stand)){
            if (! this.ans[i]){

                this.coont++;
                DSF(Edg,i);
            }
        }
    }
    public void BFS(EdgemapL Edg,int stand){
        anst();
        stack.push(stand);
        this.ans[stand]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(stand);
        while (!queue.isEmpty()){
            int t = queue.poll();
            for (Integer i : Edg.ListE(t)){
                if (!this.ans[i]){
                    coont++;
                    stack.push(i);
                    this.ans[i]=true;
                    queue.offer(i);
                }
            }
        }
    }
    public Stack stack(){
        return stack;
    }
    public void anst(){
        for (int i =0;i<this.ans.length;i++){
            ans[i]=false;
            stack.pop();
        }
    }
}
