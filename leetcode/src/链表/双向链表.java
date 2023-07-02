package 链表;

import java.security.PrivilegedAction;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collector;

public class 双向链表<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T>last;
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int js;

            @Override
            public boolean hasNext() {
                return size != js;
            }

            @Override
            public T next() {
                Node<T> pt = first;
                int i = 0;
                while (i != js) {
                    pt = pt.next;
                    i++;
                }
                js++;
                return pt.Element;
            }
        };
    }

    private static class Node<T>{
        T Element;
        Node<T> next;
        Node<T> prev;

        private Node(T element, Node<T> next, Node<T> prev) {
            Element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("删除");
            super.finalize();
        }

        @Override
        public String toString() {
            return String.valueOf(Element);
        }
    }
    public void clear(){
        size=0;
        this.first=this.last=null;
    }

    private Node<T> node(int index){
        check(index);
        Node<T> pt;
        if (index <=(size/2)){
            pt = this.first;
            while (pt.next != null && index-- >0){
                pt = pt.next;
            }
        }else {
            pt = this.last;
            int pos = size - index;
            while (pt.prev != null && pos-- > 1 ){
                pt = pt.prev;
            }
        }
        return pt;
    }
    public T get(int index){
        return node(index).Element;
    }
    public  T set(int index, T Element){
        Node<T> pt =node(index);
        T old = pt.Element;
        pt.Element = Element;
        return old;
    }
    public void  add(int index , T Element){
//        if (index == 0){
//            addhead(Element);
//            size++;
//            return;
//        }
        if (index==size){
            addend(Element);
        }else {
            Node<T> pt = node(index - 1);
            pt.next.prev = new Node<>(Element, pt.next, pt);
            pt.next = pt.next.prev;
        }
        size++;
    }
    public  void add( T Element){
        addend(Element);
        size++;
    }
    private void addend( T Element){
        if (last == null) {
            last = new Node<>(Element,null, null);
            first = last;
            return;
        }
        last.next = new Node<>(Element,null,last);
        last = last.next;
    }
    //    private void addhead(T Element){
//        if (first ==null){
//            first = new Node<>(Element,first,null);
//            last = first;
//            return;
//        }
//        first.prev = new Node<>(Element,first,null);
//        first = first.prev;
//    }
    public T  remove(int index){
//        check(index);
        Node<T> pt = node(index);
        if (index == 0){
            first.prev=null;
            first = pt.next;
        } else if (index ==size-1) {
            last = pt.prev;
            last.next =null;
        } else {
            pt.prev.next=pt.next;
            pt.next.prev =pt.prev;
        }
        size--;
        return pt.Element;
    }
    //    public void remove(@NotNull Node<T> Node){
//        Node.next.prev= Node.prev;
//        Node.prev.next = Node.next;
//    }
    public int size(){
        return size;
    }
    public Boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
//        Node<T> pt = first;
        StringBuilder str = new StringBuilder("size =").append(size).append(" [");
        int st = 0;
        for (T s : this ){
            if (size-1==st){
                str.append(s);
                break;
            }
            st++;
            str.append(s).append(",");
//            str.append(s).append(",");
        }
        str.append("]");
        return str.toString();
    }

    private void check(int index){
        if (size != 0 && (index < 0 || index >= size)){
            throw  new ArrayIndexOutOfBoundsException("can't(index < 0 || index >=size)");
        }
    }
}
class Test{

    public static void main(String[] args) {
        双向链表<Integer> list = new 双向链表<>();
        for (int i=1;i<9;i++){
            list.add(i);
        }
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"");
        }
        System.out.printf("\n");
        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"");
        }
        System.out.printf("\n");
        fx(0,3,list);

    }
    public static void fx(int standad, int del,  双向链表 list){
        while (list.size()!= 1 ){
            int dele = (standad+del-1) % list.size();
            System.out.print(list.remove(dele)+" ");
            standad = dele;
        }
        System.out.println(list);
    }
}
class Book<T> implements Comparable<T>,sr {
    private int cost;

    public Book(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "cost=" + cost +
                '}';
    }

    @Override
    public int compareTo( T o) {
        return (this).cost -((Book)o).cost;
    }

    public static void main(String[] args) {
        Book<Object> objectBook = new Book<>(360);
        Book[] st = new Book[]{
                objectBook,
                new Book<>(490),
                new Book<>(230),
        };
        System.out.println(Arrays.toString(st));
        Arrays.sort(st);
        System.out.println(Arrays.toString(st));
    }

    @Override
    public T st() {
        return (T)Integer.valueOf(6);
    }

}
interface  sr<T>{
    T st();
}
