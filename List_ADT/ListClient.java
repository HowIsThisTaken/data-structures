//-----------------------------------------------------------------------------
//  ListClient.java
//  A test client for the List ADT. Use this to test your list module. The
//  correct output is given below.
//-----------------------------------------------------------------------------

public class ListClient{
   public static void main(String[] args){
      /*System.out.println("List Client is now running.");
      List A = new List();
      List B = new List();

      System.out.println("Length of list: " + A.length());
      System.out.println("Index of cursor in list: " + A.index());
      System.out.println("First elemnt of list: " + A.first());
      System.out.println("Last element of list: " + A.last());
      System.out.println("Current element in list: " + A.get());

      for(int i=1; i<=5; i++){
         A.append(i);
         B.prepend(i);
      }

      System.out.println(A);
      System.out.println(B);
      B.moveFirst();
      B.insertBefore(6);
      System.out.println(B);
      B.moveNext();
      B.moveNext();
      B.moveNext();
      System.out.println("Current element in list: " + B.get());
      B.insertBefore(11);
      System.out.println(B);
      B.moveLast();
      B.insertBefore(13);
      System.out.println(B);
            System.out.println("Length of list: " + B.length());
      System.out.println("Index of cursor in list: " + B.index());
      System.out.println("First elemnt of list: " + B.first());
      System.out.println("Last element of list: " + B.last());
      System.out.println("Current element in list: " + B.get());
      
      for(A.moveFront(); A.index()>=0; A.moveNext()){
         System.out.print(A.get()+" ");
      }
      System.out.println();
      for(B.moveBack(); B.index()>=0; B.movePrev()){
         System.out.print(B.get()+" ");
      }
      System.out.println();
      
      List C = A.copy();
      System.out.println(A.equals(B));
      System.out.println(B.equals(C));
      System.out.println(C.equals(A));
      
      A.moveFront();
      for(int i=0; i<5; i++) A.moveNext(); // at index 5
      A.insertBefore(-1);                  // at index 6
      for(int i=0; i<9; i++) A.moveNext(); // at index 15
      A.insertAfter(-2);
      for(int i=0; i<5; i++) A.movePrev(); // at index 10
      A.delete();
      System.out.println(A);
      System.out.println(A.length());
      A.clear();
      System.out.println(A.length());*/
            List A = new List();
      List B = new List();
      
      for(int i=1; i<=20; i++){
         A.append(i);
         B.prepend(i);
      }
      System.out.println(A);
      System.out.println(B);
      
      for(A.moveFirst(); A.index()>=0; A.moveNext()){
         System.out.print(A.get()+" ");
      }
      System.out.println();
      for(B.moveLast(); B.index()>=0; B.movePrev()){
         System.out.print(B.get()+" ");
      }
      System.out.println();
      
      List C = A.copy();
      System.out.println(C);
      System.out.println(A.equals(B));
      System.out.println(B.equals(C));
      System.out.println(C.equals(A));
      
      A.moveFirst();
      for(int i=0; i<5; i++) A.moveNext(); // at index 5
      A.insertBefore(-1);                  // at index 6
      for(int i=0; i<9; i++) A.moveNext(); // at index 15
      A.insertAfter(-2);
      for(int i=0; i<5; i++) A.movePrev(); // at index 10
      A.delete();
      System.out.println(A);
      System.out.println(A.length());
      A.clear();
      System.out.println(A.length());
      List list = new List();
   }

}

// Output of this program:
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
// 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
// false
// false
// true
// 1 2 3 4 5 -1 6 7 8 9 11 12 13 14 15 -2 16 17 18 19 20
// 21
// 0
