package linklist;

public class DoubleListWithSentinel {
    public Node nil;
    public int sum;
    public DoubleListWithSentinel(){
        nil=new Node();
        nil.prev=nil;
        nil.next=nil;
        sum=-1;
    }

    public class Node{
        int data;
        Node next;
        public Node prev;
        Node(){}
        Node(int x){
            data = x;
            next=null;
            prev=null;
        }
    }
    private void insertDl(DoubleListWithSentinel l,Node t){
        t.next=l.nil.next;
        l.nil.next.prev=t;
        t.prev=l.nil;
        l.nil.next=t;
    }
    private Node searchDL(DoubleListWithSentinel l,int x){
        Node temp=l.nil.next;
        while(temp!=nil&&temp.data!=x){
            temp=temp.next;
        }
        return temp;
    }
    private void deleteDL(DoubleListWithSentinel l,Node t){
        t.prev.next=t.next;
        t.next.prev=t.prev;
    }
    private void printDl(DoubleListWithSentinel l){
        Node temp=l.nil.next;
        if(l.nil.next==l.nil)
            System.out.println("this is an empty list");
        while(temp!=l.nil){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        DoubleListWithSentinel a=new DoubleListWithSentinel();
        a.printDl(a);
        for(int i=10;i>=0;i--){
            a.insertDl(a,a.new Node(i));
        }
        a.printDl(a);
        Node r=a.searchDL(a,2);
        System.out.println(r.data+" "+r.next+" "+r.prev);
        a.deleteDL(a,r);
        a.printDl(a);
    }
}
