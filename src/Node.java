public class Node<T>//单链表结点类，T指定节点的元素类型
{
    public T date;//数据域，存储数据元素
    public Node<T> next;//地址域，引用后继节点
    public Node(T data,Node<T> next)//构造结点，data指定数据元素，next指定后继结点
    {
        this.date=data;//引用赋值
        this.next=next;//引用赋值
    }
    public Node()
    {
        this(null,null);
    }
    public String toString()//返回结点数据域的描述字符串
    {
        return this.date.toString();
    }
}
