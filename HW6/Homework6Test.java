/* Homework6Test.java */

import dict.*;

/**
 *  Initializes a hash table, then stocks it with random SimpleBoards.
 **/

public class Homework6Test {

  /**
   *  Generates a random 8 x 8 SimpleBoard.
   **/

  private static SimpleBoard randomBoard() {
    SimpleBoard board = new SimpleBoard();
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
	double fval = Math.random() * 12;
	int value = (int) fval;
	board.setElementAt(x, y, value);
      }
    }
    return board;
  }

  /**
   *  Empties the given table, then inserts "numBoards" boards into the table.
   *  @param table is the hash table to be initialized.
   *  @param numBoards is the number of random boards to place in the table.
   **/

  public static void initTable(HashTableChained table, int numBoards) {
    table.makeEmpty();
    for (int i = 0; i < numBoards; i++) {
      table.insert(randomBoard(), new Integer(i));
    }
  }

  /**
   *  Creates a hash table and stores a certain number of SimpleBoards in it.
   *  The number is 100 by default, but you can specify any number at the
   *  command line.  For example:
   *
   *    java Homework6Test 12000
   **/

  public static void main(String[] args) {
    int numBoards;

    if (args.length == 0) {
      numBoards = 100;
    } else {
      numBoards = Integer.parseInt(args[0]);
    }
    HashTableChained table = new HashTableChained(numBoards);
    initTable(table, numBoards);
    


    // To test your hash function, add a method to your HashTableChained class
    // that counts the number of collisions--or better yet, also prints
    // a histograph of the number of entries in each bucket.  Call this method
    // from here.
    HashTableChained hashTable= new HashTableChained(10);
    
    Entry inserted = hashTable.insert("CIS256", new Integer(100));
    System.out.println("Course: " + inserted.key());
    System.out.println("Your grade for the Course: " + inserted.value());
    hashTable.insert("MATH268", new Integer(98));
    hashTable.insert("PYHS270", new Integer(99));
    hashTable.insert("IDST102", new Integer(93));
    hashTable.insert("HIST201", new Integer(100));
    hashTable.insert("ECON102", new Integer(100));
    hashTable.insert("CIS264", new Integer(95));
    hashTable.insert("CIS255", new Integer(99));
    hashTable.insert("ECON100", new Integer(96));
    hashTable.insert("MATH275", new Integer(97));
    hashTable.insert("MATH270", new Integer(96));
    System.out.println("Times of collision: " + hashTable.collision());
    Entry found= hashTable.find("CIS264");
    System.out.println("The course you want to see: " + found.key());
    System.out.println("The grade for that course: " + found.value());
    Entry removed= hashTable.remove("IDST102");
    System.out.println("The course that I don't want to take: " + removed.key());
    System.out.println("Grade for that course: " + removed.value());
    Entry found1 = hashTable.find("CIS255");
    System.out.println("The course you want to see: " + found1.key());
    System.out.println("The grade for that course: " + found1.value());
    String numOfEntry=hashTable.toString();
    System.out.println(numOfEntry);
    
  }

}
