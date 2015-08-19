/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harout
 */
/*
 * Harout Ter-Papyan
 * HeapTest.java
 */



public class HeapTest
{

   public static void printArray( int[] x)
   {
      System.out.print("Print heap array: " );
      if( x.length == 0)
         System.out.println("Heap array is empty");
      else
      {
         for(int k = 0; k < x.length; k++)
            System.out.print(x[k] + "  ");
         System.out.println();
      }
   }
   
   
   public static void main(String[] args)throws HeapException
   {
      MaxIntHeap h2 = new MaxIntHeap();
      //int[]z = { 44,-55,70,37,0, 52,44,-55,70,37,0, 52,44,-55,70,37,0, 52,44,-55,70,37,0, 52};
      int[]z = { 44,-55,70,37,0, 52};
      System.out.println("Inserting: ");
      printArray(h2.getHeapArray());
      System.out.println("Test 1  - heapInsert");            
      for ( int k = 0; k < z.length; k++){
         h2.heapInsert( z[k]);       
      printArray( h2.getHeapArray());
      }
      
      
      System.out.println("\nTest 2: removeMax");
      while( !h2.isEmpty())
      //for (int i = 1; i <= 10; i++)
      {
         int max = h2.removeMax() ; 
         System.out.print("max = " + max + "  ");
         printArray(h2.getHeapArray()); 
      }
      
      MaxIntHeap h3 = new MaxIntHeap(3);
      System.out.println("\nTest 3:  max() and size ");
      h3.heapInsert(5);
      h3.heapInsert(55);
      h3.heapInsert(60);
      System.out.println("max = " + h3.max() + "   heapsize = " + h3.size());
      printArray(h3.getHeapArray()); 
      
      System.out.println("\nTest 4 :  modifyHeap");
      MaxIntHeap t = new MaxIntHeap();
      int[] b = {30, 20, -10, 15, 10, 8};
      for( int i = 0; i < b.length; i++)
         t.heapInsert(b[i]);
      printArray(t.getHeapArray());  
      t.modifyHeap(1, 5);
      printArray(t.getHeapArray()); 
      t.modifyHeap(5, 32);
      printArray(t.getHeapArray()); 

      
      
      System.out.print("\nTest 5: ");
      int[] w = {2,4,6,5,3};
      MaxIntHeap h1 = new MaxIntHeap(4);
      try
      {         
         for ( int k = 0; k < w.length; k++)
            h1.heapInsert( w[k]);
      } 
      catch(HeapException e)
      {
         System.out.println(  e);
      }
      printArray(h1.getHeapArray()); 
      
      
      System.out.print ("\nTest 6:  ");
      try
      {         
         for ( int k = 0; k < w.length; k++)
            h1.removeMax();
      } 
      catch(HeapException e)
      {
         System.out.println(  e);
      }
       
      
      
      System.out.println("\nTest 7:  ");
      try
      {         
         h1.heapInsert(-40);
         h1.heapInsert(-4);
         printArray(h1.getHeapArray()); 
         while( !h1.isEmpty())
            System.out.print(h1.removeMax()+ "   " );
         System.out.println("  Heap size = " + h1.size());
         h1.max();
      }     
      catch(HeapException e)
      {
         System.out.println(  e);
      }
      
      System.out.print("\nTest 8:  " );
      try
      {
         h1.heapInsert(5);
         h1.heapInsert(12);
         h1.modifyHeap (3, 8);
      }
      catch( HeapException e)
      {
         System.out.println(e);
      }
      
      
      System.out.println("\nTesting Complete");
   
   
   
   }//end main

}

