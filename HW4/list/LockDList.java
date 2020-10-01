package list;
public class LockDList extends DList{
    protected LockDListNode newNode(Object i, DListNode p, DListNode n){
        return new LockDListNode(i,p,n);
    }
    public LockDList(){
        super();
    }
    public void lockNode(DListNode node){
        ((LockDListNode)node).isLock = true;
    }
    public void remove(DListNode node){
        if(((LockDListNode)node).isLock==false){
            super.remove(node);
        }
    }
}