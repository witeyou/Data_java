public class SeqList<T> extends Object {
    protected Object[] element;//对象数组存储顺序表的数据元素，保护成员
    protected int n;//顺序表元素个数

    public SeqList(int length)//构建容量为length的空表
    {
        this.element = new Object[length];//申请数组的存储空间，元素为null
        //若length<0,则Java抛出负数组长度异常
        this.n = 0;
    }

    public SeqList() //创建默认容量的空表，构造方法重载
    {
        this(64);//调用本类已经声明的指定参数列表的构造方法
    }

    public SeqList(T[] values)//构建顺序表，由values数组提供元素
    {
        this(values.length);
        for (int i = 0; i < values.length; i++)
            this.element[i] = values[i];
        this.n = element.length;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public T get(int i) {
        if (i >= 0 && i < this.n)
            return (T) this.element[i];
        return null;
    }

    public void set(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i + "");
    }

    public String toString()
        {
            String str=this.getClass().getName()+"(";
            if(this.n>0)
                str+=this.element[0].toString();
            for (int i=1;i<this.n;i++)
                str+=","+this.element[i].toString();
            return str+")";
        }



}