/* Output of Test Run --------------------------------

 
Inserting: 
Print heap array: Heap array is empty
Test 1  - heapInsert
Print heap array: 44  
Print heap array: 44  -55  
Print heap array: 70  -55  44  
Print heap array: 70  37  44  -55  
Print heap array: 70  37  44  -55  0  
Print heap array: 70  37  52  -55  0  44  

Test 2: removeMax
max = 70  Print heap array: 52  37  44  -55  0  
max = 52  Print heap array: 44  37  0  -55  
max = 44  Print heap array: 37  -55  0  
max = 37  Print heap array: 0  -55  
max = 0  Print heap array: -55  
max = -55  Print heap array: Heap array is empty

Test 3:  max() and size 
max = 60   heapsize = 3
Print heap array: 60  5  55  

Test 4 :  modifyHeap
Print heap array: 30  20  8  15  10  -10  
Print heap array: 30  15  8  5  10  -10  
Print heap array: 32  15  30  5  10  8  

Test 5: HeapException: Heap is full, cannot insert more values
Print heap array: 6  5  4  2  

Test 6:  HeapException: Error. Cannot Remove. Heap is Empty.

Test 7:  
Print heap array: -4  -40  
-4   -40     Heap size = 0
HeapException: Error. Cannot Remove. Heap is Empty.

Test 8:  HeapException: Error 3 is greater than the last node

Testing Complete






Testing Exceptions-----------------------------------

Inserting: 
Print heap array: Heap array is empty
Test 1  - heapInsert
Print heap array: 44  
Print heap array: 44  -55  
Print heap array: 70  -55  44  
Print heap array: 70  37  44  -55  
Print heap array: 70  37  44  -55  0  
Print heap array: 70  37  52  -55  0  44  
Print heap array: 70  37  52  -55  0  44  44  
Print heap array: 70  37  52  -55  0  44  44  -55  
Print heap array: 70  70  52  37  0  44  44  -55  -55  
Print heap array: 70  70  52  37  37  44  44  -55  -55  0  
Print heap array: 70  70  52  37  37  44  44  -55  -55  0  0  
Print heap array: 70  70  52  37  37  52  44  -55  -55  0  0  44  
Print heap array: 70  70  52  37  37  52  44  -55  -55  0  0  44  44  
Print heap array: 70  70  52  37  37  52  44  -55  -55  0  0  44  44  -55  
Print heap array: 70  70  70  37  37  52  52  -55  -55  0  0  44  44  -55  44  
Print heap array: 70  70  70  37  37  52  52  37  -55  0  0  44  44  -55  44  -55  
Print heap array: 70  70  70  37  37  52  52  37  -55  0  0  44  44  -55  44  -55  0  
Print heap array: 70  70  70  52  37  52  52  37  37  0  0  44  44  -55  44  -55  0  -55  
Print heap array: 70  70  70  52  37  52  52  37  44  0  0  44  44  -55  44  -55  0  -55  37  
Print heap array: 70  70  70  52  37  52  52  37  44  0  0  44  44  -55  44  -55  0  -55  37  -55  
Exception in thread "main" HeapException: Heap is full, cannot insert more values
	at MaxIntHeap.heapInsert(MaxIntHeap.java:45)
	at HeapTest.main(HeapTest.java:89)


  
  
  Inserting: 
Print heap array: Heap array is empty
Test 1  - heapInsert
Print heap array: 44  
Print heap array: 44  -55  
Print heap array: 70  -55  44  
Print heap array: 70  37  44  -55  
Print heap array: 70  37  44  -55  0  
Print heap array: 70  37  52  -55  0  44  

Test 2: removeMax
max = 70  Print heap array: 52  37  44  -55  0  
max = 52  Print heap array: 44  37  0  -55  
max = 44  Print heap array: 37  -55  0  
max = 37  Print heap array: 0  -55  
max = 0  Print heap array: -55  
max = -55  Print heap array: Heap array is empty
Exception in thread "main" HeapException: Error. Cannot Remove. Heap is Empty.
	at MaxIntHeap.removeMax(MaxIntHeap.java:86)
	at HeapTest.main(HeapTest.java:99)

  
 
 */
