package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {
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
	 * Function that sorts the array with selection sort
	 * 
	 * @param nums - the array to be sorted
	 */
	public static int[] sort(int[] nums) {
		for (int i = nums.length - 1; i >= 1; i--) {// used for swapping with the last index of the array
			int indexOfMax = i; 					// tracks the index of the max number 
			for (int j = 0; j < i; j++) { 			// goes through the array up to where it still needs to be sorted which is i
				if (nums[j] >= nums[indexOfMax]) { 	// if the value of the current position is greater than 
													// the value at the index of the max value at the time
					indexOfMax = j; 				// make j the new index of the max value
				}
			}
			// swap the value of the current last index with the value at the max index
			swap(nums, i, indexOfMax);				
		}
		return nums;
	}
	
	/*
	 * Main method tests the selection sort
	 */
	public static void main(String[] args) throws FileNotFoundException {		
		File arrayFile = new File("arr2-1.txt"); 	// creates array file
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
		System.out.println("Selection Sort: ");
		System.out.println(output + "]");
	}
}
