public final class SeqStack<T> implements Stack<T> {
    private SeqList<T> list;//使用顺序表存储栈元素

    //构造容量为length的空栈
    public SeqStack(int length) {
        this.list = new SeqList<T>(length);//执行顺序表的构造方法
    }

    //构造默认容量的空栈
    public SeqStack() {
        this(64);
    }

    //判断栈是否空，若空返回true
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    //元素x入栈，空对象不能入栈
    public void push(T x) {
        this.list.insert(x);//顺序表尾插入元素x，自动扩充容量
    }

    //返回栈顶元素，（但未出栈），若栈空则返回null
    public T peek() {
        return this.list.get(list.size() - 1);
    }

    //出栈，返回栈顶元素；若栈空则返回null
    public T pop() {
        return list.remove(list.size() - 1);
    }
}