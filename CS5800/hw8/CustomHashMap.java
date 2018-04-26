import java.util.ArrayList;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class Node {

	String key;
	int value;
	Node next;

	public Node() {
		key = null;
		value = 0;
		next = null;
	}

	public Node(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}

class LinkedList {

	Node head;
	Node tail;

	public LinkedList() {
		this.head = new Node();
		this.tail = this.head;
	}

	public boolean add(String key, int value) {
		if(find(key) == -1) {
			this.tail.next = new Node(key, value);
			this.tail = tail.next;
			return true;
		} else {
			Node current = this.head.next;
			while(current != null) {
				if(current.key.equals(key)) current.value = value;
				current = current.next;
			}
			return false;
		}
		
	}

	public int find(String key) {
		Node current = this.head.next;
		while(current != null) {
			if(current.key.equals(key)) return current.value;
			current = current.next;
		}
		return -1;
	}

	public void delete(String key) {
		Node previous = null;
		Node current = this.head;
		if(current.key.equals(key)) {
			this.head = current.next;
			return;
		}
		previous = current;
		current = current.next;
		while(current != null) {
			if(current.key.equals(key)) {
				previous.next = current.next;
				return;
			}
			previous = current;
			current = current.next;
		}
	}

	/*public void printLL() {
		if(this.head != null) {
			Node current = this.head;
			System.out.print(current.key+", "+current.value);
			current = current.next;

			while(current != null) {
				System.out.print("->" + current.key+", "+current.value);
				current = current.next;
			}
			System.out.println();
			}
	} */
}

class SamanHashMap {

	final int HASH_TABLE_SIZE = 256;
	LinkedList[] table;

	public SamanHashMap() {
		table = new LinkedList[HASH_TABLE_SIZE];
	}

	private int hashFunction(String key) {
		int x = Math.abs(key.length() * 1024);
		return x%HASH_TABLE_SIZE;
	}

	public String insert(String key, int value) {
		int hashVal = hashFunction(key);
		if(table[hashVal] == null) table[hashVal] = new LinkedList();
		if(!this.table[hashVal].add(key,value)) return "Value, updated";
		return "Key, Value Added";
	}

	public void delete(String key) {
		int hashVal = hashFunction(key);
		if(table[hashVal] == null) return;
		this.table[hashVal].delete(key);
	}

	public void increase(String key, String newKey) {
		if(find(newKey) != -1 || find(key) == -1 || key.equals(newKey)) return;
		int value = find(key);
		insert(newKey, value);
		delete(key);
	}

	public int find(String key) {
		int hashVal = hashFunction(key);
		if(table[hashVal] == null) return -1;
		return this.table[hashVal].find(key);
	}

	public ArrayList<String> listAllKeys() {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0; i<HASH_TABLE_SIZE; i++) {
			if(this.table[i] == null) continue;
			Node current = this.table[i].head;
			while(current != null) {
				if(current.key != null) al.add(current.key);
				current = current.next;
			}
		}
		return al;
	}
}

public class CustomHashMap {

	public static void main(String[] args) {
		SamanHashMap shm = new SamanHashMap();
		String line;
		try (
    	InputStream fis = new FileInputStream("alice_in_wonderland.txt");
    	InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    	BufferedReader br = new BufferedReader(isr);
		) {
    		while ((line = br.readLine()) != null) {
    			String[] words = line.split(" ");
    			for(String word: words) {
    				word = word.replaceAll("[^\\dA-Za-z ]", "").toLowerCase();
    				int v = shm.find(word);
            		if(v == -1) shm.insert(word,1);
            		else shm.insert(word,v+1);
    			}
    		}

    		PrintWriter writer = new PrintWriter("word-count.txt", "UTF-8");
    		for(String s: shm.listAllKeys()) {
    			writer.println(s + " -> "+shm.find(s));
    		}
    		writer.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}	
}