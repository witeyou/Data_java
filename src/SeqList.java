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
        this(values.length);//创建容量为values.length的空表
        //若values==null，则用空对象调用方法，Java抛出NullPointerException空对象异常
        for (int i = 0; i < values.length; i++)//复制数组元素。O（n）
            this.element[i] = values[i];//对象引用赋值
        this.n = element.length;
    }

    public boolean isEmpty() //判断顺序表是否为空，若为空则返回true
    {
        return this.n == 0;
    }

    public int size() //返回顺序表元素个数
    {
        return this.n;
    }

    public T get(int i) //返回第i个元素，0<=i<n。若i越界，则返回null。
    {
        if (i >= 0 && i < this.n)
            return (T) this.element[i];//返回数组元素引用的对象，传递对象引用
        return null;//是否应该改成 else return null;
    }

    public void set(int i, T x)//设置第i个元素为x，0<=i<n。若i越界，则抛出序号越界异常；若x==null，则抛出空对象异常。
    {
        if (x == null)
            throw new NullPointerException("x==null");//抛出空对象异常
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i + "");//抛出序号越界异常
    }

    public String toString()//返回顺序表所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法
    {
        String str=this.getClass().getName()+"(";//返回类名
        if(this.n>0)
            str+=this.element[0].toString();
        for (int i=1;i<this.n;i++)
            str+=","+this.element[i].toString();//执行T类的toString()方法，运行时多态
        return str+")";//空表返回()
    }
    public String toPreviousString()//返回所有元素的描述字符串（次序从后向前）
    {
        String str=this.getClass().getName()+"(";//返回类名
        if(this.n>0)
            str+=this.element[n].toString();
        for (int i=n-1;i>=0;i--)
            str+=","+this.element[i].toString();//执行T类的toString()方法，运行时多态
        return str+")";//空表返回()
    }



}
