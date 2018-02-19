package linklist;

import error_throw.TestException;

public class Linklist {
    Node head;
    int sum;
    Node nil=new Node();
    Linklist(){
        head=null;
        sum=0;
    }
//    public static void main(String[] args) {
//        Linklist a=new Linklist();
//        for(int i=0;i<10;i++)
//        a.linklistInsert(a,i);
//        a.printLinklist(a);
//        Node o=a.linklistSearch(a,1);
//        System.out.println(o.data+""+o.prev+""+a.sum);
//        Node r=a.linklistSearch(a,3);
//        a.deleteNode(a,r);
//        System.out.println(a.sum);
//        a.printLinklist(a);
//    }//this is the test of the 
    class Node{
        public int data;
        public Node next;
        public Node prev;
        Node(){}
        Node(int x){
            this.data=x;
        }
        public Linklist getOutclass(){
            return Linklist.this;
        }
        public void dispOutclass(){
        }
    }
    public Node linklistSearch(Linklist l,int x){
        Node temp=l.head;
        while(temp.data!=x&&temp!=null)//in fact this means the null is just like a box but dom't have amy thing
            temp=temp.next;
        return  temp;//如果有的话他就会这个实例对象，如果没有的话就只是一个空值也就是说啥都没找到
    }
    public void linklistInsert(Linklist l,int x){//in fact we can use local class to do this
        Node t=new Node(x);
        t.next=l.head;
        if (l.head!=null)
            l.head.prev=t;//just because null don't have anything
        l.head=t;
        t.prev=null;
        l.sum++;
    }
    public void deleteNode(Linklist l,Node t){
        if(t.prev==null)
            l.head=t.next;
        else
            t.prev.next=t.next;
        if(t.next!=null)
            t.next.prev=t.prev;
        l.sum--;
    }
    public void printLinklist(Linklist l){
        Node temp=l.head;
        int i=0;
        while(temp!=null)
        {
            i++;
            System.out.println("The "+i+" th number is"+temp.data);
            temp=temp.next;
        }
    }
}
class TestLinkStack{
    Linklist a;
    Linklist.Node top;
    TestLinkStack(){
        a=new Linklist();
        top=null;
    }
    private void Push(TestLinkStack e, Linklist.Node t){
        e.a.linklistInsert(e.a,t.data);
        e.top=t;
    }
    private Linklist.Node Pop(TestLinkStack e){
        Linklist.Node temp=e.a.head;
        e.a.deleteNode(e.a,e.a.head);
        top=e.a.head;
        return temp;
    }

    public static void main(String[] args) {
        TestLinkStack s=new TestLinkStack();
        for(int i=0;i<10;i++)
        s.Push(s,s.a.new Node(i));
        Linklist.Node temp=s.Pop(s);
        System.out.println(temp.data);
    }
}