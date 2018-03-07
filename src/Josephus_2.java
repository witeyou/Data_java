public class Josephus_2
//用来检测是否单链表可以实现与顺序表相似的功能
//也用来改动检测SinglyList中尚未实现的方法。
{
    public Josephus_2(int number,int start,int distance)
    {
        System.out.print("Josephus 环("+number+","+start+","+distance+"),");
        //SeqList<String>list=new SeqList<String>(number);
        SinglyList<String>list=new SinglyList<String>();
        for(int i=0;i<number;i++)
            list.insert((char)('A'+i)+"");
        System.out.println(list.toString());
        /*int i=start;
        while (list.size()>1)
        {
            i=(i+distance-1)%list.size();
            System.out.print("删除"+list.remove(i).toString()+",");
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());
        */
        //System.out.println("用于检测size()的结果:"+list.size());
        //list.set(2,"");
        //System.out.println("用于检测set(2,\"\")的结果："+list.toString());

        list.remove("D");
        System.out.println("用于检测remove(\"D\")"+list.toString());

        //System.out.println("用于检测search(\"C\")"+list.search("C"));
        //list.insertDifferent("X");
        //System.out.println("用于检测insertDifferent()"+list.toString());

    }
    public static void main(String args[])
    {
        new Josephus_2(8,0,2);
    }
}
