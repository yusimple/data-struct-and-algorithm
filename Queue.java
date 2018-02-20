package Queue;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class Queue {
    int head;
    int tail;
    int length = 4;
    int b[] = new int[4];

    Queue() {
        head = 0;
        tail = 0;
    }

    public static void main(String[] args) {
        Queue a =new Queue();
        a.Enqueue(1);
        a.Enqueue(2);
        a.Enqueue(3);
        a.Enqueue(4);
        a.Enqueue(4);
        for (int temp : a.b) {
            System.out.println(a.Dequeue());
        }
        try {
            RandomAccessFile in=new RandomAccessFile("/home/yusimple/IdeaProjects/src/Queue/fullerror.txt","r");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void Enqueue(int x) {
        if ((tail + 1) % length == head) {

            System.out.println("the queue is full! ");
            PrintWriter out = null;
            try {
                out = new PrintWriter("/home/yusimple/IdeaProjects/src/Queue/fullerror.txt", "UTF-8");
                for (int i : this.b) {
                    out.print(i);
                    out.print(' ');
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        else
            this.b[tail++ % length] = x;

    }
    public int Dequeue() {
        assert (tail % length )!= head % length : "the queue is empty";
        return this.b[head++ % length];
    }
}
