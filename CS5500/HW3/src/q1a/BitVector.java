package q1a;

/**
 * An implementation of the IBitVector interface
 * 
 * @author Samanjate Sood
 *
 */
public class BitVector implements IBitVector {
	
	private int[] vector;
	private int numOfBits;
	
	/**
	 * Initializes the BitVector with minimum space requirements initially
	 */
	public BitVector() {
		vector = new int[1];
		numOfBits = 32;
	}

	/**
	 * @param An integer value
	 * 
	 * @return true iff the given integer is in the set represented by the BitVector
	 */
	public boolean get(int i) {
		if(i <= 0 || i > numOfBits) {
			return false;
		}
		return (vector[target(i-1)] & 1 << ((i-1) % 32)) != 0;
	}

	/**
	 * @param An integer value that is to be added to the set
	 * 
	 * sets the bit which represents the presence of the given integer in the set
	 */
	public void set(int i) {
		if(i <= 0) {
			return;
		} else if(i > numOfBits) {
			int newSize = target(i-1) + 1;
			int[] temp = new int[newSize];
			for(int j = 0; j < vector.length; j++) {
				temp[j] = vector[j];
			}
			vector = temp;
			numOfBits = newSize * 32;
		}
		int mask = 1 << (i-1);
		vector[target(i-1)] |= mask;
	}
	
	/**
	 * @param An integer value that needs to be removed from the set
	 * 
	 * Removes the integer from the set if it exists
	 */
	public void clear(int i) {
		if(i <= 0 || i > numOfBits) {
			return;
		}
		vector[target(i-1)] &= ~(1 << ((i-1) % 32));
	}

	/**
	 * @param A BitVector
	 * 
	 * does a "union" operation with the provided BitVector without affected it.
	 */
	public void copy(BitVector b) {
		int valToBeCopied = b.size();
		int[] values = new int[valToBeCopied];
		int index = 0;
		int i = 0;
		while(valToBeCopied > 0) {
			if(b.get(index)) {
				values[i++] = index;
				valToBeCopied--;
			}
			index++;
		}
		for(int j = 0; j < b.size(); j++) {
			this.set(values[j]);
		}
	}

	/**
	 * @return the number of elements in the set represented by the BitVector
	 */
	public int size() {
		int count = 0;
		for(int i = 0; i < vector.length; i++) {
			int element = vector[i];
			while (element > 0)
	        {
	            count += element & 1;
	            element >>= 1;
	        }
			if(element < 0) {
				count++;
			}
		}
		return count;
	}

	public Iterator<Integer> iterator() {
		return null;
	}
	
	/**
	 * Helper function.
	 * 
	 * @param bit
	 * @return the index in the BitVector array where the provided bit is represented at 
	 */
	private int target(int bit) {
		int target = -1;
		while (bit >= 0) {
			bit -= 32; 
			target++;
		}
		return target;
	}
}
