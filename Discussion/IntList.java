public class IntList{
    private IntListNode head;
    private IntListNode tail;
    private int size;
    public IntList(){
        head = null;
        size = 0;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public void insertFront(int value){
        head = new IntListNode(value,head);
        if(isEmpty()){
            tail = head;
        }
        size++;
    }
    public void insertEnd(int value){
        IntListNode newest = new IntListNode(value);
        if(isEmpty()){
            head = newest;
            tail = head;
        }else{
            tail.next = newest;
            tail = tail.next;
        }
        size++;
    }
    public String toString() {
        int value;
        String result = "[  ";
    
        IntListNode cur = head;
    
        while (cur != null) {
          value = cur.num;
          result = result + value + "  ";
          cur = cur.next;
        }
        result = result + "]";
        return result;
      }
    public static void main(String[] args){
        IntList ilist = new IntList();
        IntList newList = new IntList();
        ilist.insertFront(7);
        ilist.insertFront(6); 
        ilist.insertEnd(8);
        ilist.insertEnd(9);
        System.out.println("Before squaring: "+ilist);
        newList = square(ilist);
        System.out.println("After squaring: "+newList);
        System.out.println("Original list: "+ilist); //check that change doesn't change the instance of the list
        squareDestructive(ilist.head);
        System.out.println("List after calling squareDestructive: "+ilist);
    }
    //iteratively
    public static IntList square(IntList L){ // return an IntList after squaring
        IntListNode cur = L.head;
        IntList squaredList = new IntList();
        while(cur!=null){
            squaredList.insertEnd(cur.num*cur.num);
            cur = cur.next;
        }
        return squaredList;
    }
    //recursively
    public static IntListNode square(IntListNode L){
        if(L==null){
            return null;
        }else{
            return new IntListNode(L.num*L.num, square(L.next));
        }
    }

    public static IntListNode squareDestructive(IntListNode L){
        if(L==null){
            return null;
        }else{
            L.num = L.num*L.num;
            return squareDestructive(L.next);
        }
    }
}