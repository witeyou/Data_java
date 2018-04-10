public final class LinkedStack<T> implements Stack<T> {
    private SinglyList<T> list;

    //构造空栈
    public LinkedStack() {
        this.list = new SinglyList<>();//构造空单链表
    }

    //判断栈是否空，若空返回true
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    //元素x入栈，空对象不能入栈
    public void push(T x) {
        this.list.insert(0, x);//单链表头插入元素x
    }

    //返回栈顶元素（未出栈），若栈空返回null
    public T peek() {
        return this.list.get(0);
    }

    //出栈，返回栈顶元素，若栈空返回null
    public T pop() {
        return this.list.remove(0);//若栈不空，单链表头删除，返回删除元素
    }

}