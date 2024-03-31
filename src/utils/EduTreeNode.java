package utils;

public class EduTreeNode<T> {
    public T data;
    public EduTreeNode<T> left;
    public EduTreeNode<T> right;
    public EduTreeNode<T> next;

    public EduTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}