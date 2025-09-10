package devtools;
import java.util.Scanner;
import java.util.Random;

public class BinarySearch {
	private static int size = 1000000;
	private static String[] arr = new String[size];
	private static Random rand = new Random();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		int output = -1;
		fillWithRandomString();
		printArray();
		while(input != "exit") {
			input = sc.nextLine();
			output = binarySearch(input);
			System.out.println(output);
		}
	}
	public static void printArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " - " + arr[i]);
		}
	}
	public static void fillWithRandomString() {
		String text = "";
		for(int i = 0; i < size; i++) {
			text = "";
			for(int j = 0; j < rand.nextInt(1, 15); j++) {
				text = text + (char)rand.nextInt(97, 123);
			}
			arr[i] = text;	
		}
	}
	public static int binarySearch(final String key) {
		for(int i = 0; true;) {
			if(arr[i] == key) {
				return i;
			}
		}
	}
	public static int linearSearch(final String key) {
		
		for(int i = 0; !hasFoundElement; i++) {
			if(arr[i] == key) {
				
			}
		}
		return 0;
	}
}
