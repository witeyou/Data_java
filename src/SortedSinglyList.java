//排序单链表类（升序），T或T的某个祖先类实现Comparable<T>接口；继承单链表
public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>
{
    public SortedSinglyList()//构造空排序单链表
    {
        super();//默认调用父类构造方法SinglyList()
    }
    public SortedSinglyList(T[] values)//构造，将values数组中所有对象按值插入
    {
        super();
        for (int i=0;i<values.length;i++)
            this.insert(values[i]);//排序单链表按值插入
    }
    public SortedSinglyList(SortedSinglyList<T> list)//深拷贝构造方法
    {
        super(list);
    }
    public SortedSinglyList(SinglyList<T> list)//重载深拷贝，由单链表构造排序单链表
    {
        super();
        for (Node<T>p=list.head.next;p!=null;p=p.next)
            this.insert(p.data);//排序单链表按值插入
    }
    //不支持父类的以下两个方法，将其覆盖并抛出异常。方法体同排序单链表
    public void set(int i,T x) {}
    public Node<T>insert(int i,T X){return null;}
    //插入x，x！=null，根据x对象的大小顺序查找确定插入位置，插入在等值结点之前，
    // 返回插入结点。O(n)。覆盖父类的insert(x)方法
    public Node<T>insert(T x)
    {
        Node<T>front=this.head,p=front.next;
        while (p!=null&&x.compareTo(p.data)>0)//寻找插入的位置
        {
            front=p;
            p=p.next;
        }
        front.next=new Node<T>(x,p);//在front之后，p之前插入值为x结点
        return front.next;//返回插入结点
    }
    //以下顺序表查找和基于查找算法的操作，都覆盖父类的同名方法。
    //调用compareTo()方法比较大小和相等。方法体省略
    public Node<T>search(T key)//查找返回首个与key相等元素结点，查找不成功返回null
    {return null;}
    public Node<T>insertDifferent(T x)//插入不重复元素，查找不成功时按值插入
    {
        return null;
    }
    public T remove(T key)//删除首个与key相等的元素，返回被删除的元素；查找不成功返回null
    {
        return null;
    }
    public void addAll(SinglyList<T> list)//将list中所有元素插入到this单链表，不改变list，集合并。覆盖
    {}


}
