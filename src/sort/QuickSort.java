package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
	/* 
	 * Function that inputs the integer contents of a file 
	 * into an array of arraySize
	 * 
	 * @param file - the file that you are inputting numbers from
	 * 
	 * @return nums - the created array from the integer contents of file
	 */

	public static int[] scan(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file); 	// creates scanner
		int count = 0, index = 0; 				// used to increment the index of the array
		
		while (scanner.hasNextInt()) {			// while the file being scanned has another integer in its file
			scanner.nextInt(); 					// use count to get size of the array
			count++;							// increment count each time 
		}
		scanner.close();

		Scanner scanner2 = new Scanner(file);	// use different scanner to read each integer into the array
		int[] nums = new int[count];			// create a new array with the count variable from the first scanner
		while (scanner2.hasNextInt()) {			
			nums[index] = scanner2.nextInt();	// input each value of the file into the array
			index++;							// increment index each time to go through the array
		}
		scanner2.close();
		return nums; 							// return inputted array
	}
	
	/*
	 * Function that swaps two integers in an array given the indexes 
	 * that are being swapped
	 * 
	 * @param nums - the array given to swap
	 * @param swap1 - the first index to swap
	 * @param swap2 - the second index to swap
	 * 
	 */
	public static void swap(int[] nums, int swap1, int swap2) {
		// basic swap with temporary variable
		int temp = nums[swap1];
		nums[swap1] = nums[swap2];
		nums[swap2] = temp;
	}
	
	/*
	 * Function that initiates the quickSort and uses a pivotIndex
	 * and recursively sorts using divide and conquer technique
	 * 
	 * @param nums - the array given to quickSort
	 * @param low - the lower bound 
	 * @param high - the higher bound
	 */
	public static void quickSort(int[] nums, int low, int high) {
		if (low < high) { 									// as long as the lower bound < higher bound
			int pivotIndex = partition(nums, low, high); 	// gives the pivot index so that 
			quickSort(nums, low, pivotIndex - 1);			// quicksorts the left and keeps going until all sorted
			quickSort(nums, pivotIndex + 1, high);			// quicksorts the right and keeps going until all sorted
			// likely when the low and high are equal each other
			// for left: low = pivotIndex - 1
			// for right: pivotIndex + 1 = high
		}
		// if lowest no longer is < highest bound, sort is done
		
	}
	/*
	 * Function that partitions the given array to sort them
	 * 
	 * @param nums - the array given to partition
	 * @param i = the given lower bound
	 * @param j = the given higher bound
	 */
	public static int partition(int[] nums, int i, int j) { // i = lower, j = upper
		int pivot = nums[i]; 	// pivot initially is just the value of unsorted lower bound
		int m = i; 				// m = border between s1 and s2
		// |s1|s2|unsorted|
		// from 1 above the lower bound to the higher bound
		// check elements in the unprocessed region 
		for (int k = i + 1; k <= j; k++) { // k = border between s2 and unsorted
			// put elements into s1
			if (nums[k] < pivot) { 	// if current value is less than the pivot
				m++; 				// increment m which is the border between less than pivot and greater than pivot
				swap(nums, k, m);	// swap the current element with the border of s1 and s2
			}
		}
		swap(nums, i, m);			// at the end of the loop, swap the pivot value with the
									// middle border m to put the pivot in the right position
		return m;					// returns the index of the pivot back to the quickSort
		
	}
	
	/*
	 * Tests the quickSort method by first scanning the
	 * MyList-1.txt file into an array and then sorting it
	 * using quick sort
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File arrayFile = new File("MyList-2.txt");
		int[] nums = scan(arrayFile); // creates the array 
		// first initiate quickSort by using the:
		// lowest bound: index 0
		// highest bound: index nums.length -1
		
		
		// output
		String unsorted = "Unsorted: \n[";
		for (int i = 0; i < nums.length; i++) {
			unsorted += nums[i] + " ";
		}
		System.out.println(unsorted + "]");
		
		
		quickSort(nums, 0, nums.length - 1);
		
		String sorted = "Quick Sorted: \n[";
		for (int i = 0; i < nums.length; i++) {
			sorted += nums[i] + " ";
		}
		System.out.println(sorted + "]");
		
	}
}
