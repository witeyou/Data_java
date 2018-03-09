public class SinglyList_reverse
{
    //构造反序单链表，由values数组提供元素，返回值类型前声明类型参数T
    //采用头插入，单链表元素次序与数组元素相反。
    public static<T>SinglyList<T>createReverse(T[] valuse)
    {
        SinglyList<T>list1=new SinglyList<T>();//构造空单链表
        Node<T>p=list1.head;
        for(int i=0;i<valuse.length;i++)
        {
            list1.head.next=new Node<T>(valuse[i],list1.head.next);

        }
        return list1;
    }
    public static<T>void reverse(SinglyList<T> list)
    {
        Node<T>front=null;
        Node<T>p=list.head.next;
        Node<T>succ=p.next;
        while (succ!=null)
        {
            p.next=front;
            front=p;
            p=succ;
            succ=succ.next;
        }
        p.next=front;
        front=p;
        list.head.next=front;
    }
    public static void main(String args[])
    {
        String[] values={"A","B","C","D","E","F"};
        SinglyList<String>list=createReverse(values);
        System.out.print("list="+list.toString());
        reverse(list);
        System.out.println(",逆转后"+list.toString());
    }
}
