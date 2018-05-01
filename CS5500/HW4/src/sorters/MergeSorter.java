package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Sorter;

/**
 * A class that implements the Sorter interface and implements the merge 
 * sort Algorithm
 * 
 * @author Samanjate Sood
 * 
 * Credits: GeekForGeeks and CLRS
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(T[] list) {
		mergeSort(Arrays.asList(list), 0, list.length - 1);
	}
	
	/**
	 * A method to perform merge sort on a list representing the array
	 * 
	 * @param list a List of generic type
	 * @param l the start index of the list which needs to be sorted
	 * @param r the end index of the list that needs to be sorted
	 */
	private void mergeSort(List<T> list, int l, int r) {
		if (l < r)
        {
            int m = (l+r)/2;
 
            mergeSort(list, l, m);
            mergeSort(list , m+1, r);
 
            merge(list, l, m, r);
        }
	}
	
	/**
	 * A method used to merge the sorted left and right side of the list
	 * 
	 * @param list a List of generic type
	 * @param l the start index of the list which needs to be sorted
	 * @param m the middle index of the list which needs to be sorted
	 * @param r the end index of the array that needs to be sorted
	 */
	private void merge(List<T> list, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
 
        for (int i=0; i<n1; ++i) {
        		left.add(list.get(l + i));
        }
        for (int j=0; j<n2; ++j) {
        		right.add(list.get(m + 1+ j));
        }
 
        int i = 0;
        int j = 0;
        
        int k = l;
        while (i < n1 && j < n2) {
        		T lElement = left.get(i);
        		T rElement = right.get(j);
        		if (lElement == null 
        				|| (rElement != null && lElement.compareTo(rElement) <= 0)) {
                list.set(k, lElement);
                i++;
            } else {
                list.set(k, rElement);
                j++;
            }
            k++;
        }

        while (i < n1) {
        		list.set(k, left.get(i));
            i++;
            k++;
        }
        
        while (j < n2) {
        		list.set(k, right.get(j));
            j++;
            k++;
        }
    }

}
