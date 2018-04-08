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
        DoubleNode<T>thisP=this.head.next;//可以表示指向了this中匹配内容的尾
        DoubleNode<T>thisBegin=this.head;//指向this中匹配内容的头的前一个。也是回溯的起点
        DoubleNode<T>patternP=pattern.head.next;//指向pattern中当前被匹配的内容
        //以下这个循环要遍历整个单链表
        while (thisP!=null){
            //以下这个循环要遍历整个pattern,这个循环中已经包含了thisP&thisBegin的移位，patternP的复位
            while (thisP!=null&&thisP.data.equals(patternP.data)){
                //patternP==pattern.head 用于判断是否匹配全部完成
                if (patternP==pattern.head){
                    //匹配全部完成，则进行替换操作，并对patternP进行复位
                    patternP=pattern.head.next;//patternP进行复位
                    CirDoublyList<T> listCopy = new CirDoublyList<T>(list);
                    thisBegin.next = listCopy.head.next;
                    listCopy.head.next.prev = thisBegin;//改头
                    thisP=thisP.next;//此时thisP 指向了匹配内容的下一个
                    listCopy.head.prev.next=thisP;//改尾
                    if (thisP!=null) {
                        thisP.prev = listCopy.head.prev;
                        //thisP.next=null;这句话可能是不需要的
                        thisBegin=thisP.prev;//thisBeign回到thisP的前一位
                    }
                }//以下的else中两个指针同时右移准备进行下一元素的比较
                else {
                    patternP=patternP.next;
                    thisP=thisP.next;
                }
            }
            //如果从上面上面那个循环中跳出，说明匹配过程出现失败
            thisP=thisBegin.next.next;
            thisBegin=thisBegin.next;
        }
    }
}
