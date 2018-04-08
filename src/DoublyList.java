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
        DoubleNode<T>thisBegin=this.head.next;//指向this中匹配内容的头。也是回溯的起点
        DoubleNode<T>patternP=pattern.head.next;//指向pattern中当前被匹配的内容
        while (thisP!=null){
            if (thisP.data.equals(patternP.data)){
                while (true){
                    if(patternP.data.equals(thisP.data)){
                        patternP=patternP.next;
                        if(thisP.next!=null)
                            thisP=thisP.next;

                    }
                    else{
                        thisBegin=thisP=thisBegin.next;
                        patternP=pattern.head.next;
                        break;
                    }
                    if (patternP==pattern.head){
                        if(thisP.next!=null)
                            thisP=thisP.prev;
                        patternP=pattern.head.next;
                        break;
                    }
                }
            }
            else
                thisBegin=thisP=thisP.next;
            //接下来进行替换操作,如果thisP==thisBegin应是没有成功匹配
            if (thisP!=thisBegin) {
                CirDoublyList<T> listCopy = new CirDoublyList<T>(list);
                thisBegin.prev.next = listCopy.head.next;
                listCopy.head.next.prev = thisBegin.prev;
                thisBegin.prev = null;//链接头
                if (thisP.next!=null){
                    listCopy.head.prev.next = thisP.next;
                    thisP.next.prev = listCopy.head.prev;
                    thisP.next=null;//链接尾(是结尾的情况)
                    thisBegin=thisP=listCopy.head.prev.next;
                    listCopy.finalize();
                }
                else{
                    listCopy.head.prev.next =null;
                    thisBegin=thisP=listCopy.head.prev.next;
                    listCopy.finalize();
                }

            }
        }
   }
}
