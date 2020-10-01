class X{
    protected int value;
    public int compareTo(Integer i){
        if(value>i.intValue()){
            return -1;
        }else if(value < i.intValue()){
            return 1;
        }else{
            return 0;
        }
    }
}
class Y extends X implements Comparable<Integer>{
    public Y(){
    }
    public Y(int i){
        value = i;
    }
    public int compareTo(Integer o){
        if(value>o.intValue()){
            return 1;
        }else if(value<o.intValue()){
            return -1;
        }else{
            return 0;
        }
    }
}
public class TestPart2{
    public static void main(String[] args){
        Y y = new Y(5);
        Integer i = 6;
        System.out.println(y.compareTo(i)); // 5<6. output is -1, which is same as what compareTo() in class Y should print out
    }
}
/*PartII: (a): Yes, Java will compile the result.
          (b): No, Java will not compile because method with a different return type is not overriding
          (c): No, Java will not compile because method with a different signiture is not overriding
          (d): Yes, Java will compile
*/