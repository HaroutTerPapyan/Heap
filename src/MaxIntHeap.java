/*
 * Harout Ter-Papyan
 * MaxIntHeap.java
 */

public class MaxIntHeap 
{
	int[] heap;
	private int maxSize;
	private int currentSize;
	
	public MaxIntHeap() { 
		currentSize = 0;
		maxSize = 20;
		heap = new int[20];
	} // set array size to a default value of 20
	
	public MaxIntHeap( int m) { 
		if (m < 0) {
			currentSize = 0;
			maxSize = 20;
			heap = new int[maxSize];
		}
		else {
			heap = new int[m];
			maxSize = m;
			currentSize = 0;
		}
	} //constructor that sets max size of array
	
	public boolean isEmpty(){ 

		return currentSize == 0;
	}
	
	public int size() { 
		return currentSize;
	}
	
	public void heapInsert(int v) throws HeapException { 		
		
		if (currentSize == maxSize) 
			throw new HeapException ("Heap is full, cannot insert more values");
		
		else {
	         currentSize++;
	         heap[currentSize-1] = v;
	         trickleUp(currentSize-1);
		}
	}
	
	public void trickleUp(int index)
	{
	      while(index > 0 && heap[index] > heap[(index-1)/2]){
	          
	          int temp = heap[index]; 
	          heap[index] = heap[(index-1)/2];
	          heap[(index-1)/2] = temp;
	       
	          index = (index-1)/2;
	      }
	}	//end trickleUp
	
	public void trickleDown(int index)
	{
	      while(2*index+1<=currentSize-1 || 2*index+2<=currentSize-1){
	          int lc = largetChild(index);
	          if(heap[lc]>heap[index]){
	             int temp = heap[index];
	             heap[index]=heap[lc];
	             heap[lc]=temp;
	             index = lc;
	          }
	          else
	             break;
	       		
	       }
	}	// end trickleDown()
	

	public int removeMax ()throws HeapException  { 
		
		if (isEmpty()) {
			throw new HeapException ("Error. Cannot Remove. Heap is Empty.");
		}
		else {
	         int num = heap[0];
	         heap[0] = heap[currentSize-1];
	         currentSize--;
	         trickleDown(0);
	         return num;
		}
	}
	
	public int largetChild(int j){
	      if(2 * j + 2 < currentSize && heap[2 * j + 2]>heap[2 * j + 1])
	         return 2 * j + 2;
	      else
	         return 2 * j + 1;
	   }
	
	public int max() throws HeapException  {
		
		if(isEmpty()) 
			throw new HeapException("Error. Cannot Remove. Heap is Empty.");
		else
			return heap[0];
	}
	
	public void modifyHeap(int k , int newvalue) throws HeapException { 
		if(k < 0)
			throw new HeapException("Error " + k + " is less than zero.");
		else if (k > currentSize - 1)
			throw new HeapException("Error " + k + " is greater than the last node");
		else {
			heap[k] = newvalue;
	         if(largetChild(k)<size() && heap[k]<heap[largetChild(k)])
	            trickleDown(k);
	         else if (heap[(k-1)/2]<heap[k]) {
	        	 trickleUp(k);
	         }
		}
	} 
	// Changes value of kth index of heap to newvalue 
	//AND efficiently adjusts heap so that heap remains a heap
	
	public int[] getHeapArray(){ 
		int[] heapCopy = new int[size()];
		for (int i = 0; i < size(); i++) {
			heapCopy[i] = heap[i];
		}
		return heapCopy;
	}
	// return a truncated COPY of array holding heap values. See below.

}