package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort {
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
	 * Function that sorts the array with bubble sort
	 * 
	 * @param nums - the array to be sorted
	 */
	public static int[] sort(int[] nums) {
		for (int i = nums.length - 1; i >= 1; i--) { 	// for loop to "decrease" the size of the array
			boolean sorted = true;					 	// used to determine whether to keep going in the sort
			for (int j = 0; j < i; j++) { 				// go through the array from start to i
				if (nums[j] > nums[j + 1]) {			// if the number before is greater than the number after
					swap(nums, j, j + 1);				// swap the two elements in the array
					sorted = false;						// this also means that the array is not fully sorted yet
														// so sorted is set to false
				}
			}
			if (sorted) 								// if sorted is still true, this means
														// this means there haven't been any swaps
				break;									// meaning no reason to sort anymore because already sorted
		}
		return nums;
	}
	/*
	 * Main method tests the bubble sort
	 */
	public static void main(String[] args) throws FileNotFoundException {		
		File arrayFile = new File("arr1-2.txt"); 	// creates array file
		int[] nums = scan(arrayFile); 				// creates array from scan function 
		String unsorted = "[";
		for (int i = 0; i < nums.length; i++) {
			unsorted += nums[i] + " ";
		}
		System.out.println(unsorted + "]");
		sort(nums); 								// uses sort function on nums
		
		
		// testing purposes only
		// prints out each value of the array
		String output = "[";
		for (int i = 0; i < nums.length; i++) {
			output += nums[i] + " ";
		}
		System.out.println("Bubble Sort: ");
		System.out.println(output + "]");

		
		System.out.println(Math.pow(2, 64));
	}
}
