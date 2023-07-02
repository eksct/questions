package 树;

import java.util.Comparator;

public class AVL<T> extends BinarySearchtree<T>{
    public AVL (){
        this(null);
    }
    public AVL (Comparator<Object> vis){
        super(vis);
    }
    @Override
    public void afterAdd (Node<T> node) {
        while ((node = node.parent)!=null){
            if (!isBalanced(node)){
                update(node);
            }else{
                rebalance(node);
                break;
            }
        }
    }
    @Override
    public void afterRemove (Node<T> node) {
//        if (node==null) return;
        while ((node = node.parent)!=null){
            if (!isBalanced(node)){
                update(node);
            }else{
                rebalance(node);
            }
        }
    }
    public void rebalance(Node<T> node){
        Node<T> parent = ((AVLNode)node).getChild();
        Node<T> Node = ((AVLNode)parent).getChild();
        if (isLeftChild(parent)){
            if (isLeftChild(Node)){
                rotaRight(node);
            }else {
                rotaLeft(parent);
                rotaRight(node);
            }
        }else{
            if (isRightChild(Node)){
                rotaLeft(node);
            }else {
                rotaRight(parent);
                rotaLeft(node);
            }
        }
    }
    public void rotaLeft(Node node){
            Node parent = node.right;
            node.right = parent.left;
            if (parent.left!=null)
                parent.left.parent = node;

            parent.left = node;
            rotaupdate(parent,node);

    }
    public void rotaRight(Node node){
        Node parent = node.left;
        node.left = parent.right;
        if (parent.right!=null)
            parent.right.parent = node;

        parent.right = node;
        rotaupdate(parent,node);
    }
    public void rotaupdate(Node parent,Node node){
        parent.parent = node.parent;
        if (isLeftChild(node))
            node.parent.left = parent;
        else if (isRightChild(node))
            node.parent.right = parent;
        else  root = parent;
        node.parent = parent;
        update(parent);
        update(node);
    }
    public void update(Node node){
        ((AVLNode)node).update();
    }
    public boolean  isBalanced(Node<T> node){
        return ((AVLNode)node).costHeight() > 1;
    }
    @Override
    public Node<T> createNode(T element, Node parent) {
        return new AVLNode<>(element, parent);
    }
    public static class AVLNode<T> extends Node<T>{
        int height=1;
        public AVLNode(T element, Node parent) {
            super(element, parent);
        }
        public  int costHeight(){
            int lh = left ==null ? 0 : ((AVLNode)left).height;
            int rh = right ==null ? 0 : ((AVLNode)right).height;
            return Math.abs(lh-rh);
        }
        public void update(){
            int lh = left ==null ? 0 : ((AVLNode)left).height;
            int rh = right ==null ? 0 : ((AVLNode)right).height;
            height = 1+ Math.max(lh,rh);
        }
        private Node<T> getChild(){
            int lh = left ==null ? 0 : ((AVLNode)left).height;
            int rh = right ==null ? 0 : ((AVLNode)right).height;
            if (lh > rh) return left;
            if (lh < rh) return right;
            return left;
        }
    }
}