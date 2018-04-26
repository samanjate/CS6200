public class MergeSort {

	int[] merger(int[] left, int[] right) {
		int m = left.length;
		int n = right.length;
		int[] merged = new int[m+n];
		int i, j;
		i = j = 0;
		for(int s = 0 ; s < merged.length ; s++) {
			if(i < m && j < n) {
				if(left[i] > right[j]) {
					merged[s] = right[j];
					j++;
					continue;
				}
				else {
					merged[s] = left[i];
					i++;
					continue;
				}
			}
			else if(i >= m) {
				for (int p = j ; p < n; p++) {
					merged[s] = right[p];
					s++;
				}
				break;
			}
			else {
				for (int p = i ; p < m; p++) {
					merged[s] = left[p];
					s++;
				}
				break;
			}
		}
		return merged;
	}

	int[] mergeSort(int[] arr) {
		int l = arr.length;
		if (l == 1) {
			return arr;
		}
		int[] left = new int[l/2];
		int[] right;
		if (l % 2 == 0) {
			right = new int[l/2];
		}
		else {
			right = new int[l/2 + 1];
		}
		for (int i = 0 ; i < l/2 ; i++) {
			left[i] = arr[i];
		}
		for (int i = l/2 ; i < l ; i++) {
			right[i-l/2] = arr[i];
		}
		left = mergeSort(left);
		right = mergeSort(right);
		return merger(left, right);
	}

	public static void main(String [] args) {
		MergeSort m = new MergeSort();
		System.out.print("Enter some numbers like 1,6,3,6,9,2 : ");
		String nums = System.console().readLine();
		String[] numbs = nums.split(",");
		int[] inputArray = new int[numbs.length];
		for (int i = 0 ; i < numbs.length ; i++) {
			inputArray[i] = Integer.parseInt(numbs[i]);
		}
		int[] outputArray = m.mergeSort(inputArray);
		System.out.println("Here are the sorted numbers using MergeSort: ");
		for (int i : outputArray) {
			System.out.print(i + " ");
		}
		
	}
}