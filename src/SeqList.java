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
        return null;//return执行完可以直接跳出方法体
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
    public int insert(int i,T x)//插入x作为第i个元素，x！=null，则抛出空对象异常。O（n）
    {
        if(x==null)
            throw new NullPointerException("x==null");
        if (i<0)
            i=0;
        if (i>this.n)
            i=this.n;
        //这两个if语句对序号i采取容错处理
        Object[] source=this.element;//数组引用赋值，source也引用element
        if (this.n==element.length)//若数组满则扩充顺序表的数组容量
        {
            this.element=new Object[source.length*2];//重新申请一个容量更大的数组
            for (int j=0;j<i;j++)//复制当前数组钱i-1个元素
                this.element[j]=source[j];
        }
        for(int j=this.n-1;j>=i;j--)//从i开始至表尾的元素向后移动，次序从后向前
            this.element[j+1]=source[j];
        this.element[i]=x;
        this.n++;
        return i;//返回x序号
    }
    public int insert(T x)//顺序表尾插入x元素，返回x序号。成员方法重载。
    {
        return this.insert(this.n,x);
    }
    public T remove(int i)//删除第i个元素，并返回被删除的元素；若i越界则返回null
    {
        if (this.n>0&&i>=0&&i<this.n)
        {
            T old=(T)this.element[i];//old中存储被删除的元素
            for (int j=i;j<this.n-1;j++)
                this.element[j]=this.element[j+1];//元素前移一个位置
            this.element[this.n-1]=null;//设置数组元素对象为空，释放原先引用的实例
            this.n--;
            return old;//返回old局部变量引用的对象，传递对象引用。
        }
        return null;
    }
    public void clear()//删除线性表所有元素
    {
        this.n=0;//设置长度为0，未释放数组空间。
    }



}
