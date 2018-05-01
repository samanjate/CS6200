package tests3d;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorters.HeapSorter;
import tests3b.SampleHeapSorterTests;
import types.Car;
import util.Sorter;

public class HeapSortMissedBranches extends SampleHeapSorterTests {

	/**
     * Method for creating a sorter. Modify this to use your own sorter.
     * @return
     */
    private static <T extends Comparable<T>> Sorter<T> createSorter(){
      return new HeapSorter<T>();
    }
    
	/**
     * This method tests a user-defined class that implements the Comparable interface
     */
    @Test
    public void testOneUserDefinedTypeNulls(){
      Sorter<Car> sorter = createSorter();
      Car[] people = { null, new Car("Ford", 1997), new Car("Chevy", 1996),
    		  new Car("Ferrari", 1991), null, new Car("Honda", 2015),
    		  new Car("Hundai", 2001), null, null, null ,null, null, new Car("Chevy", 2008)};
      sorter.sort(people);
      Car[] sorted = { null, null, null ,null, null, null, null,
    		  new Car("Ferrari", 1991), new Car("Chevy", 1996),
    		   new Car("Ford", 1997), new Car("Hundai", 2001),
    		  new Car("Chevy", 2008), new Car("Honda", 2015)};
      assertArrayEquals(people, sorted);
    }
}
