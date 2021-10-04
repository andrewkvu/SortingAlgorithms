package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {
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
	 * Function that is used to recursively sort the values in an
	 * array using a low and high index
	 * 
	 * @param nums - the array given to merge sort
	 * @param low - the lowest bound of merge sort
	 * @param high - the higher bound of merge sort
	 */
	public static void mergeSort(int[] nums, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;		// creates middle of the array
			
			mergeSort(nums, low, mid);		// left side of the sort recursively called until first two elements merged and sorted
			mergeSort(nums, mid + 1, high); // right side of the sort recursively called until first two elements merged and sorted
			
			merge(nums, low, mid, high);
		}
	}
	
	/*
	 * Function that merges the two arrays together from the merge sort
	 * 
	 * @param nums - the array given to merge
	 * @param low - the lower bound
	 * @param mid - mid given from mergeSort to break up the array into two different halves
	 * @param high - the higher bound
	 */
	public static void merge(int[] nums, int low, int mid, int high) {
		int bSize = (high - low) + 1;	// size of the temp array b
		int[] b = new int[bSize];		// temp array to store results
		int left = low;					
		int right = mid + 1;
		int bIndex = 0;
		
		// while there are still more elements to be sorted into b array
		// comparing the left and the right of the current lower and upper bound 
		while (left <= mid && right <= high) {
			// copies whatever current value is lower between the left and right array
			// and increments both bIndex and the left/right index
			// also when both halves have unmerged items
			if (nums[left] <= nums[right])		
				b[bIndex++] = nums[left++];// same as: b[bIndex] = nums[left]; bIndex++; left++;
			else
				b[bIndex++] = nums[right++];
		}
		
		// used to set the other element that was bigger than the one that was just put
		// into the b array using the above while loop
		// remaining items are copied into b
		while (left <= mid)
			b[bIndex++] = nums[left++];
		while (right <= high)
			b[bIndex++] = nums[right++];
		for (int k = 0; k < bSize; k++) {
			nums[low+k] = b[k];				// copied back into nums
		}
			
		b = null; // deletes temp b array to free space of b

	}
	/*
	 * Tests the mergeSort method by first scanning the
	 * MyList-1.txt file into an array and then sorting it
	 * using merge sort
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File arrayFile = new File("MyList-3.txt");
		int[] nums = scan(arrayFile); // creates the array 
		// first initiate mergeSort by using the:
		// lowest bound: index 0
		// highest bound: index nums.length -1
		
		
		// output
		String unsorted = "Unsorted: \n[";
		for (int i = 0; i < nums.length; i++) {
			unsorted += nums[i] + " ";
		}
		System.out.println(unsorted + "]");
		
		
		mergeSort(nums, 0, nums.length - 1);
		
		String sorted = "Merge Sorted: \n[";
		for (int i = 0; i < nums.length; i++) {
			sorted += nums[i] + " ";
		}
		System.out.println(sorted + "]");
		
	}
	
	
}
