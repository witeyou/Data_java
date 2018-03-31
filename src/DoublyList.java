//本作用于第二次试验

public class DoublyList<T> extends DoubleNode<String>
{
    public DoubleNode<T>head,rear;//成员变量头和尾指针
    public DoublyList()//创建空的头结点
    {
        rear=this.head=new DoubleNode<T>();
    }
    public DoublyList(T[] values)//用数组给链表赋值
    {
        this();
        for (int i=0;i<values.length;i++)//若values.length()==0,构造空链表
        {
            //尾插入，创建结点链入rear结点之后
            rear.next= new DoubleNode<T>(values[i],rear,null);
            rear=rear.next;//rear指向新的链尾结点。
        }
    }
    public String toString()//输出用于检查
    {
        String str=this.getClass()+"(";//返回类名
        for (DoubleNode<T>p=this.head.next;p!=null;p=p.next)//p遍历单链表
        {
            str+=p.data.toString();
            if (p.next!=null)
                str+=",";//不是最后一个结点时，加分隔符
        }
        return str+")";
    }
    public void replaceAll(CirDoublyList<T>pattern,CirDoublyList<T>list)
    {
    DoubleNode<T>thisP=this.head.next;
    DoubleNode<T>matchRear=this.head.next;
    DoubleNode<T>matchHead=this.head.next;
    DoubleNode<T>patternP=pattern.head.next;
    while (thisP!=null)
    {
        while (thisP!=null)//找到被匹配的头
            if (thisP.data.equals(patternP.data))
            {
                matchHead=thisP;
                break;
            }
            else
            {
                break;
            }
        while (thisP!=null)//找到被匹配的尾,不能确定是真是假，需要后来去判定
        {
            if (thisP.data.equals(patternP.data))
            {
                matchRear = thisP;
                thisP=thisP.next;//此句过后指向当前的下一个
                patternP=patternP.next;//此句过后指向当前的下一个
            }
            else
            {
                //thisP=thisP.next;//用于保证thisP不会后移陷入死循环
                break;
            }
        }
        //进行替换操作,用listCopy.head.prev来表示listCopy的尾结点
        if (matchHead==null||matchRear==null)
            thisP=thisP.next;
        else
            if (matchHead.data.equals(pattern.head.next.data)&&matchRear.data.equals(pattern.head.prev.data))
            {
                CirDoublyList<T> listCopy = new CirDoublyList<T>(list);
                matchHead.prev.next = listCopy.head.next;
                listCopy.head.next.prev=matchHead.prev;
                matchHead.prev = null;
                listCopy.head.prev.next = matchRear.next;
                matchRear.next.prev=listCopy.head.prev;
                matchRear.next = null;
                listCopy.head.next = null;//不确定是否有析构方法的作用
                listCopy.head.prev = null;
                listCopy.finalize();
                patternP = pattern.head.next;//归位patternP指针
                //matchHead=this.head.next;
                //matchRear=this.head.next;
                matchHead=null;
                matchRear=null;
            }
            else
                thisP=thisP.next;
        if (thisP==null)
            break;
    }
    }


}
    /*
    //替换表中的某种结点，根据结点的值来进行替换
    // key1是被替换的值，key2是替换的值
    public void replace(T key1,T key2)
    {
        for (DoubleNode<T>p=this.head.next;p!=null;p=p.next)
            if(key1.equals(p.data))//p.data.equals(key1)会产生什么影响？
                p.data=key2;
    }
    //所选课题，其中调用了上面的replace()方法
    public void replaceAll(CirDoublyList<T>pattern,CirDoublyList<T>list)
    {

        DoubleNode<T>patternP=pattern.head.next;
    DoubleNode<T>listP=list.head.next;
    //需要注意的提供的两个参数是循环双链表，遍历时应注意结尾的判定
    while (patternP!=pattern.head&&listP!=list.head)//防止pattern和list长度不同的情况
        {
            this.replace(patternP.data,listP.data);
            patternP=patternP.next;
            listP=listP.next;
        }
    */
/*
    public DoublyList(DoublyList<T>list)
    {
        this.head=new DoubleNode<T>();
        DoubleNode<T>rear=this.head;
        DoubleNode<T>listP=list.head.next;
        while (listP!=null)
        {
            rear.next=new DoubleNode<T>(listP.data,rear,null);
            rear=rear.next;
            listP=listP.next;
        }
    }
    */