class X{
    public void toTest(){
        System.out.println("superclass");
    }
}
class Y extends X{
    public Y(){             //part4(c)
        super.toTest();     //part4(c)
    }           
    public void toTest(){
        System.out.println("subclass"); 
    }
}
public class TestPart4{
    public static void main(String[] args){
        //Y y = new Y();    //part4(a)
        //((X)y).toTest();    //part4(a)
        //X x = new X();      //part4(b)
       // ((Y)x).toTest();    //part4(b)  
        Y y1 = new Y();     //part4(c)

    }
}
/*part4: (a): Java will call the subclass method due to dynamic method lookup. Casting will change the static type and will not change the dynamic type.
         (b): ClassCastException happens because Java is confused about which class of object you are going to call
         (c): Taking advantage of constructor and the super keyword, we can invoke the overridden method in superclass.
*/