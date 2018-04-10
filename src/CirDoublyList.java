public class CirDoublyList<T>
{
    public DoubleNode<T> head;
    public CirDoublyList()//构造空循环单链表
    {
        this.head=new DoubleNode<>();
        this.head.prev=this.head;
        this.head.next=this.head;
    }
    public CirDoublyList(T[] values)//构造循环单链表，由values数组提供元素
    {
        this();
        DoubleNode<T>rear=this.head;
        for (int i=0;i<values.length;i++)
        {
            rear.next=new DoubleNode<T>(values[i],rear,this.head);
            rear=rear.next;
        }
        this.head.prev=rear;
    }
    public CirDoublyList(CirDoublyList<T> list)//深拷贝
    {
        this();
        DoubleNode<T>rear=this.head;
        DoubleNode<T>listP=list.head.next;
        while (listP!=list.head)
        {
            rear.next=new DoubleNode<T>(listP.data,rear,this.head);
            rear=rear.next;
            listP=listP.next;
        }
        this.head.prev=rear;
    }
    public String toString()//返回单链表所有元素的描述字符串，
    {
        String str=this.getClass()+"(";//返回类名
        for (DoubleNode<T>p=this.head.next;p!=this.head;p=p.next)//p遍历单链表
        {
            str+=p.data.toString();
            if (p.next!=this.head)
                str+=",";//不是最后一个结点时，加分隔符
        }
        return str+")";
    }
    public boolean isEmpty()
    {
        return this.head.next==this.head;
    }
    public DoubleNode<T> insert(int i,T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");
        DoubleNode<T>front=this.head;
        for (int j=0;front.next!=this.head&&j<i;j++)
            front=front.next;
        DoubleNode<T>q=new DoubleNode<T>(x,front,front.next);
        front.next.prev=q;
        front.next=q;
        return q;
    }
    public DoubleNode<T>insert(T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");
        DoubleNode<T>q=new DoubleNode<T>(x,head.prev,head);
        head.prev.next=q;
        head.prev=q;
        return q;
    }
    public T get(int i) {
        DoubleNode<T> p = this.head.next;
        for (int j = 0; p != this.head && j < i; j++)//遍历单链表，寻找第i个结点
            p = p.next;
        return (i >= 0 && p != null) ? p.data : null;
    }
    public String toPreviousString()
    {
        return null;
    }
    public T removelast()
    {
        return null;
    }
    public void finalize(){}
}
