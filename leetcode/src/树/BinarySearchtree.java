package 树;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchtree<T>  {
    private int size;//节点个数
    protected Node<T> root;//根节点
    private final Comparator<Object> comparator;//比较器

    public BinarySearchtree(Comparator<Object> comparator) {
        this.comparator = comparator;
    }//传入比较方法

    public BinarySearchtree() {
        this(null);
    }//不传入比较器
    public interface Vis<T>{
        void vis(T element);
    }//进行前中后层遍历时使用的方法传入

    protected static class Node<T> {
        T Element;
         Node<T> left;
         Node<T> right;
         Node<T> parent;

        public Node(T element, Node<T> parent) {
            this.Element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "Element=" + Element +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("删除");
            super.finalize();
        }

    }//节点静态内部成员类

//    private int size(){
//        return size;
//    }
    public boolean isLeftChild(Node<T> node){

        return node.parent!=null && node.parent.left ==node;
    }
    public boolean isRightChild(Node<T> node){
        return node.parent!=null && node.parent.right ==node;
    }

    public boolean isEmpty(){
        return  size == 0;
    }//判断是否空树

    public void clear(){
        this.root =null;
        size = 0;
    }//清空

    public void add( T element){
        checkNull(element);
        if (this.root ==null) {
            this.root = createNode(element,null);
            afterAdd(root);
            size++;
            return;
        }
        Node<T> tmpe = this.root;
        while (true) {
            if (cmp(tmpe.Element,element) > 0) {
                if (tmpe.left == null){tmpe.left = createNode(element, tmpe);break;}
                else tmpe =tmpe.left;
            }else if (cmp(tmpe.Element,element) < 0){
                if (tmpe.right == null){tmpe.right = createNode(element, tmpe);break;}
                else tmpe =tmpe.right;
            }else {
                tmpe.Element = element;
                break;
            }
        }
        afterAdd(tmpe.right!=null ? tmpe.right : tmpe.left);
        size++;
    }//添加

    public int remove(T element) {
        checkNull(element);
        if (!contains(element)) throw new NullPointerException("不存在");
        Node<T> temp = this.root;
        if (size == 1 && element ==temp.Element){root=null;return --size;}//删除节点只有根节点的情况
        if (element ==temp.Element && temp.left==null){root = root.right;root.parent =null;return--size;}//左树为空时,直接右树接入
        if (element ==temp.Element && temp.right==null){root = root.left;root.parent =null;return--size;}//又树为空时，直接左树接入
        if (element ==temp.Element && !temp.isLeaf()){
            Node<T>  ndoe =predecessor(temp);
            temp.Element= ndoe.Element;
            temp = ndoe;
            element = temp.Element;
//            if (ndoe.parent.left==ndoe)ndoe.parent.left = null;
//            else ndoe.parent.right = null;
        }
        while (temp != null)
            if (cmp(temp.Element, element) > 0)
                temp = temp.left;
            else if (cmp(temp.Element, element) < 0)
                temp = temp.right;
            else {
                if (temp.isLeaf()) {//删除节点是叶子节点的情况
                    if (temp.parent.left == temp) temp.parent.left = null;
                    else temp.parent.right = null;
                } else if (temp.left != null && temp.right == null) {//删除节点度为一的情况
                    if (temp.parent.left == temp){
                        temp.parent.left = temp.left;
                    }
                    else {
                        temp.parent.right = temp.left;
                    }
                    temp.left.parent = temp.parent;
                } else if (temp.left == null && temp.right != null) {//删除节点度为一的情况
                    if (temp.parent.left == temp) {
                        temp.parent.left = temp.right;
                    }else{
                        temp.parent.right = temp.right;
                    }
                    temp.right.parent = temp.parent;
                }else {
                    Node<T> pred = predecessor(temp);
                    temp.Element = pred.Element;
                    if (pred.parent.left==pred) pred.parent.left =null;
                    else pred.parent.right = null;
                }
                break;
            }
            afterRemove(temp);
        return --size;
    }//删除

    public boolean contains(T element){
        checkNull(element);
        Node<T> temp = this.root;
        while (temp!=null){
            if (cmp(temp.Element,element) > 0 )
                temp = temp.left;
            else if (cmp(temp.Element,element) < 0)
                temp =temp.right;
            else
                return true;
        }
        return false;
    }//是否包含

    public void  pre(Vis vis){
        System.out.println("前序遍历");
        pre(this.root,vis);
        System.out.println();
    }//前序

    private void pre( Node root,Vis vis){
        if (root == null ||vis == null ) return;
        vis.vis(root.Element);
            pre(root.left,vis);
            pre(root.right,vis);
    }

    public void in(){
        System.out.println("中序遍历");
        in(this.root);
        System.out.println();
    }//中序

    private void in(Node<T> root){
        if (root == null ) return;
        in(root.left);
        System.out.print(root.Element + " ");
        in(root.right);
    }

    public void post(){
        System.out.println("后序遍历");
        post(this.root);
        System.out.println();
    }//后续

    private void post(Node<T> root){
        if (root == null ) return;
        post(root.left);
        post(root.right);
        System.out.print(root.Element + " ");
    }

    public void BFS(Vis vis){
        System.out.println("层序遍历");
        BFS(this.root,vis);
        System.out.println();
    }//层序

    private void BFS(Node root,Vis vis){
//        System.out.print(root.Element +" ");
        if (root==null || vis ==null) return;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            vis.vis(temp.Element);
//            System.out.print(temp.Element + " ");
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
    }

    public int Leaf(){
        return Leaf(this.root);
    }//叶子数

    private int Leaf(Node<T> root){
        if (root==null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Leaf(root.right) +Leaf(root.left);
    }

    public int treehight(){
        return treehight(this.root);
    }//树高

    private int treehight(Node<T> root){
        if (root==null) return 0;
        return 1 + Math.max(treehight(root.left),treehight(root.right));
    }

    public boolean isComplete(){
        return isComplete(this.root);
    }//判断是否为完全二叉树

    private boolean isComplete(Node<T> root){
        if (root ==null) return false;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean Leaf = false;
        while (!queue.isEmpty()){
            Node<T> temp = queue.poll();
            if (Leaf && !temp.isLeaf()){
                return false;
            }
            if (temp.left !=null)queue.add(temp.left);
            else if (temp.right != null) return false;
            if (temp.right!=null)queue.add(temp.right);
            else {
                Leaf = true;
            }
        }
        return true;
    }

    public int Nodecount(){
        return Nodecount(this.root);
    }//返回节点数

    private int Nodecount(Node<T> root){
        if (root == null ) return 0;
        return size;
//        return 1+Nodecount(root.left) + Nodecount(root.right);
    }

    public void fztwotree(){
        fztwotree(this.root);
    }//翻转二叉树

    private void fztwotree(Node<T> root){
        if (root == null) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> temp = queue.poll();
            Node<T> left =temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
    }
    private Node<T> predecessor(Node<T> node){
        if (node == null) return null;
        Node<T> temp = node.left;
        if (temp != null){
            while (temp.right!=null){
                temp = temp.right;
            }
            return temp;
        }
        while (node.parent !=null && node.parent.left == node)
            node = node.parent;
        return node.parent;
    }//前驱节点
    private Node<T> successor(Node<T> node){
        if (node ==null) return null;
        Node<T> temp = node.right;
        if (temp!=null) {
            while (temp.left != null)
                temp = temp.left;
            return temp;
        }
        while (node.parent!=null && node.parent.right == node)
            node = node.parent;
        return node.parent;
    }//后继节点
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return toString(this.root,"",sb);
    }

    private String toString(Node<T> root, String rep, StringBuilder sb){
        if (root==null) return null;

        sb.append(rep).append(root.Element).append("\n");
        toString(root.left,rep+"L---",sb);
        toString(root.right,rep+"R---",sb);
        return sb.toString();
    }

    private void checkNull(T element){
        if (element == null){
            throw  new NullPointerException();
        }
    }//检查传入对象是否为空

    private int cmp(Object o1,Object o2){
        if (comparator != null)return comparator.compare(o1,o2);
        return ((Comparable)o1).compareTo(o2);
    }
    public void afterAdd(Node<T> node){}
    public void afterRemove(Node<T> node){}
    public Node<T> createNode(T element, Node parent){
        return new Node<>(element, parent);
    }


}
class st{
    public static void main(String[] args) {
       AVL<Integer> s = new AVL<>();
        Integer[] st = new Integer[]{
                13,14,15,12,11,17,16,8,9,1//,3,5,9,11,2
        };
        for (Integer integer : st) {
            s.add(integer);
        }
//        s.remove();
        ds(s);
        s.remove(14);
//        s.fztwotree();
        ds(s);
        s.clear();
        System.gc();
        BinarySearchtree<Integer> s1 = new BinarySearchtree<>();

    }

    private static void ds(BinarySearchtree<Integer> s) {
        s.pre((BinarySearchtree.Vis<Integer>) element -> System.out.printf("%d ",element));
        s.in();
        s.post();
        s.BFS((BinarySearchtree.Vis<Integer>) element -> System.out.printf("%d ",element));
        System.out.println(s);
        System.out.printf("叶子数：%d\n",s.Leaf());//记录叶子数
        System.out.printf("树高：%d\n",s.treehight());//记录树高
        System.out.printf("总节点:%d\n",s.Nodecount());//总结点
        System.out.printf("是完全二叉吗？%b\n",s.isComplete());//判断是否完全二叉树
        System.out.printf("值/节点是否存在%b\n",s.contains(8));//查询节点是否存在（即值是否存在）
    }
}
