package tests2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorters.HeapSorter;
import types.Car;
import util.Sorter;

public class HeapSorterTests {

	/**
     * Method for creating a sorter.
     * 
     * @return a sorted array
     */
    private static <T extends Comparable<T>> Sorter<T> createSorter(){
      return new HeapSorter<T>();
    }
    
    /**
     * This method tests when the String array is empty
     */
    @Test
    public void testEmptyArray() { 
      Sorter<String> sorter = createSorter();
      String[] emptyArray = {  };
      sorter.sort(emptyArray);
      String[] sorted = {  };
      assertArrayEquals(sorted, emptyArray);
    }
    
    /**
     * This method tests when the User-defined type array is empty
     */
    @Test
    public void testEmptyArrayUserType() { 
      Sorter<Car> sorter = createSorter();
      Car[] emptyArray = {  };
      sorter.sort(emptyArray);
      Car[] sorted = {  };
      assertArrayEquals(sorted, emptyArray);
    }
    
    /**
     * This method tests when there is just one element in the array and it is null
     */
    @Test
    public void testOneNull() { 
      Sorter<String> sorter = createSorter();
      String[] nullArray = { null };
      sorter.sort(nullArray);
      String[] sorted = { null };
      assertArrayEquals(sorted, nullArray);
    }
    
    /**
     * This method tests when there is just one element in the array and it is a number
     */
    @Test
    public void testOneNumber() { 
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { 1 };
      sorter.sort(OneElement);
      Integer[] sorted = { 1 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method tests when there is just one element in the array and it is a String
     */
    @Test
    public void testOneString() { 
      Sorter<String> sorter = createSorter();
      String[] OneElement = { "one" };
      sorter.sort(OneElement);
      String[] sorted = { "one" };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test an array of integers with positive values and zero
     */
    @Test
    public void testArrayPosIntegers() { 
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { 34, 12, 15, 20, 99, 102, 0 };
      sorter.sort(OneElement);
      Integer[] sorted = { 0, 12, 15, 20, 34, 99, 102 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test an array of integers with negative values and zero
     */
    @Test
    public void testArrayNegIntegers() { 
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { -344, -132, -1, -50, -19, -102, 0 };
      sorter.sort(OneElement);
      Integer[] sorted = { -344, -132, -102, -50, -19, -1, 0 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test an array of integers with positive, negative values, and zero
     */
    @Test
    public void testArrayMixIntegers() { 
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { -3144, 132, -1, 50, -19, -102, 0, 42, 59, 73, 711 };
      sorter.sort(OneElement);
      Integer[] sorted = { -3144, -102, -19, -1, 0, 42, 50, 59, 73, 132, 711 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test an array of floats with positive, negative values, and zero
     */
    @Test
    public void testArrayFloats() { 
      Sorter<Double> sorter = createSorter();
      Double[] OneElement = { -3144.52, 132.66, 132.32, -1.0, 50.0, -19.0, 
    		  -102.42, 0.00, 0.01, 42.13, 59.81, 59.82, 73.91, 71.51, -0.01 };
      sorter.sort(OneElement);
      Double[] sorted = { -3144.52, -102.42, -19.0, -1.0, -0.01, 0.00, 0.01, 42.13, 50.0,
    		  59.81, 59.82, 71.51, 73.91, 132.32, 132.66 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test an array of strings
     */
    @Test
    public void testArrayStrings() { 
      Sorter<String> sorter = createSorter();
      String[] OneElement = { "one", "two", "three", "four", "five" };
      sorter.sort(OneElement);
      String[] sorted = { "five", "four", "one", "three", "two"};
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method tests when all the elements in the Array are null
     */
    @Test
    public void testNullElements(){ 
      Sorter<String> sorter = createSorter();
      String[] nullArray = { null, null, null };
      sorter.sort(nullArray);
      String[] sorted = { null, null, null };
      assertArrayEquals(sorted, nullArray);
    }
    
    /**
     * This method tests when all the elements in the Array are same
     */
    @Test
    public void testSameElements(){ 
      Sorter<String> sorter = createSorter();
      String[] sameArray = { "one", "one", "one" };
      sorter.sort(sameArray);
      String[] sorted = { "one", "one", "one" };
      assertArrayEquals(sorted, sameArray);
    }
    
    /**
     * This method to test an array with duplicates
     */
    @Test
    public void testDuplicates() { 
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { 5, 2, 7, 9, 5, 2, 1 };
      sorter.sort(OneElement);
      Integer[] sorted = { 1, 2, 2, 5, 5, 7, 9 };
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method tests sorting a very large list
     */
    @Test
    public void testVeryLarge(){
      Sorter<Integer> sorter = createSorter();
      int VERY_LARGE = 10050000;
      Integer[] numbers = new Integer[VERY_LARGE];
      Integer[] sorted = new Integer[VERY_LARGE];
      for (int i=0; i < VERY_LARGE; i++){
        sorted[i] = i;
        numbers[VERY_LARGE-i-1] = i;
      }
      sorter.sort(numbers); 
      assertArrayEquals(numbers, sorted);
    }
    
    /**
     * This method tests the boundary integers are sorted, this tests if the algorithm
     * is dependent on the size of each input
     */
    @Test
    public void testIntegerBoundary(){
      Sorter<Integer> sorter = createSorter();
      Integer[] OneElement = { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
      sorter.sort(OneElement);
      Integer[] sorted = { Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
      assertArrayEquals(sorted, OneElement);
    }
    
    /**
     * This method to test if there are null within elements
     */
    @Test
    public void testNullWithinList(){ 
      Sorter<String> sorter = createSorter();
      String[] sameArray = { "one", null, null, null, "five", "eight" };
      sorter.sort(sameArray);
      String[] sorted = { null, null, null, "eight", "five", "one" };
      assertArrayEquals(sorted, sameArray);
    }
    
    /**
     * This method tests a user-defined class that implements the Comparable interface
     */
    @Test
    public void testOneUserDefinedType(){
      Sorter<Car> sorter = createSorter();
      Car[] people = { new Car("Ford", 1997) };
      sorter.sort(people);
      Car[] sorted = { new Car("Ford", 1997) };
      assertArrayEquals(people, sorted);
    }
    
    /**
     * This method tests a user-defined class that implements the Comparable interface
     */
    @Test
    public void testOneUserDefinedTypeMany(){
      Sorter<Car> sorter = createSorter();
      Car[] people = { new Car("Ford", 1997), new Car("Chevy", 1996),
    		  new Car("Ferrari", 1991), new Car("Honda", 2015),
    		  new Car("Hundai", 2001), new Car("Chevy", 2008)};
      sorter.sort(people);
      Car[] sorted = { new Car("Ferrari", 1991), new Car("Chevy", 1996),
    		   new Car("Ford", 1997), new Car("Hundai", 2001),
    		  new Car("Chevy", 2008), new Car("Honda", 2015)};
      assertArrayEquals(people, sorted);
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
    
    /**
     * This method tests a user-defined class that implements the Comparable interface
     */
    @Test
    public void testOneUserDefinedTypeRepeated(){
      Sorter<Car> sorter = createSorter();
      Car[] people = { new Car("Ford", 1997), new Car("Chevy", 2008),
    		  new Car("Hundai", 2001), new Car("Chevy", 2008), new Car("Chevy", 2008)};
      sorter.sort(people);
      Car[] sorted = { new Car("Ford", 1997), new Car("Hundai", 2001), 
    		  new Car("Chevy", 2008), new Car("Chevy", 2008), new Car("Chevy", 2008)};
      assertArrayEquals(people, sorted);
    }
}