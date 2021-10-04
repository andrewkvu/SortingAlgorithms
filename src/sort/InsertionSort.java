package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) throws FileNotFoundException {
		File arrayFile = new File("arr2-1.txt");
		Scanner scanner = new Scanner(arrayFile);
		int count = 0, lines = 0;
		int[] a = new int[50];
		
		while (scanner.hasNextInt()) {
			a[count] = scanner.nextInt();
			count++;
		}
		scanner.close();
		
		for (int i = 1; i < a.length; i++) {
			int next = a[i];
			int j;
			
			// fpr shifting elements over
			for (j = i - 1; j >= 0 && a[j] > next; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = next;
		}
		for (Integer i : a) {
			System.out.println(i);
		}
	}

}
