package list;

public class test{
    public static void main(String[]args){
        DList list  = new DList();
        list.insertFront("6");
        list.insertBack("15");
        System.out.println(list);
        list.insertAfter("9", list.front());
        list.insertBefore("12", list.back());
        System.out.println(list);
        list.remove(list.front());
        list.remove(list.back());
        System.out.println(list);
        LockDList list1 = new LockDList();
        list1.insertFront("2");
        list1.insertBack("8");
        System.out.println(list1);
        list1.insertAfter("4",list1.front());
        list1.insertBefore("6",list1.back());
        System.out.println(list1);
        list1.lockNode(list1.front());
        list1.remove(list1.front());
        list1.remove(list1.back());
        System.out.println(list1);
    
  }
}
