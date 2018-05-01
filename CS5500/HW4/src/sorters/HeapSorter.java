package sorters;

import util.Sorter;

/**
 * A class that implements the Sorter interface and implements the heap 
 * sort Algorithm
 * 
 * @author Samanjate Sood
 * 
 * Credits: GeekForGeeks and CLRS
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(T[] list) {
		int n = list.length;
		
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);
        
        for (int i=n-1; i>=0; i--)
        {
            T temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapify(list, i, 0);
        }
	}
	
	/**
	 * A method used to create a max heap
	 * 
	 * @param list an array of the generic type
	 * @param n the end index of the array where the algorithm stops
	 * @param i the index of the array representing the node of the heap
	 */
	void heapify(T[] list, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        	
        if(l < n 
    			&& (list[largest] == null 
    			|| (list[l] != null && list[l].compareTo(list[largest]) > 0))) {
    			largest = l;
    		}
        
        if(r < n 
			&& (list[largest] == null 
			|| (list[r] != null && list[r].compareTo(list[largest]) > 0))) {
				largest = r;
		}
        
        if(list[largest] == null) {
        		return;
        }

        if (largest != i)
        {
            T temp = list[i];
            list[i] = list[largest];
            list[largest] = temp;

            heapify(list, n, largest);
        }
    }

}
