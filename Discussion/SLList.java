public class SLList{
    private class IntNode{
        private int item;
        private IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;
    public void addFirst(int x){
        first = new IntNode(x,first);
    }
    public String toString() {
        int val;
        String result = "[  ";
        IntNode cur = first;
        while (cur != null) {
          val = cur.item;
          result = result + val + "  ";
          cur = cur.next;
        }
        result = result + "]";
        return result;
      }

    public void insert(int item, int position){
        if(first==null||position==0){
            addFirst(item);
        }else{
            IntNode cur = first;
            while(position>1&&cur.next!=null){
                cur = cur.next;
                position--;
            }
            if(cur.next == null){
                cur.next = new IntNode(item,null);
            }else{
                cur.next = new IntNode(item,cur.next);
            }
        }
    }
    public void reverse(){
        if(first==null||first.next==null){
            return;
        }else{
            IntNode cur = first.next;
            while(cur!=null){
                IntNode temp = cur.next;
                first.next = temp;
                cur.next = first;
                first = cur;
                cur = temp;
            }
            }
        }

    public static int[] insert(int[] arr, int item, int position){
        int[] arr1 = new int[arr.length+1];
        if(arr.length==0||position==0){
            arr1[0] = item;
        }else{
            for(int i = 0; i<arr.length;i++){
                arr1[i] = arr[i];
            }
            if(position>arr1.length-1){
                arr1[arr1.length-1] = item;
            }else{
                for(int j = arr1.length-1;j>position;j--){
                    arr1[j]=arr1[j-1];
                }
                arr1[position] = item;
            }    
        }
        return arr1;
    }
    public static void reverse(int[] arr){
        if(arr.length==0||arr.length==1){
            return;
        }else{
            int temp;
            for(int i=0;i<arr.length/2;i++){
                int j = i+1;
                temp = arr[i];
                arr[i] = arr[arr.length-j];
                arr[arr.length-j] = temp;
            }
        }
    }
    public static int[] replicate(int[] arr){
        if(arr.length == 0){
            System.exit(0);
        }
        int[] arr1 = new int[arr.length*2];
        for(int i=0; i<arr.length; i++){
            arr1[i*2] = arr[i];
            arr1[2*i+1] = arr1[i*2];
        }
        return arr1;

    }
    public static void main(String[] args){
        SLList list = new SLList();
        list.addFirst(2);
        list.addFirst(6);
        list.addFirst(5);
        System.out.println(list);
        list.insert(10, 1);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        int[] arr = {5,9,14,15};
        for(int item:arr){
            System.out.print(item+" ");
        }
        System.out.println();
        int[] arr1 = insert(arr,6,2);
        for(int item:arr1){
            System.out.print(item+" ");
        }
        System.out.println();
        reverse(arr1);
        for(int item:arr1){
            System.out.print(item+" ");
        }
        System.out.println();
        int[] arr2 = replicate(arr);
        for(int item:arr2){
            System.out.print(item+" ");
        }

    }
}