/* ListSorts.java */

import list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    LinkedQueue q1= new LinkedQueue();
    int size = q.size();
    try{
      for(int i=0;i<size;i++){
        LinkedQueue q2=new LinkedQueue();
        q2.enqueue(q.dequeue());
        q1.enqueue(q2);
      }
    }catch(QueueEmptyException ex){
      ex.printStackTrace();
    }
    return q1;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    LinkedQueue mq=new LinkedQueue();
    try{
      while(!q1.isEmpty()&&!q2.isEmpty()){
        if(((Comparable)q1.front()).compareTo((Comparable)q2.front())<=0){
          mq.enqueue(q1.dequeue());
        }else{
          mq.enqueue(q2.dequeue());
        }
      }
      while(!q1.isEmpty()){
        mq.enqueue(q1.dequeue());
      }
      while(!q2.isEmpty()){
        mq.enqueue(q2.dequeue());
      }
    }catch(QueueEmptyException ex){
      ex.printStackTrace();
    }
    return mq;
    
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    try{
      while(!qIn.isEmpty()){
        Comparable item = (Comparable)qIn.dequeue();
        if(pivot.compareTo(item)>0){
          qSmall.enqueue(item);
        }else if(pivot.compareTo(item)==0){
          qEquals.enqueue(item);
        }else{
          qLarge.enqueue(item);
        }
      }
    }catch(QueueEmptyException ex){
      ex.printStackTrace();
    }
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    LinkedQueue q1=makeQueueOfQueues(q);
    try{
      while(q1.size()>1){
        LinkedQueue i1 = (LinkedQueue)q1.dequeue();
        LinkedQueue i2 = (LinkedQueue)q1.dequeue();
        LinkedQueue s=mergeSortedQueues(i1,i2);
        q1.enqueue(s);
      }
      q.append((LinkedQueue)q1.dequeue());
    }catch(QueueEmptyException ex){
      ex.printStackTrace();
    }
    
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    java.util.Random random = new java.util.Random();
    int i = random.nextInt(q.size())+1;
    Comparable pivot = (Comparable)q.nth(i);
    LinkedQueue small = new LinkedQueue();
    LinkedQueue equal = new LinkedQueue();
    LinkedQueue large = new LinkedQueue();
    partition(q,pivot,small,equal,large);
    if(!small.isEmpty()){
      quickSort(small);
    }
    if(!large.isEmpty()){
      quickSort(large);
    }
    q.append(small);
    q.append(equal);
    q.append(large);


  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());

    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

    /*
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    */
  }

}
