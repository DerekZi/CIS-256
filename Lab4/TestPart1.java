class X{
}
class Y extends X{
}
public class TestPart1{
    public static void main(String[] args){
       //X[] xa = new X[5];
       //Y[] ya = new Y[5];
       //ya = (Y[])xa; //Part a
       //xa = ya;      //Part a
       //xa = ya;       //Part b
       //ya = (Y[])xa; //Part b
       X[] xa = new X[5]; //Partc
       //X[] xa = new Y[5]; //Partc
       Y[] ya = new Y[5]; //Partc
       ya = (Y[])xa; //Partc
       xa = ya; //Partc

    }
}
/*Part I:(a): Yes, we can assign xa to ya by casting xa to Y[] at compile time, and assign ya to xa without casting at compile time
              However, at run-time, ClassCastException happpens.
         (b): Yes, we can assign ya to xa. To assign ya back from xa to ya, we need to cast xa so that we can assign it back
         (c): No, even if we cast xa, we will still get ClassCastException for doing that. 
              Because of the happening of ClassCastException, we cannot assign xa back
              Yes, if xa references objects that are all of class Y, we can assign xa to ya by casting because by declaring xa to reference object that are all of class Y
              we tell Java that every X is a Y, and array of xa will reference to objects of Y, and we can assign back from ya to xa*/

            