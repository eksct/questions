class SLNode<T>{
    public  T date;
    public  SLNode next;
    SLNode(T date,SLNode next){
        this.date = date;
        this.next = next;
    }
    SLNode(){

    }
    @Override
    public String toString() {
        return  this.date.toString();
    }
}
class LinkList<T>{
    SLNode head;
    int n;
    LinkList(){//头节点
        this.head = new SLNode<>();
    }
    LinkList(T[] vluae){//数组创建单链表
        this();
        SLNode pre = this.head;
        for (int i =0;i< vluae.length && vluae[i]!=null;i++){
            this.n+=1;
            pre.next = new SLNode<>(vluae[i],null);
            pre =pre.next;
        }
    }
    public boolean ISmepty(){//判空
        return(this.head.next==null) ? true : false;
    }
        public void inerts(int x,T data) {//插入节点在x节点
        if (data==null) throw  new NullPointerException("node==null");
        SLNode P = this.head;
        for (int i=0;i<x;i++){
            P =P.next;
        }
        if (P!= null && x>=0 && this.n>=x){
            P.next =new SLNode(data,P.next);
            this.n++;
        }else  throw  new NullPointerException();
        }
        public void inerts(T x){//尾部插入
            inerts(this.n,x);
        }
    public  void inertsdata(int x,T data){//修改x位节点数据
        if (data==null) throw  new NullPointerException("node==null");
        SLNode P = this.head;
        for (int i=0;i<=x;i++){
            P =P.next;
        }
        if (P!=null && x>=0 && this.n>=x){
            P.date = data;
        }else throw new ArrayIndexOutOfBoundsException("null OR x<0");
    }
    public T Delete(int x){//删除第x节点,返回删除值
        SLNode P = this.head;
        for (int i=0;i<x;i++){
            P = P.next;
        }
        T S = (T)P.next.date;
        if (P.next.next!=null && x>=0 && this.n >=x){
            this.n--;
            P.next = P.next.next;
        }else throw  new ArrayIndexOutOfBoundsException();
        return S;
    }
    public void Cel(){
        this.head.next=null;
        this.n=0;
    }
    public  int size(){
        return this.n ;
    }
    public boolean SKey(T key){
        SLNode P = this.head;
        for (int i=0;i<this.n;i++){
            if (key.equals(P.date)){
                return true;
            }else P=P.next;
        }
        return false;
    }
    public T SKeyDelete(T key){
        SLNode P = this.head;
        for (int i=0;i<this.n;i++){
            T S = (T) P.date;
            if (key.equals(P.date)){
                Delete(i-1);
                return S;
            }else P = P.next;
        }
        return null;
    }

}
public class SingleLinkedList {

    public static void main(String[] args) {
        String[] str = {"A", "B", "C", "D"};
        LinkList list = new LinkList<>(str);
        list.inerts(1,"cccc");
        list.inertsdata(0,"666");
        System.out.println(list.Delete(0));
        list.inerts("乐");
        list.Cel();
        System.out.println(list.ISmepty());
        System.out.println(list.size());
        System.out.println(list.SKey("BE"));
        System.out.println(list.SKeyDelete("A"));
        SLNode pt = list.head.next;
        while (pt!=null){
            System.out.println(pt);
            pt=pt.next;
        }
    }
}