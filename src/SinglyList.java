public class SinglyList<T> extends Object
{
    public Node<T> head;//头指针，指向单链表的头节点
    //(1)构造方法
    public SinglyList()//构造空单链表
    {
        this.head=new Node<T>();//创建头节点
    }
    public SinglyList(T[] values)//构造单链表，由values数组提供元素
    {
        this();//创建空单链表，只有头结点
        Node<T>rear=this.head;//rear指向单链表的最后一个结点
        for (int i=0;i<values.length;i++)//若values.length()==0,构造空链表
        {
            rear.next=new Node<T>(values[i],null);//尾插入，创建结点链入rear结点之后
            rear=rear.next;//rear指向新的链尾结点。
        }
    }
    public boolean isEmpty()
    {
        return this.head.next==null;
    }
    //(2)存取
    public T get(int i)//返回第i个元素，i表长度，若i越界，在返回null（）。O(n)
    {
        Node<T>p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)//遍历单链表，寻找第i个结点
            p=p.next;
        return (i>=0&&p!=null)?p.data:null;//若P指向目标，返回其元素值
    }
    public String toString()//返回单链表所有元素的描述字符串，形式为“（，）”。覆盖object类的toString（）方法，O（n）
    {
        String str=this.getClass().getName()+"(";//返回类名
        for (Node<T>p=this.head.next;p!=null;p=p.next)//p遍历单链表
        {
            str+=p.data.toString();
            if (p.next!=null)
                str+=",";//不是最后一个结点时，加分隔符
        }
        return str+")";
    }
    //（3）插入；插入X作为第i个元素，x！=null，返回插入的结点。对序号i采取容错措施
    public Node<T>insert(int i,T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");//抛出空对象异常
        Node<T>front=this.head;//front指向头结点
        for (int j=0;front.next!=null&&j<i;j++)//寻找第i-1个或最后一个结点，front指向
            front=front.next;
        front.next=new Node<T>(x,front.next);//在front之后插入值为x的结点
        return front.next;//返回插入的结点
    }
    public Node<T>insert(T x)//调用insert()方法，用整数最大值指定插入在最后，遍历一次，i必须容错
    {
        return insert(Integer.MAX_VALUE,x);
    }
    //(4)删除
    public T remove(int i)//删除第i个元素，返回被删除元素，若i越界，则返回null。O（n）
    {
        Node<T>front=this.head;
        for (int j=0;front.next!=null&&j<i;j++)//寻找第i-1个或最后一个结点，front指向
            front=front.next;
        if (i>=0&&front.next!=null)//若front的后继结点存在，则删除
        {
            T old=front.next.data;//获得待删除结点引用的对象
            front.next=front.next.next;//删除front的后继
            return old;
        }
        return null;
    }
    public void clear()//删除单链表所有元素
    {
        this.head.next=null;
    }
    //以下为自己实现的方法
    public Node<T>search(T key)//暂时实现并可以使用。查找返回首个与key相等元素的结点，查找不成功则返回null
    {
        if (key==null)
            throw new NullPointerException("x==null");//抛出空对象异常
        Node<T>p=this.head.next;
        while (p!=null)
        {
            if (key.equals(p.data))
                return p;
            p=p.next;
        }
        return null;
    }
    public boolean contains(T key)//暂时实现并可以使用。判断是否包含关键字为key元素
    {
        if (key==null)
            throw new NullPointerException("x==null");//抛出空对象异常
        Node<T>front=this.head;
        while (front.next!=null)
        {
            front=front.next;
            if (key.equals(front.data))
                return true;
        }
        return false;
    }
    public Node<T>insertDifferent(T x)//暂时实现并可以使用。插入不重复元素。查找不成功时尾插入
    {
        if (contains(x)==true)
        {
            System.out.println("该元素已存在");
            return null;
        }
        else
            return insert(x);

    }
    public T remove(T key)//暂未实现并可以使用。删除首个与key相等的元素。返回被删除元素，查找不成功返回null
    {
        Node<T>front=this.head;
        while (front.next!=null)
        {
            if (key.equals(front.next.data))
            {
                T old=front.next.data;//获得待删除结点引用的对象
                front.next=front.next.next;//删除front的后继
                return old;
            }
            front=front.next;
        }
        return null;

    }
    public void set(int i,T x)//暂时实现并可以使用。设置第i个元素为x。i表长度，x!=null
    {
        if (x==null)
            throw new NullPointerException("x==null");//抛出空对象异常
        if (i<1)
            i=1;
        Node<T>front=this.head.next;
        for(int j=0;front.next!=null&&j<i;j++)//遍历单链表，寻找第i个结点
            front=front.next;
        front.data=x;
    }
    public int size()//暂时实现并可以使用。O（n）
    {
        int count;
        Node<T> front=this.head;
        for (count=0;front.next!=null;count++)
            front=front.next;
        return count;
    }
    public void removeAllMatched(SinglyList<T> pattern)//暂时实现并可以使用。删除所有与pattern匹配的子表
    {
        for (Node<T>p=pattern.head.next;p!=null;p=p.next)
            this.remove(p.data);
    }
    public SinglyList(SinglyList<T> list)//暂时实现并可以使用。用于深拷贝
    {
        this.head=new Node<T>();
        Node<T>list_p=list.head.next;//指向被复制单链表的当前节点
        Node<T>rear=this.head;//rear指向单链表的最后一个结点
        while (list_p!=null)
        {
            rear.next=new Node<T>(list_p.data,null);//尾插入，创建结点链入rear结点之后
            rear=rear.next;//rear指向新的链尾结点。
            list_p=list_p.next;
        }
    }
    public void addAll(SinglyList<T> list)//在this单链表之后合并连接list，设置list为空
    {
        Node<T>rear=this.head;
        while (rear.next!=null)
            rear=rear.next;
        rear.next=list.head.next;
        list.head.next=null;

    }

}
