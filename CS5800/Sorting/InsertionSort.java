public class InsertionSort {

	void insertionSort(int[] arr) {
		int l = arr.length;
		for (int i = 1; i < l; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String [] args) {
		InsertionSort is = new InsertionSort();
		System.out.print("Enter some numbers like 1,6,3,6,9,2 : ");
		String nums = System.console().readLine();
		String[] numbs = nums.split(",");
		int[] inputArray = new int[numbs.length];
		for (int i = 0 ; i < numbs.length ; i++) {
			inputArray[i] = Integer.parseInt(numbs[i]);
		}
		is.insertionSort(inputArray);
		System.out.println("Here are the sorted numbers using InsertionSort: ");
		for (int i : inputArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
