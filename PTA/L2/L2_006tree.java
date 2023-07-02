import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class L2_006tree {
    public static void main(String[] args) throws IOException {
        //BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        char[] pro = buff.readLine().replaceAll("\\s","").toCharArray();
//        char[] in = buff.readLine().replaceAll("\\s","").toCharArray();
        int [] pro = new int[n];
        int [] in = new int[n];
        for (int i =0;i < n ;i++)pro[i]= sc.nextInt();
        for (int i=0;i < n;i++) in[i]=sc.nextInt();

        Node root =buling(in,pro);
        bfs(root,n);
    }
    public static class Node{
        int data;
        Node lift;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node buling(int[] in ,int[] pro){
        if (in.length <= 0 || pro.length <= 0) return null;
        Node root = bulingtree(in,0,in.length,pro,0,pro.length);
        return root;
    }
    public static Node bulingtree(int[] in,int inbight,int inend,int[] pro,int probighy,int proend){
        if (proend ==probighy)return null;
        Node root = new Node(pro[proend-1]);
        if (proend - probighy == 1)return root;
        int standindex;
        for (standindex = inbight ;standindex < inend ; standindex++){
            if (in[standindex]==root.data){
                break;
            }
        }
        int leftinbight = inbight;
        int leftinend = standindex-1;
        int rightinbight = standindex+1;
        int rightinend = inend;

        int leftprobighy =probighy;
        int leftproend = probighy +standindex -inbight;
        int rightprostand =probighy +(standindex -inbight) ;
        int rightproend = proend -1;

        root.lift = bulingtree(in,leftinbight,leftinend,pro,leftprobighy,leftproend);
        root.right = bulingtree(in,rightinbight,rightinend,pro,rightprostand,rightproend);
        return root;
    }
    public static void bfs(Node root,int n){
        boolean vas[] = new boolean[125];
        StringBuilder st = new StringBuilder();
        Queue<Node> queue = new LinkedList();
        vas[root.data]=true;
        queue.offer(root);
        while (!queue.isEmpty()){
            Node pr = queue.poll();
            //System.out.print(pr.data + " ");
            st.append(pr.data+" ");
            if (pr.lift != null ){//|| vas[pr.lift.data]!=true
                queue.offer(pr.lift);
            }
            if (pr.right != null ){//|| vas[pr.right.data]!=true
                queue.offer(pr.right);
            }
        }
        System.out.println(String.valueOf(st).replaceAll("^\\s|\\s$",""));
    }
}