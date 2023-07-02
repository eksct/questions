import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoTrees{

}
class Tree{
    int n,i=0;private Node root;

    public void setRoot(Node root){
        this.root = root;
    }
    public void per(){
        this.root.per();
        System.out.println();
    }
    public  void in(){
        this.root.in();
        System.out.println();
    }
    public  void hind(){
        this.root.hind();
        System.out.println();
    }
    public void BFS(){
        this.root.dfs();
        System.out.println();
    }

    public void TreeBuild(int n){//输入
        this.n=n;
        setRoot(new Node(1,(char)'A'));
        Build(root,1);
//if(i%6==5 && i%11==10 && i%5==1 && i% 7==4 )
    }
    public Node Build(Node root,int ans){
        i++;
        if (root.left==null && ans<n){
            root.left= new Node<>(i,(char)('A'+i));
            root.left.Up=root;
            //Builds(root.left);
            Build(root.left,ans+1);
            //Builds(root.right);
        }else{
            ans-=1;
            return root;
        }
        if (root.right==null && ans<n) {
            root.right = new Node<>(i,(char)('A'+i));
            root.right.Up=root;
            //Builds(root.right);
            Build(root.right,ans+1);
            //Builds(root.right);
        }else{
            ans-=1;
            return root ;
        }
    return root;
    }
    public int Builds(Node x){
        char x1;
        if(x==null ||x.Up==null){
            return 0;
        }
        if ((char)x.name>(char)x.Up.name){
            x1=(char)x.Up.name;
            x.Up.name =x.name;
            x.name =x1;
        }
        return 0;
    }

}
class Node<T>{
    private int id;
    T name;
    Node left;
    Node right;
    Node Up;
    Node(int id,T name){
        this.id = id;
        this.name = name;
    }
    /*public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }*/
    public String toString(){
        return " "+this.name+" ";
    }
    public void per(){//
        System.out.print(this);
        if (this.left !=null){
            this.left.per();
        }
        if (this.right!=null)
            this.right.per();
        }
    public void in(){//中
        if (this.left !=null){
            this.left.in();}
        System.out.print(this);
        if (this.right!=null){
            this.right.in();}
    }
    public void hind(){//后

        if (this.left !=null){
            this.left.hind();
        }

        if (this.right!=null){
            this.right.hind();
        }
        System.out.print(this);
    }
    public void dfs(){
        Stack stack = new Stack<>();
        Boolean[] tes = new Boolean[6];
        Queue queue = new LinkedList();
        queue.offer(this);
        stack.push(this);
        while (!queue.isEmpty()){
            Node xt =(Node) queue.poll();
            for (;xt!=null;){
                if (xt.left!=null){
                    queue.offer(xt.left);
                    stack.push(xt.left);
                }
                if (xt.right!=null){
                    queue.offer(xt.right);
                    stack.push(xt.right);
                }
                xt=null;
            }
        }
        System.out.println(stack);
    }
}
