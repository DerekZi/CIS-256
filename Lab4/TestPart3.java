interface T{
    public static final int K =1;
}
class X{
    public static final int K =2;
}
class TestPart3 extends X implements T{
    public static void main(String[] args){
        System.out.println(X.K);
    }
}
/*part3: (a): Yes, Java will compile the result, and it make no differerce even if the values of K are the same.
         (b): No, Java will not compile the result, and it make no difference even if the values of K are the same;
         (c): X.K tells Java which K we are referencing to.
*/