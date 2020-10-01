/* HashTableChained.java */

package dict;


/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {
  protected List[] table;
  protected int size;
  protected int collision;



  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    while(!isPrime(sizeEstimate)){
      sizeEstimate++;
    }
    table = new DList[sizeEstimate];
    size = 0;
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    this(103);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
      int a = 10;
      int b = 12;
      int p = 2333;
      int compress = ((a*code+b)%p)%table.length;
      if(compress < 0){
        compress += table.length;
      }
      return compress;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    return size==0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    Entry e = new Entry();
    e.key = key;
    e.value = value;
    int hash = key.hashCode();
    int hashCode =compFunction(hash);
    if(table[hashCode] == null){
      table[hashCode] = new DList();
      ((DList)table[hashCode]).insertFront(e);
    }else{
      ((DList)table[hashCode]).insertFront(e);
      collision++;
    }   
    size++;
    return e;

  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    int hash = key.hashCode();
    int hashCode =compFunction(hash);
    try{  
      List l = table[hashCode];
      ListNode node = l.front();
      while(node.isValidNode()){
        if(((Entry)(node.item())).key().equals(key)){          
          return (Entry)node.item();
        }
        node = node.next();
      }
    }catch(InvalidNodeException ex){
      System.err.println(ex);
    }
    return null;
    

  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    int hash = key.hashCode();
    int hashCode =compFunction(hash);
    List l = table[hashCode];
    try{
      ListNode node = l.front();
      while(node.isValidNode()){
        if(((Entry)(node.item())).key().equals(key)){
          Entry found = (Entry)node.item();
          ((DListNode)node).remove();
          size--;
          return found;
        }
        node = node.next();
      }
    }catch(InvalidNodeException ex){
      System.err.println(ex);
    }
    return null;
    
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    table = new DList[table.length];
    size = 0;
  }
  public String toString() {
    String string="[  ";
    try{
      for (int i=0; i<table.length; i++) {
        int j=0;
        if (table[i]!=null) {
          ListNode node=table[i].front();
          while(node.isValidNode()) {
            node=node.next();
            j++;
          }
          string+=j+"  ";
        }
      }
    } catch (InvalidNodeException e) {
      System.out.println(e);
    }
    return string+"]";
  }

  public boolean isPrime(int x){
    int y = 2;
    while(x>y){
      if(x%y==0){
        return false; 
      }
      y++;
    }
    return true;
  }
  public int collision(){
    return collision;
  }
}
