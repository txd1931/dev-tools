package devtools;

public class LinkedList<T> {
	private static class Node<T>{
		T value;
		Node<T> next; 
		Node(final T value){
			this.value = value;
			this.next = null;
		}
	}
	private final Class<T> type;
	private Node<T> head = null;
	private int size = 0;
	
	public LinkedList(Class<T> type){
		this.type = type;
	}
	
	public int size() {
		return size;
	}
	
	public void add(final int index, final T value) {
		if (index < 0) {
			throw new IndexOutOfBoundsException(index);
		}
		Node<T> newNode = new Node<>(value);
		if (head == null) {
			head = newNode;
		} else if (index == 0) {
			newNode.next = head; 
			head = newNode;
		} else if (index >= size) {
			getElement(size-1).next = newNode;
		} else {
			newNode.next = getElement(index);
			getElement(index-1).next = newNode;
		}
		size++;
		//System.out.println(size);
	}
	
	public void remove(final int index) {
		if(!elementAtIndexExists(index)){
			throw new IndexOutOfBoundsException(index);
		}

		if (index == 0){
			head = getElement(1);
		} else if (index == size-1) {
			getElement(index-1).next = null;
		} else {
			getElement(index-1).next = getElement(index+1);
		}
		--size;
	}
	
	public boolean elementAtIndexExists(final int index) {
		if(index < 0) {
			throw new IllegalArgumentException();
		}
		return index >= 0 && index < size; 
	}
	
	public T get(final int index){
		if(!elementAtIndexExists(index)) {
			throw new IndexOutOfBoundsException(index);
		}
		return getElement(index).value;
	}
	
	public boolean pop(){
		if (size == 0) {
			return false;
		}
		remove(size-1);
		return true;
	}
	
	public void push(final T value){
		add(size, value);
	}
	
	public void set(final int index, final T value){
		getElement(index).value = value;
	}
	
	public Class<T> getType() {
		return type;
	}
	/*public T[] toArray(){
		if(this.type == Integer) {
			
		}
		T[] array = 
		return array;
	}*/

	public void print(boolean... b){
		if (size == 0){
			System.out.println("No data on the list.");
		}
		System.out.print("[");
		for (int i = 0; i < size; i++) {
			System.out.print(getElement(i).value);
			if(i != size -1){
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	private Node<T> getElement(final int index){
		Node<T> currentNode = head;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
}