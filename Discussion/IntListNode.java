public class IntListNode{
    int num;
    IntListNode next;
    public IntListNode(int num){
        this.num = num;
        next = null;
    }
    public IntListNode(int num, IntListNode next){
        this.num = num;
        this.next = next;
    }
}