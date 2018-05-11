public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> parent, left, right;

    public BinaryNode(T data, BinaryNode<T> parent, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null, null);
    }

    public String toString() {
        return this.data.toString();
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }


}
