package sort;

public class HeapSort {
	
	// DONT CHANGE; VERY GOOD
	public static void buildMaxHeap(int[] a) {
		for (int i = a.length / 2; i >= 0; i--)
			maxHeapify(a, i, a.length);
	}
	
	// THIS ALSO MUST BE VERY GOOD IF IT WORKS FROM BUILDMAXHEAP
	public static void maxHeapify(int[] a, int i, int heapsize) {
		int largestIndex = i;		// default the largestindex is i
		int left = (2 * i) + 1; 	// left child
		int right = (2 * i) + 2;	// right child
		// check for largest number between left and right child
		// and change largestIndex based on that 
		if (left < heapsize && a[left] > a[largestIndex]) 
			largestIndex = left;
		if (right < heapsize && a[right] > a[largestIndex])
			largestIndex = right;
		
		// swap if there is a different largestIndex
		if (largestIndex != i) {
			// swap
			int temp = a[i];
			a[i] = a[largestIndex];
			a[largestIndex] = temp;
			// max heapify recursive call
			// only when there is a new swap so you have to heapify again
			// to check if everything is in the right place
			maxHeapify(a, largestIndex, heapsize);
		}
	}
	
	
	// VERY GOOD NOW; HAD TO ADD AN EXTRA PARAMETER BUT VERY GOOD
	public static void sort(int[] a) {
		buildMaxHeap(a);
		int heapsize = a.length; // initialize a heapsize of a.length to eventually decrease
		for (int i = a.length - 1; i >= 1; i--) {
			//swap
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			// how to decrease heapsize/arraysize
			// had to add extra parameter for heapsize in here
			heapsize--; // so that it doesnt swap with the largest which would obviously be at the end after swap
			//max heapify
			maxHeapify(a, 0, heapsize);
		}
	}
	
	public static void print(int[] a) {
		for (Integer i : a)
			System.out.print(i + " ");
		System.out.println();
	}
	

	public static void main(String[] args) {
		int[] a = {50, 30, 20, 25, 23, 21, 18, 19};
		int[] b = {24, 19, 21, 18, 17, 15, 14, 16, 11, 13};
		System.out.println("Original A");
		print(a);
		
		System.out.println("After buildMaxHeap");
		buildMaxHeap(a);
		print(a); // output: 50 30 21 25 23 20 18 19 
		
		System.out.println("Original B");
		print(b);
		System.out.println("After sorting b");
		sort(b);
		print(b); // output: 11 13 14 15 16 17 18 19 21 24 
	}
	
	
}
