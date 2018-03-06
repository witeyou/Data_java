public class Josephus
{
    public Josephus(int number,int start,int distance)
    {
        System.out.print("Josephus 环("+number+","+start+","+distance+"),");
        SeqList<String>list=new SeqList<String>(number);
        for(int i=0;i<number;i++)
            list.insert((char)('A'+i)+"");
        System.out.println(list.toString());
        int i=start;
        while (list.size()>1)
        {
            i=(i+distance-1)%list.size();
            System.out.print("删除"+list.remove(i).toString()+",");
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是"+list.get(0).toString());
    }
    public static void main(String args[])
    {
        new Josephus(5,0,2);
    }
}
