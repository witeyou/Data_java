public class BinaryTree<T> {
    public BinaryNode<T>root;

    public BinaryTree(){
        this.root=null;
    }

    public boolean isEmpty(){
        return this.root==null;
    }

    //插入算法
    public BinaryNode<T> insert(T x){
        return this.root=new BinaryNode<T>(x,null,this.root,null);
    }
    public BinaryNode<T> insert (BinaryNode<T> parentnode,T x,boolean leftChild){
        if (x==null)
            return null;
        if (leftChild)
        {
            parentnode.left=new BinaryNode<T>(x,parentnode,parentnode.left,null);
            parentnode.left.left.parent=parentnode.left;
            return parentnode.left;
        }
        parentnode.right=new BinaryNode<T>(x,parentnode,null,parentnode.right);
        parentnode.right.right.parent=parentnode.right;
        return parentnode.right;

    }

    //用一个数组来实现树的构造
    public BinaryTree(T[] prelist){
        this.root=creat(prelist,this.root);
    }
    private int i=0;
    private BinaryNode<T>creat(T[] prelist,BinaryNode<T> parentnode){
        BinaryNode<T>p=null;
        if(i<prelist.length){
            T elem=prelist[i];
            i++;
            if (elem!=null){
                p =new BinaryNode<T>(elem,parentnode,null,null);
                p.left=creat(prelist,p);
                p.right=creat(prelist,p);
            }
        }
        return p;
    }

    //toString方法用于显示输出结果，递归实现。
    public String toString(){
        return toString(this.root);
    }
    private String toString(BinaryNode<T> p){
        if(p==null)
            return "^";
        return p.data.toString()+""+toString(p.left)+toString(p.right);
    }

    //实验题目，先根遍历查找首个与pattern匹配的子树。使用栈的非递归实现
    public BinaryNode<T> search(BinaryTree<T> pattern){
        LinkedStack<BinaryNode<T>>stack=new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p = this.root;
        while (p!=null||!stack.isEmpty()){
            if (p!=null){
                if (equals(p,pattern))
                    return p;
               stack.push(p);
               p=p.left;
           }
           else {
               p=stack.pop();
               p=p.right;
           }
        }
        return null;
    }
    private boolean equals(BinaryNode<T> start,BinaryTree<T> pattern){
        LinkedStack<BinaryNode<T>> stackT = new LinkedStack<BinaryNode<T>>();//this链的栈
        LinkedStack<BinaryNode<T>> stackP = new LinkedStack<BinaryNode<T>>();//pattern链的栈
        BinaryNode<T> p = start;                                             //this链中
        BinaryNode<T> q = pattern.root;                                      //pattern链中
        while ((q != null || !stackP.isEmpty()) && (p != null || !stackT.isEmpty())) {
            if (p != null && q != null && p.data.equals(q.data)) {
                stackP.push(q);
                q = q.left;
                stackT.push(p);
                p = p.left;
            } else {
                if (p == null && q == null) {
                    q = stackP.pop();
                    q = q.right;
                    p = stackT.pop();
                    p = p.right;
                } else return false;
            }
            if (q == null && stackP.isEmpty())//判断pattern遍历完成
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        String[] prelist={"A","B","D",null,null,"E",null,null,"C","F",null,null,"G",null,null};
        String[] pattern={"B","D",null,null,"E",null,null};
        BinaryTree<String> bitree =new BinaryTree<String>(prelist);
        BinaryTree<String> patternTree =new BinaryTree<String>(pattern);
        System.out.println("先根遍历prelisst："+bitree.toString());
        System.out.println("先根遍历pattern："+patternTree.toString());
        BinaryNode<String> result=bitree.search(patternTree);
        System.out.println("result:"+result.toString());
    }
}
