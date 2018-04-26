public class QuickSort {

	int partition(int[] A, int p, int r) {
		int i = p - 1;
		int x = A[r];
		int temp = 0;
		for (int j = p; j < r; j++) {
			if (A[j] < x) {
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		A[r] = A[i+1];
		A[i+1] = x;
		return i+1;
	}

	void quickSort(int[] A, int p, int r) {
		int q = 0;
		if (p < r) {
			q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();
		System.out.println("Enter numbers e.g 10,7,4,6,3,7,8,9,11,34,21 : ");
		String input = System.console().readLine();
		String[] input_array_string = input.split(",");
		int[] A = new int[input_array_string.length];
		int index = 0;
		for(String s : input_array_string) {
			A[index] = Integer.parseInt(s);
			index++;
		}
		qs.quickSort(A,0,A.length-1);
		System.out.println("The sorted numbers using QuickSort are : ");
		for(int i : A) {
			System.out.print(i+" ");
		}

	}
}